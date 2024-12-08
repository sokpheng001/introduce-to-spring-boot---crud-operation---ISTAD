package com.example.demo.api.v1.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String uuid;
    private String name;
    private String email;
    private String password;
    private String profile;
    private String bio;
    private Boolean isDeleted;
    private Boolean isVerified;
}
