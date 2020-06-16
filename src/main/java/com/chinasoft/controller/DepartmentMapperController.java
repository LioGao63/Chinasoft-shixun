package com.chinasoft.controller;

import com.chinasoft.pojo.Department;
import com.chinasoft.service.impl.DepartmentMapperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentMapperController {

    @Autowired
    DepartmentMapperServiceImpl service;

    @RequestMapping("/addDepartment")
    public ModelAndView addDepartment(HttpServletRequest request, String dname, String detail){

        ModelAndView mav = new ModelAndView();

        Department confirm = service.confirmAdd(dname);
        if (confirm == null){
            Department department = new Department(dname,detail);
            service.addDepartment(department);
            mav.addObject("success_state",1);
            mav.setViewName("dept/dept");
        }else {
            mav.addObject("success_state",0);
            mav.setViewName("dept/showAddDept");//将变量传到jsp,要设置setViewName
        }
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
        int searchJudge = 0;

        mav.addObject("firstList",list);
        mav.addObject("count", count);
        mav.addObject("lastPage", lastPage);
        mav.addObject("currentPage", page);
        mav.addObject("searchPageJudge",searchJudge);

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

        return "redirect:/department/lisAllDepartment?page=1";
    }

    @RequestMapping("/updateOneDepartment")
    public String updateOneDepartment(HttpServletRequest request,Long did, String dname , String detail) {
        System.out.println("addDepartment");

        did = Long.parseLong(request.getParameter("ud_after_id"));
        dname = request.getParameter("ud_after_dname");
        detail = request.getParameter("ud_after_detail");

        System.out.println("id="+did);
        System.out.println("name="+dname);
        System.out.println("detail="+detail);

        Department department= new Department(did,dname,detail);
        service.updateOneDepartment(department);

        return "redirect:/department/lisAllDepartment?page=1";
    }

    @RequestMapping("/searchDepartment")
    public ModelAndView searchDepartment(HttpServletRequest request,String departmentName) {
        //departmentName = request.getParameter("keyWord");
        System.out.println("addDepartment");
        System.out.println("departmentName="+departmentName);

        String proDepartment = departmentName.replace(" ","");

        List<Department> list = service.searchDepartment(proDepartment);
        int count = list.size();
        int lastPage = (count-1)/10+1;
        int page = 1;
        int searchJudge = 1;

        ModelAndView mav = new ModelAndView();
        mav.addObject("firstList",list);
        mav.addObject("count", count);
        mav.addObject("lastPage", lastPage);
        mav.addObject("currentPage", page);
        mav.addObject("searchPageJudge",searchJudge);

        mav.setViewName("dept/dept");

        return mav;
    }

}
