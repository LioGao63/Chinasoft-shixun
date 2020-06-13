package com.chinasoft.mapper;

import com.chinasoft.pojo.Employee;

import java.util.List;

public interface EmployeeMapper {
    //查询所有员工
    List<Employee> selectAll();

    //增加新员工
    void addEmployee(Employee employee);

    //更新员工信息
    void updateEmployee(Employee employee);

    //通过参数查询员工
    List<Employee> selectByParam(Employee employee);

    //显示单个员工的所有信息
    Employee selectOne(int eId);

    //删除员工
    void deleteEmployee(List<Integer> eIds);
}
