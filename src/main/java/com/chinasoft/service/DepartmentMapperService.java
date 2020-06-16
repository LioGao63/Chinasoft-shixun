package com.chinasoft.service;

import com.chinasoft.pojo.Department;

import java.util.List;

public interface DepartmentMapperService {

    //添加部门验证是否重复
    public Department confirmAdd(String departmentName);

    //添加部门
    public void addDepartment(Department department);

    //列出所有部门
    //public List<Department> lisAllDepartment();

    //删除特定部门
    public void deleteOneDepartment(List<Long> ids);

    //修改部门信息
    public void updateOneDepartment(Department department);

    //查找部门
    public List<Department> searchDepartment(String departmentName);

    //总的部门个数-
    public int countDepartment();

    //分页查询
    public List<Department> selectByPages(int page);
}
