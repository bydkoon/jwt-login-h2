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
    private Long id;

    @Column(name ="userId", nullable = false)
    private String userId;

    @Column(name="regNo", length = 50)
    private String regNo;

//    @Column(name = "name")
    private String name;

    @Column(length = 500)
    private String password;



    public User(String userId, String regNo, String password, String name) {
        this.userId = userId;
        this.regNo = regNo;
        this.password = password;
        this.name = name;
    }


}