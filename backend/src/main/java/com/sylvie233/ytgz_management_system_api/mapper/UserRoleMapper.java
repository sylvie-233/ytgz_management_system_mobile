package com.sylvie233.ytgz_management_system_api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sylvie233.ytgz_management_system_api.entity.User;
import com.sylvie233.ytgz_management_system_api.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
    List<UserRole> getUserRolesByUserAccountId(@Param("id") Long id);
}
