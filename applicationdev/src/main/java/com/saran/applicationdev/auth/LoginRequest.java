package com.saran.applicationdev.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class LoginRequest {
    private String email;
    private String password;
}
