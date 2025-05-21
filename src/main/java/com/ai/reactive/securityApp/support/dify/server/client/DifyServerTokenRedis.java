/*
 * Copyright (c) 2025-2025, fubluesky (fubluesky@foxmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ai.reactive.securityApp.support.dify.server.client;

import cn.hutool.core.util.StrUtil;
import com.ai.reactive.securityApp.support.dify.server.cache.DifyRedisKey;
import com.ai.reactive.securityApp.support.dify.server.dto.response.LoginResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;

import java.util.concurrent.TimeUnit;

/**
 * @author j
 * @version 1
 * @since 2025/4/9 13:28
 */
@Slf4j
public class DifyServerTokenRedis extends BaseDifyServerToken {

    private static final long TOKEN_EXPIRE_MINUTES = 60;

    private final RedisTemplate<String, String> redisTemplate;

    public DifyServerTokenRedis(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void addAuthorizationHeader(HttpHeaders headers, DifyServerClient difyServerClient) {
        String accessToken = redisTemplate.opsForValue().get(DifyRedisKey.ACCESS_TOKEN);
        if (StrUtil.isEmpty(accessToken)) {
            accessToken = obtainToken(difyServerClient);
        }
        headers.setBearerAuth(accessToken);
    }

    public String obtainToken(DifyServerClient difyServerClient) {
        LoginResponseVO loginResponse = difyServerClient.login();
        if (loginResponse != null) {
            String accessToken = loginResponse.getAccessToken();
            redisTemplate.opsForValue().set(DifyRedisKey.ACCESS_TOKEN, accessToken);
            redisTemplate.expire(DifyRedisKey.ACCESS_TOKEN, TOKEN_EXPIRE_MINUTES, TimeUnit.MINUTES);
            redisTemplate.opsForValue().set(DifyRedisKey.REFRESH_TOKEN, loginResponse.getRefreshToken());
            return accessToken;
        }
        return null;
    }

    /**
     * refresh or obtain new token
     */
    @Override
    public void refreshOrObtainNewToken(DifyServerClient difyServerClient) {
        String refreshToken = redisTemplate.opsForValue().get(DifyRedisKey.REFRESH_TOKEN);
        if (refreshToken != null) {
            LoginResponseVO response = difyServerClient.refreshToken(refreshToken);
            if (response != null) {
                String accessToken = response.getAccessToken();
                redisTemplate.opsForValue().set(DifyRedisKey.ACCESS_TOKEN, accessToken);
                redisTemplate.expire(DifyRedisKey.ACCESS_TOKEN, TOKEN_EXPIRE_MINUTES, TimeUnit.MINUTES);
                redisTemplate.opsForValue().set(DifyRedisKey.REFRESH_TOKEN, response.getRefreshToken());
                return;
            }
        }
        // 如果刷新token失败或没有刷新token，则重新登录
        LoginResponseVO loginResponse = difyServerClient.login();
        if (loginResponse != null) {
            String accessToken = loginResponse.getAccessToken();
            redisTemplate.opsForValue().set(DifyRedisKey.ACCESS_TOKEN, accessToken);
            redisTemplate.expire(DifyRedisKey.ACCESS_TOKEN, TOKEN_EXPIRE_MINUTES, TimeUnit.MINUTES);
            redisTemplate.opsForValue().set(DifyRedisKey.REFRESH_TOKEN, loginResponse.getRefreshToken());
        }

    }
}
