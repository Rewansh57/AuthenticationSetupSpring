package org.example.springsecuritylearning2.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;

@Entity
@Getter
@Setter

public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private int id;

    private String username;
    @Column(unique = true)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")


    )
    private Set<Role> roles;


}
