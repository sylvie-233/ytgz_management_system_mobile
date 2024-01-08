package com.sylvie233.ytgz_management_system_api.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private String code;
    private String msg;
    private T data;
}