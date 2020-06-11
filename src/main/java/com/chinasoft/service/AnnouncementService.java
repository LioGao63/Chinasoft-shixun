package com.chinasoft.service;

import com.chinasoft.pojo.Announcement;

import java.util.List;

public interface AnnouncementService {

    List<Announcement> selectAllAn();
    List<Announcement> selectAn(Announcement announce);
    Announcement browseAn(Long id);
    void updateAn(Announcement announce);
    void insertAN(Announcement announce);
    void deleteAn(List<Long> ids);
    Announcement selectAnById(Long Aid);

    int countAn();
    List<Announcement> selectAnByPage(int page);


}
