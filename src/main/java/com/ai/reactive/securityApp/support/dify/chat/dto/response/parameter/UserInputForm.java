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
package com.ai.reactive.securityApp.support.dify.chat.dto.response.parameter;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * @author j
 * @version 1.0
 * @since 2025/3/24 14:35
 */
@Data
public class UserInputForm implements Serializable {
    /**
     * text-input (object) 文本输入控件
     */
    @JsonAlias("text-input")
    private TextInput textInput;

    /**
     * paragraph(object) 段落文本输入控件
     */
    @JsonAlias("paragraph")
    private Paragraph paragraph;

    /**
     * select(object) 下拉控件
     */
    @JsonAlias("select")
    private Select select;
}
