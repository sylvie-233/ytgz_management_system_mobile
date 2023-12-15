package com.sylvie233.ytgz_management_system_api.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.sylvie233.ytgz_management_system_api.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserAccountMapper extends BaseMapper<User> {
    List<User> getUserAccountById(@Param("id") Long id);
    List<User> getUserAccountList(@Param(Constants.WRAPPER) Wrapper wrapper);
}
