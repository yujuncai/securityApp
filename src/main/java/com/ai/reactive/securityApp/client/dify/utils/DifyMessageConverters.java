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
package com.ai.reactive.securityApp.client.dify.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClient;

import java.util.function.Consumer;

/**
 * @author j
 * @version 1
 * @since 2025/4/11 13:42
 */
public class DifyMessageConverters {

    public static Consumer<RestClient.Builder> messageConvertersConsumer() {
        return builder ->
                builder.messageConverters(ms -> ms.stream()
                        .filter(c -> c instanceof MappingJackson2HttpMessageConverter)
                        .findFirst()
                        .ifPresent(converter -> {
                            MappingJackson2HttpMessageConverter jacksonConverter = (MappingJackson2HttpMessageConverter) converter;
                            ObjectMapper objectMapper = jacksonConverter.getObjectMapper();
                            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                        }));
    }
}
