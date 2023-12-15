package com.sylvie233.ytgz_management_system_api.mapper;

import com.sylvie233.ytgz_management_system_api.entity.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserAccountMapperTest {
    @Autowired
    UserAccountMapper userAccountMapper;

    @Test
    void getUserAccountById() {
        System.out.println(userAccountMapper.getUserAccountById(2L));
    }

}
