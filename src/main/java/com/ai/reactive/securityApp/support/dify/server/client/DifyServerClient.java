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

import com.ai.reactive.securityApp.support.dify.server.dto.response.ApiKeyResponseVO;
import com.ai.reactive.securityApp.support.dify.server.dto.response.AppsResponseVO;
import com.ai.reactive.securityApp.support.dify.server.dto.response.DatasetApiKeyResponseVO;
import com.ai.reactive.securityApp.support.dify.server.dto.response.LoginResponseVO;

import java.util.List;

/**
 * Dify Server Client Interface
 * Provides methods to interact with Dify's server API for managing applications,
 * API keys, authentication, and related operations.
 *
 * @author j
 * @version 1
 * @since 2025/4/9 10:14
 */
public interface DifyServerClient {

    /**
     * Retrieves a list of applications based on mode and name filter
     *
     * @param mode The application mode to filter by (e.g., "completion", "chat")
     * @param name The application name to search for
     * @return List of application responses matching the criteria
     */
    List<AppsResponseVO> apps(String mode, String name);

    /**
     * Retrieves detailed information about a specific application
     *
     * @param appId The ID of the application to retrieve
     * @return The application response containing detailed information
     */
    AppsResponseVO app(String appId);

    /**
     * Retrieves existing API keys for a specific application
     *
     * @param appId The ID of the application to get API keys for
     * @return List of API key responses associated with the application
     */
    List<ApiKeyResponseVO> getAppApiKey(String appId);

    /**
     * Initializes or regenerates API keys for a specific application
     *
     * @param appId The ID of the application to initialize API keys for
     * @return List of newly generated API key responses
     */
    List<ApiKeyResponseVO> initAppApiKey(String appId);

    /**
     * Retrieves existing API keys for datasets
     *
     * @return List of dataset API key responses
     */
    List<DatasetApiKeyResponseVO> getDatasetApiKey();

    /**
     * Initializes or regenerates API keys for datasets
     *
     * @return List of newly generated dataset API key responses
     */
    List<DatasetApiKeyResponseVO> initDatasetApiKey();

    /**
     * Authenticates with the Dify server and returns login credentials
     *
     * @return Login response containing access token and refresh token
     */
    LoginResponseVO login();

    /**
     * Refreshes an authentication token to maintain session validity
     *
     * @param refreshToken The refresh token used to obtain a new access token
     * @return Login response containing new access token and refresh token
     */
    LoginResponseVO refreshToken(String refreshToken);
}
