package com.ai.reactive.securityApp.api;


import com.ai.reactive.securityApp.entity.User;
import com.ai.reactive.securityApp.model.SharedSseStream;
import com.ai.reactive.securityApp.model.UserInfo;
import com.ai.reactive.securityApp.model.UserParam;
import com.ai.reactive.securityApp.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable; // No longer used directly in method return types, but PageRequest is
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
// import reactor.core.scheduler.Schedulers; // No longer needed

import java.io.File;
import java.time.Duration;
// import java.util.List; // No longer returning Mono<List<User>>

@RestController
@RequestMapping(path = "/mysql", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RequiredArgsConstructor
public class SqlController {

    private final UserRepository userRepository;


    @PostMapping(path = "/page", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<User> page(@RequestBody @Valid UserParam userParam) {

        PageRequest pageRequest = PageRequest.of(0, 10); // Assuming UserParam doesn't carry page/size or using defaults

        return userRepository.findByNameLike(userParam.getUserId(), pageRequest);
    }

    @PostMapping(path = "/list", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Flux<User> list(@RequestBody @Valid UserParam userParam) {

        return userRepository.findEntity(userParam.getUserId());
    }

    @PostMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<UserInfo> getRealTimeEvents() {
        return Flux.interval(Duration.ofSeconds(10)) // 每秒生成一个事件
                .map(sequence -> UserInfo.builder()
                        .userId(String.valueOf(sequence))
                        .build());
    }





        private final SharedSseStream sharedSseStream = new SharedSseStream();

        // SSE 接口，由线程 A 处理
        @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
        public Flux<UserInfo> streamEvents() {
            return sharedSseStream.getFlux();
        }

        // 模拟线程 B 发布数据
        @PostMapping("/publish")
        public ResponseEntity<Void> publishMessage(@RequestBody UserInfo message) {
            message.setUserId("123999999999999999999999999999999999");
            sharedSseStream.publish(message);
            return ResponseEntity.ok().build();
        }




    @PostMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> getSseStream() {


        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

        // 使用 WebClient 获取远程 SSE 数据流
        Flux<UserInfo> remoteSseStream = webClient.post()
                .uri("/mysql/events") // 目标 SSE 端点
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(UserInfo.class);


        return  Flux.merge(remoteSseStream,  sharedSseStream.getFlux())
                .map(data -> {
                    String wrappedData = "Wrapped: " + data; // 包装数据
                    return  ServerSentEvent.builder(wrappedData).build();
                });



    }
}



