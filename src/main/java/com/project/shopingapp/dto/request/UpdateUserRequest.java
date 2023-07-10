package com.project.shopingapp.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {
    private String name;
    private String surname;
    private String number;
    private String password;
}
