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
package com.ai.reactive.securityApp.support.dify.workflow.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author j
 * @version 1.0
 * @since 2025/3/11 14:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WorkflowRunRequest extends BaseWorkflowRequest implements Serializable {
    private static final long serialVersionUID = -6104692859724501911L;

    /**
     * 文件
     */
    private List<WorkflowFile> files;

    /**
     * 自定义参数
     */
    private Map<String, Object> inputs;


    @Data
    public static class WorkflowFile {
        private String type = "image";
        private String transferMethod = "remote_url";
        private String url;
    }
}
