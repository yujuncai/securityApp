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
package com.ai.reactive.securityApp.support.dify.chat.constant;

/**
 * 常量
 *
 * @author j
 * @version 1.0
 * @since 2025/3/4 14:33
 */
public interface ChatUriConstant {

    String V1_URL = "/v1";

    String V1_CHAT_MESSAGES_URI = V1_URL + "/chat-messages";

    String V1_CONVERSATIONS_URI = V1_URL + "/conversations";

    String V1_MESSAGES_URI = V1_URL + "/messages";

    String V1_PARAMETERS_URI = V1_URL + "/parameters";

    String V1_TEXT_TO_AUDIO_URI = V1_URL + "/text-to-audio";

    String V1_AUDIO_TO_TEXT_URI = V1_URL + "/audio-to-text";

}
