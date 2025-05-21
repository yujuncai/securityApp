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
package com.ai.reactive.securityApp.support.dify.server.impl;


import com.ai.reactive.securityApp.support.dify.server.DifyServer;
import com.ai.reactive.securityApp.support.dify.server.client.DifyServerClient;
import com.ai.reactive.securityApp.support.dify.server.dto.response.ApiKeyResponseVO;
import com.ai.reactive.securityApp.support.dify.server.dto.response.AppsResponseVO;
import com.ai.reactive.securityApp.support.dify.server.dto.response.DatasetApiKeyResponseVO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author j
 * @version 1
 * @since 2025/4/9 10:42
 */
@Slf4j
public class DifyServerClientImpl implements DifyServer {

    private final DifyServerClient difyServerClient;

    public DifyServerClientImpl(DifyServerClient difyServerClient) {
        this.difyServerClient = difyServerClient;
    }

    @Override
    public List<AppsResponseVO> apps(String mode, String name) {
        return difyServerClient.apps(mode, name);
    }

    @Override
    public AppsResponseVO app(String appId) {
        return difyServerClient.app(appId);
    }

    @Override
    public List<ApiKeyResponseVO> getAppApiKey(String appId) {
        return difyServerClient.getAppApiKey(appId);
    }

    @Override
    public List<ApiKeyResponseVO> initAppApiKey(String appId) {
        return difyServerClient.initAppApiKey(appId);
    }

    @Override
    public List<DatasetApiKeyResponseVO> getDatasetApiKey() {
        return difyServerClient.getDatasetApiKey();
    }

    @Override
    public List<DatasetApiKeyResponseVO> initDatasetApiKey() {
        return difyServerClient.initDatasetApiKey();
    }
}
