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
package com.ai.reactive.securityApp.support.dify.dataset.enums.document;

/**
 * @author j
 * @version 1.0
 * @since 2025/3/13 15:20
 */
public enum PreProcessingRuleTypeEnum {
    /**
     * 替换连续空格、换行符、制表符
     */
    remove_extra_spaces,
    /**
     * 删除 URL、电子邮件地址
     */
    remove_urls_emails
}
