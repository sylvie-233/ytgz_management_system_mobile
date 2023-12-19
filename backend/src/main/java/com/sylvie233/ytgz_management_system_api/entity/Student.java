package com.sylvie233.ytgz_management_system_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("ytgz_student")
public class Student {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer gender;

    private Integer age;

    private String grade;
    private String clazz;

    private String avatar;

    private String nation;

    private String address;
    private String contact;
    private String mobile;

    private String graduation;

    private String idcard;
    private Integer agreement;
}
