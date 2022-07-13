package com.es.api.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class UserDTO {
    private long id;
    private String userId;
    private String password;
    private String regNo;
    private String name;
    private String roles = "";
    private String permissions = "";

}
