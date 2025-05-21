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
package com.ai.reactive.securityApp.config.dify;

import com.ai.reactive.securityApp.client.dify.server.DifyServerDefaultClient;
import com.ai.reactive.securityApp.config.DifyProperties;
import com.ai.reactive.securityApp.support.dify.server.DifyServer;
import com.ai.reactive.securityApp.support.dify.server.client.BaseDifyServerToken;
import com.ai.reactive.securityApp.support.dify.server.client.DifyServerClient;
import com.ai.reactive.securityApp.support.dify.server.client.DifyServerTokenDefault;
import com.ai.reactive.securityApp.support.dify.server.impl.DifyServerClientImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author j
 * @version 1.0
 * @since 2025/3/18 16:17
 */
@Slf4j
@Configuration
@AutoConfigureAfter(DifyServerRedisTokenAutoConfiguration.class)
@ConditionalOnClass({DifyServerClient.class})
public class DifyServerAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(BaseDifyServerToken.class)
    public BaseDifyServerToken difyServerToken() {
        return new DifyServerTokenDefault();
    }

    @Bean
    @ConditionalOnMissingBean(DifyServerClient.class)
    public DifyServerClient difyServerClient(DifyProperties properties,
                                             BaseDifyServerToken difyServerToken,
                                             ObjectProvider<RestClient.Builder> restClientBuilderProvider,
                                             ObjectProvider<WebClient.Builder> webClientBuilderProvider) {
        return new DifyServerDefaultClient(properties.getServer(),
                difyServerToken,
                properties.getUrl(),
                properties.getClientConfig(),
                restClientBuilderProvider.getIfAvailable(RestClient::builder),
                webClientBuilderProvider.getIfAvailable(WebClient::builder));
    }

    @Bean
    @ConditionalOnMissingBean({DifyServer.class})
    public DifyServerClientImpl difyServerHandler(DifyServerClient difyServerClient) {
        return new DifyServerClientImpl(difyServerClient);
    }
}
