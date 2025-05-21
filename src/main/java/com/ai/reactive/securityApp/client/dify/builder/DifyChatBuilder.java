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


import com.ai.reactive.securityApp.client.dify.chat.DifyChatDefaultClient;
import com.ai.reactive.securityApp.support.dify.chat.DifyChat;
import com.ai.reactive.securityApp.support.dify.chat.client.DifyChatClient;
import com.ai.reactive.securityApp.support.dify.chat.impl.DifyChatClientImpl;

/**
 * @author j
 * @version 0.9.0
 * @since 2025/4/18 09:53
 */
public class DifyChatBuilder {

    public static DifyChat create(DifyChatClient difyChatClient) {
        return new DifyChatClientImpl(difyChatClient);
    }

    /**
     * Builder for DifyChatClient
     */
    public static class DifyChatClientBuilder {
        public static DifyChatClient create() {
            return new DifyChatDefaultClient();
        }

        public static DifyChatClient create(String baseUrl) {
            return new DifyChatDefaultClient(baseUrl);
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder extends BaseDifyBuilder<Builder> {
            /**
             * Build the DifyChatClient
             *
             * @return the DifyChatClient
             */
            public DifyChatClient build() {
                initDefaults();
                return new DifyChatDefaultClient(baseUrl, clientConfig, restClientBuilder, webClientBuilder);
            }
        }
    }
}
