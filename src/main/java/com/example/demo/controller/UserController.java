package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/user")
public class UserController {
    // 项目根路径下的目录  -- SpringBoot static 目录相当于是根路径下（SpringBoot 默认）
    public final static String IMG_PATH_PREFIX = "static";

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String getname() {
        return "hehehehe ";
    }

}

