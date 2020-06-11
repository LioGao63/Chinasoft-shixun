package com.chinasoft.mapper;

import com.chinasoft.pojo.Announcement;

import java.util.List;

public interface AnnouncementMapper {
     //根据标题和内容查询公告
     List<Announcement> selectAnnouncement(Announcement announcement);
     //浏览公告内容
     Announcement browseAnnouncement(Long Aid);
     //修改公告
     void updateAnnouncement(Announcement announcement);
     //插入公告
     void insertAnnouncement(Announcement announcement);
     //删除
     void deleteAnnouncement(List<Long> ids);
     //显示所有
     List<Announcement> selectAllAnnouncement();
     //修改公告时的查询跳转
     Announcement selectAnnouncementById(Long Aid);

     //分页查询
     List<Announcement> selectAnByPage(int page);
     //查询过的公告个数
     int countAn();





}
