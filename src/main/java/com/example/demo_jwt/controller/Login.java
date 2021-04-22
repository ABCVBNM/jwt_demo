package com.example.demo_jwt.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo_jwt.model.Result;
import com.example.demo_jwt.model.User;
import com.example.demo_jwt.service.TokenUtilService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Login
 *
 * @author LINMINGLE
 * @version 1.0
 * 2021/4/20 15:41
 **/

@Controller
public class Login {
    public static String userName = "li";
    public static String passWord = "lei";
    public static String admin = "1";

    @Resource(name = "tokenUtilService")
    TokenUtilService tokenUtilService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        Result result = new Result();
        if (user.getUserName().equals(userName) && user.getPassWord().equals(passWord)) {
            user.setAdmin(admin);
            user.setWarehouseName("深圳实验室");
            result.setMsg("success!");
            result.setCode("200");
            result.setToken(tokenUtilService.getToken(user));
        } else {
            result.setMsg("fail");
            result.setCode("404");
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getUserInfo")
    @ResponseBody
    public HashMap getUserInfoByToken(String token) {
        HashMap map = tokenUtilService.parseToken(token);
        return map;
    }

}
