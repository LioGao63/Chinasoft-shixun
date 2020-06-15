package com.chinasoft.controller;

import com.chinasoft.pojo.Department;
import com.chinasoft.service.impl.DepartmentMapperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentMapperController {

    @Autowired
    DepartmentMapperServiceImpl service;

    @RequestMapping("/addDepartment")
    public String addDepartment(String dname, String detail){
        System.out.println("addDepartment");
        System.out.println("dname="+dname);
        System.out.println("detail="+detail);

        Department department = new Department(dname,detail);
        service.addDepartment(department);

        return "dept/dept";
    }

    @RequestMapping("/listFirstPage")
    public ModelAndView listFirstPage() {
        System.out.println("listFirstPage");

        List<Department> firstList = service.selectByPages(0);
        System.out.println("list="+firstList);
        ModelAndView mav = new ModelAndView();
        int count = service.countDepartment();
        int lastPage = (count-1)/10+1;

        mav.addObject("firstList",firstList);
        mav.addObject("count", count);
        mav.addObject("lastPage", lastPage);
        mav.addObject("currentPage", 1);
        mav.setViewName("dept/dept");

        return mav;
    }

    @RequestMapping("/lisAllDepartment")
    public ModelAndView lisAllDepartment(int page) {
        System.out.println("addDepartment");
        System.out.println("page="+page);

        List<Department> list = service.selectByPages((page-1)*10);
        System.out.println("list="+list);
        ModelAndView mav = new ModelAndView();
        int count = service.countDepartment();
        int lastPage = (count-1)/10+1;

       // mav.addObject("firstList",list);
        mav.addObject("count", count);
        mav.addObject("posList", list);
        mav.addObject("lastPage", lastPage);
        mav.addObject("currentPage", page);
        mav.setViewName("dept/dept");

        return mav;
    }

    @RequestMapping("/deleteOneDepartment")
    public String deleteOneDepartment(Long[] dids) {
        System.out.println("addDepartment");
        System.out.println("dids="+dids);

        List<Long> list = new ArrayList<Long>();
        for(int i=0;i<dids.length;i++){
            list.add(dids[i]);
        }
        service.deleteOneDepartment(list);

        return "redirect:/lisAllDepartment?page=1";
    }

    @RequestMapping("/updateOneDepartment")
    public String updateOneDepartment(int id, String name ,String detail) {
        System.out.println("addDepartment");
        System.out.println("id="+id);
        System.out.println("name="+name);
        System.out.println("detail="+detail);

        Department department= new Department(id,name,detail);
        service.updateOneDepartment(department);

        return "redirect:/lisAllDepartment?page=1";
    }

    @RequestMapping("/searchDepartment")
    public ModelAndView searchDepartment(String departmentName) {
        System.out.println("addDepartment");
        System.out.println("departmentName="+departmentName);

        List<Department> list = service.searchDepartment(departmentName);
        ModelAndView mav = new ModelAndView();
        mav.addObject("searchList",list);
        mav.setViewName("dept/dept");

        return mav;
    }






//
//    @RequestMapping("/test2")
//    public ModelAndView test2(int page){
//        //ModelAndView mav = new ModelAndView();
//
//        System.out.println("addDepartment");
//        System.out.println("page="+page);
//
//        List<Department> list = service.selectByPages((page-1)*10);
//        System.out.println("list="+list);
//        ModelAndView mav = new ModelAndView();
//        int count = service.countDepartment();
//        int lastPage = (count-1)/10+1;
//        mav.addObject("count", count);
//        mav.addObject("posList", list);
//        mav.addObject("lastPage", lastPage);
//        mav.addObject("currentPage", page);
//       // mav.setViewName("dept/dept");
//
//
//        mav.addObject("name1", "1254");
//        mav.addObject("pass1","1215");
//        mav.addObject("message","hello");
//        mav.setViewName("test");
//
//        return mav;
//    }
//
//    @RequestMapping("/test1")
//    public void test1(){
//        String name="nihao";
//        String detail = "whooou";
//
//        Department department = new Department(name,detail);
//        service.addDepartment(department);
//        System.out.println("success");
//    }
}
