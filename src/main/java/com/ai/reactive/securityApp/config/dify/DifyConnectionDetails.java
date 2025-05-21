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

import org.springframework.boot.autoconfigure.service.connection.ConnectionDetails;

/**
 * Dify Connection Details Interface
 * Provides connection information required to establish a connection to the Dify API.
 * This interface is used by the Spring Boot auto-configuration to set up Dify clients
 * with the appropriate connection settings.
 * <p>
 * This interface extends Spring Boot's ConnectionDetails to integrate with
 * the standard connection management framework.
 *
 * @author j
 * @version 1
 * @since 2025/4/7 16:53
 */
public interface DifyConnectionDetails extends ConnectionDetails {

    /**
     * Retrieves the URL of the Dify API server
     *
     * @return The base URL string for the Dify API endpoint
     */
    String getUrl();
}
