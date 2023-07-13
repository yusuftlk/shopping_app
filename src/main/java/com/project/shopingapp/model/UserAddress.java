package com.project.shopingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "useraddress")
public class UserAddress {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    @Lob
    @Column(columnDefinition = "text")
    private String addressText;
    private String city;
    private String district;

    public UserAddress(User user, String addressText, String city, String district) {
        this.user = user;
        this.addressText = addressText;
        this.city = city;
        this.district = district;
    }
}
