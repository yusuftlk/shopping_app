package com.project.shopingapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String number;
    private String email;
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private LocalDateTime creationDate;
    private Boolean status;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserAddress> userAddresses;

    public User(String name, String surname, String number, String email, String password, LocalDateTime creationDate, Boolean status) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.email = email;
        this.password = password;
        this.creationDate = creationDate;
        this.status = status;
        this.userAddresses = new ArrayList<>();
    }
}
