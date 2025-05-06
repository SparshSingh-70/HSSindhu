package com.cdac.hss.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "username")
    private String username;

    @Column(name = "email", unique = true)
    private String email;
    private String password;
    private String mobile;
    private String designation;
    private String division;
    private char status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRole> userRoles;


    public User(String username, String email, String encode, String mobile,String designation) {
        this.username = username;
        this.email = email;
        this.password = encode;
        this.mobile = mobile;
        this.designation = designation;
    }
}
