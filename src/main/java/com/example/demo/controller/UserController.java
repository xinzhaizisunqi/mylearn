package com.example.demo.controller;
import com.example.demo.common.ApiResponse;
import com.example.demo.common.User;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/user")

public class UserController {
    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String IMG_PATH_PREFIX = "static";

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getname() {
        return "8083hehehehe ";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @CrossOrigin
    public ApiResponse<User> login(@RequestBody User user) throws Exception {

        if (user.getPassword().equals("sunqi") && user.getUsername().equals("sunqi")) {

           return ApiResponse.success(user);
        }
       return  ApiResponse.error("密码账户错误");
    }

}

