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
package com.ai.reactive.securityApp.support.dify.dataset.dto.request.file;

import org.springframework.web.multipart.MultipartFile;

/**
 * File Operation Interface
 * Defines operations for handling file uploads in Dify dataset requests.
 * This interface is implemented by request classes that need to accept
 * and process file uploads as part of their functionality.
 *
 * @author j
 * @version 1.0
 * @since 2025/4/17 17:28
 */
public interface FileOperation {

    /**
     * Sets a file to be used in a dataset operation
     *
     * @param file The MultipartFile to be processed as part of a dataset request
     */
    public void setFile(MultipartFile file);
}
