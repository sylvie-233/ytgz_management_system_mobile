package com.sylvie233.ytgz_management_system_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sylvie233.ytgz_management_system_api.entity.Student;
import com.sylvie233.ytgz_management_system_api.mapper.StudentMapper;
import com.sylvie233.ytgz_management_system_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList(null);
    }

    @Override
    public boolean saveBatch(Collection<Student> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Student> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Student> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Student entity) {
        return false;
    }

    @Override
    public Student getOne(Wrapper<Student> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Student> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Student> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Student> getBaseMapper() {
        return null;
    }

    @Override
    public Class<Student> getEntityClass() {
        return null;
    }
}
