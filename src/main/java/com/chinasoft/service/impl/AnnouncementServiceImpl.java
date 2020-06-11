package com.chinasoft.service.impl;

import com.chinasoft.mapper.AnnouncementMapper;
import com.chinasoft.pojo.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl {

    @Autowired
    AnnouncementMapper Anmapper;

    public List<Announcement> selectAllAn(){
        List<Announcement> list= Anmapper.selectAllAnnouncement();
        return list;
    }

    public List<Announcement> selectAn(Announcement announce){
        List<Announcement> annouce1= Anmapper.selectAnnouncement(announce);
        return annouce1;
    }

    public Announcement browseAn(Long id){
        Announcement announce= Anmapper.browseAnnouncement(id);
        return announce;
    }

    public void updateAn(Announcement announce){
        Anmapper.updateAnnouncement(announce);
    }

    public void insertAN(Announcement announce) {
        Anmapper.insertAnnouncement(announce);
    }

    public void deleteAn(List<Long> ids){
        Anmapper.deleteAnnouncement(ids);
    }

    public Announcement selectAnById(Long Aid){
        Announcement announce= Anmapper.selectAnnouncementById(Aid);
        return announce;
    }

    public int countAn(){return Anmapper.countAn();}

    public List<Announcement> selectAnByPage(int page){return Anmapper.selectAnByPage(page);}


}
