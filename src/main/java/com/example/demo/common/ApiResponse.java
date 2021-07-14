package com.example.demo.common;

/**
 * @author 孙琦
 * @version 1.0
 * @description: TODO
 * @date 2021/7/14 11:10
 */
public class ApiResponse<T> {
    private final int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ApiResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ApiResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public ApiResponse() {
        this.code = 0;
    }

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success() {
        return new ApiResponse<>(0, "success", null);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(0, "success", data);
    }

    public static <T> ApiResponse<T> success(String msg, T data) {
        return new ApiResponse<>(0, msg, data);
    }

    public static <T> ApiResponse<T> success(int code, String msg, T data) {
        return new ApiResponse<>(code, msg, data);
    }

    public static <T> ApiResponse<T> error(String msg) {
        return new ApiResponse<>(-1, msg, null);
    }

    public static <T> ApiResponse<T> error(int code, String msg) {
        return new ApiResponse<>(code, msg, null);
    }

    public int code() {
        return this.code;
    }

    /**
     * 请求结果是否成功
     *
     * @return code = 0 则TRUE； 否则FALSE
     */
    public boolean yn() {
        return this.code == 0;
    }
}
