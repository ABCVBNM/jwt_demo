package com.example.demo_jwt.model;

import lombok.Data;

/**
 * User
 *
 * @author LINMINGLE
 * @version 1.0
 * 2021/4/20 15:57
 **/

@Data
public class User {
    private String userName;
    private String passWord;
    private String admin;
    private String warehouseName;
}
