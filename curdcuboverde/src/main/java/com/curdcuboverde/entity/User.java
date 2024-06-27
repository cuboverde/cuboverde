package com.curdcuboverde.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.Data;

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
    @Column(nullable = false)
    private Long IdRol;
    private String UserPassword;
    @Column(updatable = false)
    private String CreationDate;
}
