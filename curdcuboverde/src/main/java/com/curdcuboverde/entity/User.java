package com.curdcuboverde.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import java.util.Set;

@Data
@Entity
@Table(name="Users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdUser;
    private String FistName;
    private String LastName;
    private String Phone;
    @Column(unique = true,nullable = false)
    private String Email;
    private Long IdRol;
    private String UserPassword;
    @Column(updatable = false)
    private String CreationDate;
    @Column(nullable = false)
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "userRoles",
            joinColumns = @JoinColumn(name = "IdUser"),
            inverseJoinColumns = @JoinColumn(name = "IdRol"))
    private Set<Role> roles;


}
