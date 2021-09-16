package com.example.demo.controller;
import com.example.demo.common.ApiResponse;
import com.example.demo.common.ClientResponse;
import com.example.demo.common.Authority;
import com.example.demo.common.User;
import com.example.demo.mirservice.ud.IUdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private IUdService service;
    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String IMG_PATH_PREFIX = "static";

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getname() {
        return "0.0.7";
    }




    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin
    public ApiResponse<Authority> login(@RequestBody Authority authority) throws Exception {

        if (authority.getPassword().equals("sunqi") && authority.getUsername().equals("sunqi")) {

           return ApiResponse.success(authority);
        }
       return  ApiResponse.error("密码账户错误");
    }


    @RequestMapping(value = "/getUd", method = RequestMethod.GET)
    @CrossOrigin
    public ApiResponse<List<User>> getUd(@RequestParam String host, @RequestParam String mobile) throws Exception {
        ClientResponse response = service.getUd(host,mobile);
        List<User> users = JSON.parseArray(response.getContent(),User.class);
        List<User> us = new ArrayList<>();
        for (User user : users) {
            us.add(user);
        }
        return ApiResponse.success(us);
    }
}

