package com.example.demo.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;



public class ClientResponse {
    private int statusCode;
    private String message;
    private String content;

    public int httpStatus() {
        return this.statusCode;
    }

    public int statusCode() {
        return this.statusCode;
    }

    public String content() {
        return this.content;
    }

    public String message() {
        return this.message;
    }

    public <T> T toResponse() {
        return JSON.parseObject(this.content, new TypeReference<T>() {
        }, new Feature[0]);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public String getContent() {
        return this.content;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ClientResponse(int statusCode, String message, String content) {
        this.statusCode = statusCode;
        this.message = message;
        this.content = content;
    }
}
