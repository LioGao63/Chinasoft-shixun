package com.chinasoft.service.impl;

import com.chinasoft.mapper.EmployeeMapper;
import com.chinasoft.pojo.Employee;
import com.chinasoft.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper mapper;

    public List<Employee> selectAll() { return mapper.selectAll(); }

    public void addEmployee(Employee employee) {mapper.addEmployee(employee); }

    public void updateEmployee(Employee employee) {mapper.updateEmployee(employee); }

    public List<Employee> selectByParam(Employee employee) { return mapper.selectByParam(employee); }

    public Employee selectOne(int eId) { return mapper.selectOne(eId); }

    public void deleteEmployee(List<Integer> eIds) { mapper.deleteEmployee(eIds);}
}
