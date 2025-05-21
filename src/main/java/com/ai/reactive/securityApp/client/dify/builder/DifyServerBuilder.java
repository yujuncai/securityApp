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
package com.ai.reactive.securityApp.client.dify.builder;


import com.ai.reactive.securityApp.client.dify.server.DifyServerDefaultClient;
import com.ai.reactive.securityApp.config.DifyProperties;
import com.ai.reactive.securityApp.support.dify.server.DifyServer;
import com.ai.reactive.securityApp.support.dify.server.client.BaseDifyServerToken;
import com.ai.reactive.securityApp.support.dify.server.client.DifyServerClient;
import com.ai.reactive.securityApp.support.dify.server.client.DifyServerTokenDefault;
import com.ai.reactive.securityApp.support.dify.server.impl.DifyServerClientImpl;

/**
 * @author j
 * @version 0.9.0
 * @since 2025/4/18 09:53
 */
public class DifyServerBuilder {

    public static DifyServer create(DifyServerClient difyServerClient) {
        return new DifyServerClientImpl(difyServerClient);
    }

    /**
     * Builder for DifyServerClient
     */
    public static class DifyServerClientBuilder {
        public static DifyServerClient create(DifyProperties.Server difyServerProperties) {
            return new DifyServerDefaultClient(difyServerProperties);
        }

        public static DifyServerClient create(DifyProperties.Server difyServerProperties, String baseUrl) {
            return new DifyServerDefaultClient(difyServerProperties, new DifyServerTokenDefault(), baseUrl);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BaseDifyBuilder<Builder> {
            private DifyProperties.Server difyServerProperties;
            private BaseDifyServerToken difyServerToken;

            /**
             * Set server properties
             *
             * @param difyServerProperties the server properties
             * @return the builder
             */
            public Builder serverProperties(DifyProperties.Server difyServerProperties) {
                this.difyServerProperties = difyServerProperties;
                return this;
            }

            /**
             * Set server token
             *
             * @param difyServerToken the server token
             * @return the builder
             */
            public Builder serverToken(BaseDifyServerToken difyServerToken) {
                this.difyServerToken = difyServerToken;
                return this;
            }

            /**
             * Build the DifyServerClient
             *
             * @return the DifyServerClient
             */
            public DifyServerClient build() {
                initDefaults();

                if (difyServerProperties == null) {
                    difyServerProperties = new DifyProperties.Server();
                }
                if (difyServerToken == null) {
                    difyServerToken = new DifyServerTokenDefault();
                }

                return new DifyServerDefaultClient(difyServerProperties,
                        difyServerToken, baseUrl, clientConfig, restClientBuilder, webClientBuilder);
            }
        }
    }
}
