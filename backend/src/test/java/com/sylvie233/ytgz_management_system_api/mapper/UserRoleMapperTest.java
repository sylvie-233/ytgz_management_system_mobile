package com.sylvie233.ytgz_management_system_api.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRoleMapperTest {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Test
    void getUserRolesByUserAccountId() {
        System.out.println(userRoleMapper.getUserRolesByUserAccountId(1L));
    }
}