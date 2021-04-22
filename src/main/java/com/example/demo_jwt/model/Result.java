package com.example.demo_jwt.model;

import lombok.Data;

/**
 * Result
 *
 * @author LINMINGLE
 * @version 1.0
 * 2021/4/20 16:19
 **/

@Data
public class Result {
    private Object data;
    private String msg;
    private String code;
    private String token;
}
