package com.ai.reactive.securityApp.model;


import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserParam {

    @NotEmpty
    @Length(min = 4, max = 30)
    private String userId;

    @NotEmpty
    @Length(min = 8, max = 50)
    private String password;
}