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
package com.ai.reactive.securityApp.support.dify.dataset.dto.request.document;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author j
 * @version 1.0
 * @since 2025/3/13 15:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Segmentation implements Serializable {

    /**
     * 自定义分段标识符，目前仅允许设置一个分隔符。默认为 \n
     */
    private String separator = "\\n";

    /**
     * 最大长度（token）默认为 1000
     */
    @JsonAlias("maxTokens")
    @JsonProperty("max_tokens")
    private Integer maxTokens = 1000;
}
