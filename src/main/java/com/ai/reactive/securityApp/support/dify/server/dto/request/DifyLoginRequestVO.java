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
package com.ai.reactive.securityApp.support.dify.server.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * @author j
 * @version 1.0
 * @since 2024/12/31 14:17
 */
@Data
public class DifyLoginRequestVO implements Serializable {
    private static final long serialVersionUID = 7556073605254679649L;

    private String email;

    private String password;

    private String language;
    @JsonAlias("remember-me")
    private Boolean rememberMe;

    public static DifyLoginRequestVO build(String email, String password) {
        DifyLoginRequestVO vo = new DifyLoginRequestVO();
        vo.setEmail(email);
        vo.setPassword(password);
        vo.setLanguage("zh-Hans");
        vo.setRememberMe(true);
        return vo;
    }
}
