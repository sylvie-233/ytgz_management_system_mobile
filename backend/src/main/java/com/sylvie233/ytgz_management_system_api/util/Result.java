package com.sylvie233.ytgz_management_system_api.util;

import lombok.Data;

@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;
}