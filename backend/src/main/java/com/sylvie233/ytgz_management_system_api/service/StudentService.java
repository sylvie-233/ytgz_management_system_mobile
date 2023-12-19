package com.sylvie233.ytgz_management_system_api.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sylvie233.ytgz_management_system_api.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService extends IService<Student> {

    List<Student> getStudentList();
}
