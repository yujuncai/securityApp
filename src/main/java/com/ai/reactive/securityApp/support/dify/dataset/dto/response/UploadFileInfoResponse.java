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

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * @author j
 * @version 1.0
 * @since 2025/3/13 17:38
 */
@Data
public class UploadFileInfoResponse implements Serializable {
    private static final long serialVersionUID = 487590129337348606L;

    private String id;
    private String name;
    private Integer size;
    private String extension;
    private String url;
    @JsonAlias("download_url")
    private String downloadUrl;
    @JsonAlias("mine_type")
    private String mimeType;
    @JsonAlias("created_by")
    private String createdBy;
    @JsonAlias("created_at")
    private Long createdAt;

}
