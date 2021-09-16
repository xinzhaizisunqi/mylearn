package com.example.demo.common;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @author 孙琦
 * @version 1.0
 * @description: TODO
 * @date 2021/9/14 11:56
 */
@Data
public class User {

    private String name;

    private String openid;

    private String mobile;

    private Integer uploadCount;

    private String status;

}
