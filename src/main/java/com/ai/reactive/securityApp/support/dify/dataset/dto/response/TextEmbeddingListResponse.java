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
package com.ai.reactive.securityApp.support.dify.dataset.dto.response;

import com.ai.reactive.securityApp.support.dify.dataset.dto.response.textembedding.TextEmbedding;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author j
 * @version 1
 * @since 2025/4/10 13:54
 */
@Data
public class TextEmbeddingListResponse implements Serializable {

    private List<TextEmbedding> data;

}
