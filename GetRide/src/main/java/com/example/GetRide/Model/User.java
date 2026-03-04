package com.example.GetRide.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String email;     // login email

    @Column(nullable = false)
    private String password;  // hashed password

    private String role;      // ROLE_ADMIN / ROLE_USER / ROLE_DRIVER
}
