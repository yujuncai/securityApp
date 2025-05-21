package com.ai.reactive.securityApp.model;


import java.io.Serializable;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class UserInfo implements Serializable {

    private String userId;
}