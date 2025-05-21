package com.ai.reactive.securityApp.api;

import com.ai.reactive.securityApp.entity.User;
import com.ai.reactive.securityApp.model.UserInfo;
import com.ai.reactive.securityApp.model.UserParam;
import com.ai.reactive.securityApp.utils.ReactiveRedisUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.WebSession;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@RestController
@RequestMapping(path = "/redis", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RequiredArgsConstructor
public class RedisController {
    @Autowired
    ReactiveRedisUtil redisUtil;

    @PostMapping(path = "/get")
    public Mono<User> get(@RequestBody  @Valid UserParam userParam) {
        User user = new User();
        user.setUserId(userParam.getUserId());
        user.setPassword(userParam.getPassword());
            String cacheKey = "user:" + userParam.getUserId();
            log.info("cacheKey---{}",cacheKey);
            return redisUtil.get(cacheKey)
                    .cast(User.class)
                    .switchIfEmpty(
                            Mono.defer(() -> redisUtil.set(cacheKey, user, Duration.ofMinutes(30)).thenReturn(user)
                            )
                    );
        }


    @PostMapping(path = "/set")
    public Mono<Boolean> set() {

        Flux<String> my = getString("my").map(s ->
                s + "   00000"
        ).doOnNext(s -> System.out.println(s));


        redisUtil.hSet("222","1111","11111").subscribe();
        return  Mono.just(true);


    }



    private Flux<String> getString(String k){


        return Flux.just("aaaaaaaaaaaaa"+k);
    }


}
