
package com.ai.reactive.securityApp.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Dify 配置
 */
@Data
public class DifyProperties implements Serializable {

    private static final long serialVersionUID = 2857476370638253392L;
    /**
     * 服务地址
     */
    private String url;

    /**
     * 知识库
     */
    private Dataset dataset = new Dataset();

    /**
     * 后台服务
     */
    private Server server = new Server();

    /**
     * 请求配置
     */
    private ClientConfig clientConfig = new ClientConfig();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Dataset implements Serializable {
        private static final long serialVersionUID = -8070163136236819894L;
        private String apiKey;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Server implements Serializable {
        private static final long serialVersionUID = -8070163136236819894L;

        /**
         * email
         */
        private String email;

        /**
         * 密码
         */
        private String password;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ClientConfig implements Serializable {
        private static final long serialVersionUID = -8070163136236819894L;

        private Boolean skipNull = true;
    }
}
