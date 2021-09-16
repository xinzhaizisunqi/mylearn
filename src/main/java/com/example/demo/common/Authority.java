package com.example.demo.common;

/**
 * @author 孙琦
 * @version 1.0
 * @description: TODO
 * @date 2021/7/14 11:13
 */
public class Authority {

    private String username;

    private String password;

    public Authority() {

    }

    public Authority(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Authority setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Authority setPassword(String password) {
        this.password = password;
        return this;
    }
}
