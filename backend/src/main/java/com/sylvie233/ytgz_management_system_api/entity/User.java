package com.sylvie233.ytgz_management_system_api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户实体类
 */
@TableName("ytgz_user")
@Data
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("nick_name")
    private String nickName;

    private Integer gender;

    private String avatar;

    private String mobile;

    private String email;

    @DateTimeFormat(pattern = "yy-MM-dd")
    @JsonFormat(pattern = "yy-MM-dd")
    private Date birthday;

    private Integer status;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yy-MM-dd hh:mm:ss")
    private Date createTime;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yy-MM-dd hh:mm:ss")
    private Date updateTime;
}
