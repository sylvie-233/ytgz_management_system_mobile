package com.sylvie233.ytgz_management_system_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户登录实体类
 */
@TableName("ytgz_user_role")
@Data
public class UserRole {
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("role")
    private String role;
}
