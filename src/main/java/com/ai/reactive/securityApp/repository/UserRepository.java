package com.ai.reactive.securityApp.repository;

import com.ai.reactive.securityApp.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {

    Mono<User> findByUserId(String userId);

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE user_id LIKE CONCAT('%', :name, '%')")
    Flux<User> findEntity(@Param("name") String name);

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE user_id LIKE CONCAT('%', :name, '%')")
    Flux<User> findByNameLike(@Param("name") String name, Pageable pageable);
}