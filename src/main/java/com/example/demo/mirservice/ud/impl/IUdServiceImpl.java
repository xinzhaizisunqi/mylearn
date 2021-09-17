package com.example.demo.mirservice.ud.impl;

import com.example.demo.common.ClientResponse;
import com.example.demo.common.Param;
import com.example.demo.mirservice.HttpClient;
import com.example.demo.mirservice.ud.IUdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙琦
 * @version 1.0
 * @description: TODO
 * @date 2021/9/9 16:43
 */
@Component
public class IUdServiceImpl implements IUdService {

    @Autowired
    private HttpClient client;


    @Override
    public ClientResponse getUd(String host,String mobile) throws IOException {
        Map<String, String> queryMap = new HashMap<>();
        if (!StringUtils.isEmpty(mobile)) {
            queryMap.put("mobile",mobile);
        }
        ClientResponse response =  client.get(host,queryMap);
        return response;
    }

    @Override
    public ClientResponse checkBill(Param param) throws IOException {
        param.setOpenid(param.getOpenid());
        param.setStatus(param.getStatus());
        ClientResponse response= client.post(param.getHost(),param);
        return response;
    }



    @Override
    public ClientResponse deleteUd(Param param) throws IOException {
        param.setOpenid(param.getOpenid());
        param.setStatus(param.getStatus());
        ClientResponse response= client.post(param.getHost(),param);
        return response;
    }
}
