package com.example.demo_jwt.controller;

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
 * OnlyTest
 * 没啥用，可跳过
 *
 * @author LINMINGLE
 * @version 1.0
 * 2021/4/20 18:13
 **/

@Controller
public class OnlyTest {

    @Resource(name = "tokenUtilService")
    TokenUtilService tokenUtilService;

    @RequestMapping(method = RequestMethod.POST, value = "parseToken")
    @ResponseBody
    public void parseToken(String token) {
        if (token == null) System.out.println("token不存在");
        HashMap userMap = tokenUtilService.parseToken(token);
    }


}
