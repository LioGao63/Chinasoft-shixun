package com.chinasoft.mapper;

import com.chinasoft.pojo.Department;

import java.util.List;

public interface DepartmentMapper{

    //列出所有部门
    public List<Department> selectAllDepartment();

    //添加部门
    public void insertDepartment(Department department);

    //添加部门时进行验证是否有重复
    public Department confirmAddByName(String name);

    //删除全部选中的部门
    public void deleteDepartment(List<Long> ids);

    //修改部门信息
    public void updateDepartment(Department department);

    //根据部门名称查找部门
    public List<Department> selectDepartment(String departmentName);

    //总的部门个数
    int countDepartment();

    //分页查询
    List<Department> selectByPages(int page);
}
