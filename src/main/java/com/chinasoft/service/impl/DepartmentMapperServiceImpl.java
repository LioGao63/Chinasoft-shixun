package com.chinasoft.service.impl;

import com.chinasoft.mapper.DepartmentMapper;
import com.chinasoft.pojo.Department;
import com.chinasoft.service.DepartmentMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentMapperServiceImpl implements DepartmentMapperService {

    @Autowired
    DepartmentMapper mapper;


    @Override
    public void addDepartment(Department department) {
        mapper.insertDepartment(department);
    }

    @Override
    public List<Department> lisAllDepartment() {
        return mapper.selectAllDepartment();
    }

    @Override
    public void deleteOneDepartment(List<Long> ids) {
        mapper.deleteDepartment(ids);
    }

    @Override
    public void updateOneDepartment(Department department) {
        mapper.updateDepartment(department);
    }

    @Override
    public List<Department> searchDepartment(String departmentName) {
        return mapper.selectDepartment(departmentName);
    }

    @Override
    public int countDepartment() {
        return mapper.countDepartment();
    }

    @Override
    public List<Department> selectByPages(int page) {
        return mapper.selectByPages(page);
    }
}
