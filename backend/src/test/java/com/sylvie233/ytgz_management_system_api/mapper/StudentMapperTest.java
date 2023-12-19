package com.sylvie233.ytgz_management_system_api.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentMapperTest {
    @Autowired
    StudentMapper studentMapper;

    @Test
    void getStudnetList() {
        System.out.println(studentMapper.getStudentList(null));
    }

}
