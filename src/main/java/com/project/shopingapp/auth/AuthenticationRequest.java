package com.project.shopingapp.auth;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class AuthenticationRequest {
    private String email;
    String password;
}
