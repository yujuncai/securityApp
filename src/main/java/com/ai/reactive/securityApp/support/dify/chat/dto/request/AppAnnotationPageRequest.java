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
package com.ai.reactive.securityApp.support.dify.chat.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author j
 * @version 0.10.0
 * @since 2025/4/27 09:24
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AppAnnotationPageRequest extends BaseChatRequest implements Serializable {

    private static final long serialVersionUID = 6852829739740557565L;

    /**
     * 页码
     */
    private Integer page = 1;

    /**
     * 返回条数，默认 20，范围 1-100
     */
    private Integer limit = 20;
}
