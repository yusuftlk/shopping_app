package com.project.shopingapp.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CreateUserRequest {
    private String name;
    private String surname;
    private String number;
    private String email;
    private String password;
}
