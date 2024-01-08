package com.sylvie233.ytgz_management_system_api.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public static Result<String> error(String msg) {
        return new Result<>("403", msg, "登录失败");
    }

    public static Result<String> success(String msg) {
        return new Result<>("200", msg, "登录成功");
    }

    public static Result<String> success(String msg, String data) {
        return new Result<>("200", msg, data);
    }
}