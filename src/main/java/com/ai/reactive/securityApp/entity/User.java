package com.ai.reactive.securityApp.entity;

import java.io.Serializable;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user")
@Data
@ToString
@EqualsAndHashCode(of = {"userId"})
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    private String userId;

    private String password;
}