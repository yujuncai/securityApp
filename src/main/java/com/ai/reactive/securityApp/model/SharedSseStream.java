package com.ai.reactive.securityApp.model;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SharedSseStream {
    private final Sinks.Many<UserInfo> sink = Sinks.many().multicast().onBackpressureBuffer();

    // 获取共享的 Flux 流
    public Flux<UserInfo> getFlux() {
        return sink.asFlux();
    }

    // 向流中发布数据
    public void publish(UserInfo message) {
        sink.tryEmitNext(message);
    }
}