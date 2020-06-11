package com.chinasoft.controller;

import com.chinasoft.pojo.Announcement;
import com.chinasoft.service.AnnouncementService;
import com.chinasoft.service.impl.AnnouncementServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AnnouncementController {

    @Autowired
    AnnouncementServiceImpl AnService;

    //显示所有公告
    @RequestMapping("/selectAllAnnounce")
    public ModelAndView getAllAnnouncement(int page){
        System.out.println("显示所有公告");
        List<Announcement> list=AnService.selectAnByPage((page-1)*10);
        //List<Announcement> list=AnService.selectAllAn();
        ModelAndView mav=new ModelAndView();

        int count =AnService.countAn();
        int lastPage=(count-1)/10+1;
        mav.addObject("count", count);
        mav.addObject("lastPage", lastPage);
        mav.addObject("currentPage", page);

        mav.addObject("announceList",list);
        mav.setViewName("notice/notice");
        return mav;

    }

    //可以跳转
    @RequestMapping("/browseAnnouncement")
    public ModelAndView browseAnnounce(Long Aid){
        System.out.println("浏览的公告为"+Aid);
        Announcement an=AnService.browseAn(Aid);
        ModelAndView mav=new ModelAndView();
        mav.addObject("AN",an);
        mav.setViewName("notice/previewNotice");
        return mav;

    }

    //更新内容
    @RequestMapping("/updateAn")
    public String updateAn(Long id,String title,String content){
        Announcement an=new Announcement(id,title,content);
        System.out.println("更新公告");
        System.out.println(an);
        AnService.updateAn(an);
        return "redirect:selectAllAnnounce?page=1";
    }

    //插入新公告
    @RequestMapping("/insertAn")
    public String insertAn(String title,String content,String uploader){

        //在这里获取时间
        Date currentTime=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String dateString = format.format(currentTime);
        //System.out.println(dateString);

        Announcement an=new Announcement(title,content,uploader,dateString);
        AnService.insertAN(an);
        return "redirect:selectAllAnnounce?page=1";
    }


    //删除所有公告，可以使用
    @RequestMapping("/deleteAn")
    public String deleteAn(Long[] ids){
        List<Long> list=new ArrayList<Long>();
        for (int i=0;i<ids.length;i++){
            list.add(ids[i]);
        }
        AnService.deleteAn(list);
        return "redirect:/selectAllAnnounce?page=1";
    }

    //搜索公告，考虑其中一项为空的情况,可以使用
    @RequestMapping("/selectAn")
    public ModelAndView selectAn(String title,String content){
        System.out.println("进入");
        Announcement an=new Announcement(title,content);
        List<Announcement> list=AnService.selectAn(an);
        System.out.println("sql");
        System.out.println(an);

        if (list.isEmpty()){
            System.out.println("list为null");
        }
        for (Announcement announcement:list){
            System.out.println(announcement);
        }

        ModelAndView mav=new ModelAndView();
        mav.addObject("announceList",list);
        mav.setViewName("notice/notice");
        return mav;
    }

    @RequestMapping("/getAnById")
    public ModelAndView selectAnById(Long id){
        Announcement announcement=AnService.selectAnById(id);
        ModelAndView mav=new ModelAndView();
        mav.addObject("An",announcement);
        mav.setViewName("notice/showUpdateNotice");
        return mav;

    }

}
