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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author j
 * @version 1.0
 * @since 2025/3/10 13:52
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageFeedbackRequest extends BaseChatRequest implements Serializable {
    private static final long serialVersionUID = 4128142587586940184L;

    /**
     * 消息 id
     */
    private String messageId;

    /**
     * 评级<br>
     * 点赞 like, 点踩 dislike, 撤销点赞 null
     */
    private Rating rating;

    /**
     * 消息反馈的具体信息
     */
    private String content;

    @Getter
    @AllArgsConstructor
    public enum Rating {
        /**
         * 点赞
         */
        LIKE("like"),
        /**
         * 点踩
         */
        DISLIKE("dislike"),
        /**
         * 撤销点赞
         */
        UNLIKE(null);

        private final String key;

        public static Rating keyOf(String key) {
            for (Rating rating : values()) {
                if (rating.getKey() != null && rating.getKey().equals(key)) {
                    return rating;
                }
            }
            return null;
        }
    }

}
