package com.example.demo.mirservice.ud;

import com.example.demo.common.ClientResponse;
import com.example.demo.common.Param;

import java.io.IOException;

/**
 * @author 孙琦
 * @version 1.0
 * @description: TODO
 * @date 2021/9/9 16:42
 */
public interface IUdService {


    ClientResponse getUd(String host,String mobile) throws IOException;

    ClientResponse checkBill(Param param) throws IOException;

    ClientResponse deleteUd(Param param) throws IOException;


}
