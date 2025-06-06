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
package com.ai.reactive.securityApp.support.dify.dataset.dto.request;

import com.ai.reactive.securityApp.support.dify.dataset.enums.MetaDataActionEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author j
 * @version 1.0
 * @since 2025/3/24 10:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MetaDataActionRequest extends BaseDatasetRequest implements Serializable {
    private static final long serialVersionUID = 6701409042040093766L;

    private String datasetId;

    private MetaDataActionEnum action;
}
