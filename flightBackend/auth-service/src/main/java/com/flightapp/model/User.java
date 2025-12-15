package com.flightapp.model;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

import lombok.Data;

@Entity
@Data
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     @Column(nullable = false,unique = true)
     private String username;
     
     @Column(nullable = false, unique = true)
     @Email
     private String email;
     
     @Column(nullable = false)
     private String password;
     
     @ElementCollection(fetch = FetchType.EAGER)
     @CollectionTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"))
     @Column(name = "role")
     private Set<String> roles;
     private boolean enabled = true;
     public User(String username, String email, String password, Set<String> roles) {
         this.username = username;
         this.email = email;
         this.password = password;
         this.roles = roles;
     }
}
