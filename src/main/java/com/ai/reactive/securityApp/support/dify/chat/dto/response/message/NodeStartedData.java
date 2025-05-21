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

import java.util.Map;

/**
 * @author j
 * @version 1.0
 * @since 2025/4/15 17:46
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NodeStartedData extends CompletionData {

    private String id;

    @JsonProperty("nodeId")
    @JsonAlias("node_id")
    private String nodeId;

    @JsonProperty("nodeType")
    @JsonAlias("node_type")
    private String nodeType;

    private String title;

    private Integer index;

    @JsonProperty("predecessorNodeId")
    @JsonAlias("predecessor_node_id")
    private String predecessorNodeId;

    private Map<String, Object> inputs;

    @JsonProperty("createdAt")
    @JsonAlias("created_at")
    private Long createdAt;

}
