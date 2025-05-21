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
package com.ai.reactive.securityApp.support.dify.dataset.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author j
 * @version 1.0
 * @since 2025/4/10 14:46
 */
@AllArgsConstructor
@Getter
public enum ModelFeatureEnum {
    /**
     * tool-call
     */
    TOOL_CALL("tool-call"),
    MULTI_TOOL_CALL("multi-tool-call"),
    AGENT_THOUGHT("agent-thought"),
    VISION("vision"),
    STREAM_TOOL_CALL("stream-tool-call"),
    DOCUMENT("document"),
    VIDEO("video"),
    AUDIO("audio");

    @JsonValue
    private final String code;

    @JsonCreator
    public static ModelFeatureEnum codeOf(String code) {
        for (ModelFeatureEnum value : ModelFeatureEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
