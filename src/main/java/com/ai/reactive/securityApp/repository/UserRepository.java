package com.ai.reactive.securityApp.repository;


import com.ai.reactive.securityApp.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);


    @Query(nativeQuery = true, value = "select * from user where user_id like %?1%")
    List<User> findEntity(String name);


    @Query(nativeQuery = true, value = "select * from user where user_id like %?1%")
    Page<User> findByNameLike(@Param("user_id") String name, Pageable pageable);
}