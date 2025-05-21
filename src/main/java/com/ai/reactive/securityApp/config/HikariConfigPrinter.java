package com.ai.reactive.securityApp.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HikariConfigPrinter implements CommandLineRunner {

    @Autowired
    private HikariDataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("HikariCP Configuration:");
        System.out.println("Minimum Idle: " + dataSource.getMinimumIdle());
        System.out.println("Maximum Pool Size: " + dataSource.getMaximumPoolSize());
        System.out.println("Connection Timeout: " + dataSource.getConnectionTimeout());
        System.out.println("Idle Timeout: " + dataSource.getIdleTimeout());
        System.out.println("Validation Timeout: " + dataSource.getValidationTimeout());
    }
}