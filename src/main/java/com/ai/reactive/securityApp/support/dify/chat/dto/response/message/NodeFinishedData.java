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
package com.ai.reactive.securityApp.support.dify.chat.dto.response.message;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author j
 * @version 1.0
 * @since 2025/4/15 17:49
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class NodeFinishedData extends NodeStartedData {

    @JsonProperty("processData")
    @JsonAlias("process_data")
    private Map<String, Object> processData;

    private Map<String, Object> outputs;

    private String status;
    private String error;

    @JsonProperty("elapsedTime")
    @JsonAlias("elapsed_time")
    private Integer elapsedTime;

    @JsonProperty("executionMetadata")
    @JsonAlias("execution_metadata")
    private ExecutionMetadata executionMetadata;

    @Data
    public static class ExecutionMetadata {

        @JsonProperty("totalTokens")
        @JsonAlias("total_tokens")
        private Integer totalTokens;

        @JsonProperty("totalPrice")
        @JsonAlias("total_price")
        private BigDecimal totalPrice;

        /**
         * optional e.g. USD / RMB
         */
        private String currency;

    }
}
