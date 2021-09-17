package com.example.demo.controller;
import com.example.demo.common.*;
import com.example.demo.mirservice.ud.IUdService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@Log4j2
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

    /**
     * 获取用户
     * @param host
     * @param mobile
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getUd", method = RequestMethod.GET)
    @CrossOrigin
    public ApiResponse<List<User>> getUd(@RequestParam String host, @RequestParam String mobile) throws Exception {
        //ClientResponse response = service.getUd(host,mobile);
       // List<User> users = JSON.parseArray(response.getContent(),User.class);
        User u = new User();
        u.setUploadCount(2);
        u.setStatus("PASS");
        u.setOpenid("ocJOVjlqD1L8Tru7KAKOKLHgn8aM");
        u.setName("qiqi");
        u.setMobile("151****2575");
        List<User> us = new ArrayList<>();
        us.add(u);
   /*     for (User user : users) {
            us.add(user);
        }*/
        return ApiResponse.success(us);
    }

    /**
     * 审核小票
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @CrossOrigin
    public ApiResponse<String> check(@RequestBody Param param) throws Exception {
        //ClientResponse response = service.checkBill(param);
        log.info("begin check:"+param.getOpenid());
        ClientResponse response = new ClientResponse(200,"","");
        if (response.getStatusCode() != 200) {
            return ApiResponse.error("");
        }
        return ApiResponse.success("");
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @CrossOrigin
    public ApiResponse<String> delete(@RequestBody Param param) throws Exception {
       // ClientResponse response = service.deleteUd(param);
        log.info("begin delete:"+param.getOpenid());
        ClientResponse response = new ClientResponse(200,"","");
        if (response.getStatusCode() != 200) {
            return ApiResponse.error("");
        }
        return ApiResponse.success("");
    }
}

