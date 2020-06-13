package com.chinasoft.controller;

import com.chinasoft.pojo.Employee;
import com.chinasoft.pojo.Position;
import com.chinasoft.service.impl.EmployeeServiceImpl;
import com.chinasoft.service.impl.PositionServiceImpl;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/jsp")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl service;
    @Autowired
    PositionServiceImpl positionService;

    @RequestMapping("/getAllEmployee")
    public ModelAndView selectAll(){
        System.out.println("getAllEmployee...");
        List<Employee> employees = service.selectAll();
        List<Position> positions = positionService.selectAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("EmployeeList", employees);
        mav.addObject("posList",positions);
        mav.setViewName("employee/employee");
        System.out.println(employees);
        return mav;
    }


    @RequestMapping("/addEmployeeJob")
    public ModelAndView addEmployeeJob(){
        ModelAndView mav = new ModelAndView();
        List<Position> positions = positionService.selectAll();
        mav.addObject("posList", positions);
        mav.setViewName("employee/showAddEmployee");
        return mav;
    }
    @RequestMapping("/addEmployee")
    public String addEmployee(Employee employee){
        System.out.println(employee);
        service.addEmployee(employee);
        return "redirect:/jsp/getAllEmployee";
    }

    @RequestMapping("/updateEmployee")
    public String updateEmployee(Employee employee){
        System.out.println(employee);
        service.updateEmployee(employee);
        System.out.println("success");
        return "redirect:/jsp/getAllEmployee";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam(value = "eIds") List<Integer> eIds){
        service.deleteEmployee(eIds);
        return "redirect:/jsp/getAllEmployee";
    }

    @RequestMapping("/selectByParam")
    public ModelAndView selectByParam(Employee employee){
        System.out.println(employee);
        List<Employee> employees = service.selectByParam(employee);
        System.out.println(employees);
        List<Position> positions = positionService.selectAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("EmployeeList", employees);
        mav.addObject("posList",positions);
        mav.setViewName("employee/employee");
        return mav;
    }

    @RequestMapping("/selectOne")
    public ModelAndView selectOne(int eId){
        ModelAndView mav = new ModelAndView();
        Employee employee = service.selectOne(eId);
        mav.addObject("employee",employee);
        List<Position> positions = positionService.selectAll();
        mav.addObject("posList",positions);
        mav.setViewName("employee/showUpdateEmployee");
        return mav;
    }
}
