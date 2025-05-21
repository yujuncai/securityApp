package com.ai.reactive.securityApp.config;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.server.session.HeaderWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

@Configuration
public class RedisConfig {




    @Value("${spring.redis.host}")
    public String redisHost;
    @Value("${spring.redis.port}")
    public int redisPort;
    @Value("$spring.redis.password")
    public String redisPassword;

@Bean
@Primary
    public  ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);
    configuration.setPassword(redisPassword);
    return new LettuceConnectionFactory(configuration);
}



    @Bean
    @Order(2)
    public ReactiveRedisTemplate<String, Object> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {

        ObjectMapper mapper = new ObjectMapper();
        // 关键配置：保存类型信息
        mapper.activateDefaultTyping(
                mapper.getPolymorphicTypeValidator(),
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.PROPERTY
        );
        Jackson2JsonRedisSerializer<Object> serializer =
                new Jackson2JsonRedisSerializer<>(mapper, Object.class);

        RedisSerializationContext<String, Object> context =
                RedisSerializationContext.<String, Object>newSerializationContext()
                        .key(StringRedisSerializer.UTF_8)          // Key使用字符串序列化
                        .value(serializer)                    // Value使用JSON序列化
                        .hashKey(StringRedisSerializer.UTF_8)      // Hash Key使用字符串序列化
                        .hashValue(serializer)                // Hash Value使用JSON序列化
                        .build();
        return new ReactiveRedisTemplate<>(factory, context);
    }

    @Bean
    public WebSessionIdResolver webSessionIdResolver() {
        HeaderWebSessionIdResolver sessionIdResolver = new HeaderWebSessionIdResolver();
        sessionIdResolver.setHeaderName("X-AUTH-TOKEN");
        return sessionIdResolver;
    }
}