package com.chinasoft.service;

import com.chinasoft.pojo.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> selectAll();

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    List<Employee> selectByParam(Employee employee);

    Employee selectOne(int eId);

    void deleteEmployee(List<Integer> eIds);
}
