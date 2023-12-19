package com.sylvie233.ytgz_management_system_api.controller;

import com.sylvie233.ytgz_management_system_api.entity.Student;
import com.sylvie233.ytgz_management_system_api.service.StudentService;
import com.sylvie233.ytgz_management_system_api.util.Result;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/student/all")
    public Result<List<Student>> getStudentList() {
        Result<List<Student>> result = new Result<>();
        result.setCode("200");
        result.setMsg("学生列表");
        result.setData(studentService.getStudentList());
        log.info(result.toString());
        return result;
    }
}
