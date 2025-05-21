package com.ai.reactive.securityApp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveSubscription;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Collections;

/**
 * 响应式Redis操作工具类
 * 支持Reactive编程模型，包含：
 * 1. 异步Key/Value操作
 * 2. 响应式Hash/List/Set/ZSet操作
 * 3. 响应式分布式锁
 * 4. 发布订阅支持
 */
@Component
public class ReactiveRedisUtil {
    private final ReactiveRedisTemplate<String, Object> reactiveTemplate;
    private final ReactiveValueOperations<String, Object> valueOps;
    private final ReactiveHashOperations<String, Object, Object> hashOps;
    private final ReactiveListOperations<String, Object> listOps;
    private final ReactiveSetOperations<String, Object> setOps;
    private final ReactiveZSetOperations<String, Object> zSetOps;

    @Autowired
    public ReactiveRedisUtil(ReactiveRedisTemplate<String, Object> reactiveTemplate) {
        this.reactiveTemplate = reactiveTemplate;
        this.valueOps = reactiveTemplate.opsForValue();
        this.hashOps = reactiveTemplate.opsForHash();
        this.listOps = reactiveTemplate.opsForList();
        this.setOps = reactiveTemplate.opsForSet();
        this.zSetOps = reactiveTemplate.opsForZSet();
    }

    // ======================= Key/Value 操作 =======================

    /**
     * 异步设置缓存（带过期时间）
     * @param key 键
     * @param value 值
     * @param timeout 过期时间
     * @return Mono<Boolean> 设置是否成功
     */
    public Mono<Boolean> set(String key, Object value, Duration timeout) {
        return valueOps.set(key, value, timeout);
    }

    /**
     * 异步获取缓存
     * @param key 键
     * @return Mono<Object> 异步结果
     */
    public Mono<Object> get(String key) {
        return valueOps.get(key);
    }

    // ======================= Hash 操作 =======================

    /**
     * 异步设置Hash字段
     * @param key 键
     * @param hashKey Hash键
     * @param value 值
     * @return Mono<Boolean> 操作结果
     */
    public Mono<Boolean> hSet(String key, Object hashKey, Object value) {
        return hashOps.put(key, hashKey, value);
    }

    /**
     * 异步获取Hash字段
     * @param key 键
     * @param hashKey Hash键
     * @return Mono<Object> 异步结果
     */
    public Mono<Object> hGet(String key, Object hashKey) {
        return hashOps.get(key, hashKey);
    }

    // ======================= 分布式锁 =======================

    /**
     * 响应式分布式锁
     * @param lockKey 锁Key
     * @param requestId 请求ID
     * @param expireTime 过期时间
     * @return Mono<Boolean> 是否获取成功
     */
    public Mono<Boolean> tryLock(String lockKey, String requestId, Duration expireTime) {
        return valueOps.setIfAbsent(lockKey, requestId, expireTime);
    }

    /**
     * 释放锁（Lua脚本保证原子性）
     * @param lockKey 锁Key
     * @param requestId 请求ID
     * @return Flux<Long> 1-释放成功 0-释放失败
     */
    public Flux<Long> releaseLock(String lockKey, String requestId) {
        String script =
                "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                        "   return redis.call('del', KEYS[1]) " +
                        "else " +
                        "   return 0 " +
                        "end";

        return reactiveTemplate.execute(
                new DefaultRedisScript<>(script, Long.class),
                Collections.singletonList(lockKey),
                requestId
        );
    }

    // ======================= 发布订阅 =======================

    /**
     * 发布消息到频道
     * @param channel 频道名称
     * @param message 消息内容
     * @return Mono<Long> 接收到消息的客户端数量
     */
    public Mono<Long> publish(String channel, Object message) {
        return reactiveTemplate.convertAndSend(channel, message);
    }

    /**
     * 订阅频道
     * @param channel 频道名称
     * @return Flux<Object> 消息流
     */
    public Flux<Object> subscribe(String channel) {
        return reactiveTemplate.listenToChannel(channel)
                .map(ReactiveSubscription.Message::getMessage);
    }



}