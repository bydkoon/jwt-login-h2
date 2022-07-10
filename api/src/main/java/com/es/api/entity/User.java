package com.es.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Long id;

    @Column(name = "regNo", length = 50)
    private String email;


    @Column(name = "name")
    private String name;

    @Column(name = "password", length = 500)
    private String password;

    private Date updateDate;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }


}