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
 * @version 1
 * @since 2025/4/10 14:39
 */
@AllArgsConstructor
@Getter
public enum ModelStatusEnum {

    /**
     * active
     */
    ACTIVE("active"),

    NO_CONFIGURE("no-configure"),
    QUOTA_EXCEEDED("quota-exceeded"),
    NO_PERMISSION("no-permission"),
    DISABLED("disabled");

    @JsonValue
    private final String code;

    @JsonCreator
    public static ModelStatusEnum codeOf(String code) {
        for (ModelStatusEnum value : ModelStatusEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }
}
