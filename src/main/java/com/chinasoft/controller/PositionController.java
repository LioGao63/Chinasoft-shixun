package com.chinasoft.controller;

import com.chinasoft.pojo.Position;
import com.chinasoft.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PositionController {

    @Autowired
    PositionServiceImpl posService;

    @RequestMapping("/getAllPos")
    public ModelAndView selectAll(){
        List<Position> lists = posService.selectAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("posList", lists);
        mav.setViewName("job/job");
        return mav;
    }

    @RequestMapping("/deletePos")
    public String deletePos(Long[] ids){
        System.out.println(ids);
        List<Long> list = new ArrayList<Long>();
        for(int i=0;i<ids.length;i++){
            list.add(ids[i]);
        }
        posService.deletePos(list);
        return "redirect:/getAllPos";
    }

    @RequestMapping("/insertPos")
    public String insertPos(String name, String detail){
        Position pos = new Position((long) 0, name, detail);
        posService.insertPos(pos);
        return "redirect:/getAllPos";
    }

    @RequestMapping("/updatePos")
    public String updatePos(Long id, String name, String detail){
        Position pos = new Position(id, name, detail);
        posService.updatePos(pos);
        return "redirect:/getAllPos";

    }

    @RequestMapping("/getPosByid")
    public ModelAndView selectPosById(Long id){
        Position position = posService.selectPosById(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("pos",position);
        mav.setViewName("job/showUpdateJob");
        return mav;
    }
}
