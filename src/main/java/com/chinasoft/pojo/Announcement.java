package com.chinasoft.pojo;

import javax.xml.crypto.Data;
import java.io.Serializable;

public class Announcement implements Serializable {
    private Long Aid;
    private String content;
    private String title;
    private String uploader;
    private String uploadDate;


    public String getUploadDate() {
        return uploadDate;
    }

    public Announcement(String content, String title, String uploader, String uploadDate) {
        this.content = content;
        this.title = title;
        this.uploader = uploader;
        this.uploadDate = uploadDate;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "Aid=" + Aid +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", uploader='" + uploader + '\'' +
                ", uploadDate='" + uploadDate + '\'' +
                '}';
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }



    public Announcement(String title, String content) {
        this.content = content;
        this.title = title;
    }

    public Announcement(String title, String content, String uploader) {
        this.content = content;
        this.title = title;
        this.uploader = uploader;
    }

    public Announcement(Long aid, String content, String title, String uploader, String uploadDate) {
        Aid = aid;
        this.content = content;
        this.title = title;
        this.uploader = uploader;
        this.uploadDate = uploadDate;
    }

    public Announcement(Long aid, String content, String title, String uploader) {
        Aid = aid;
        this.content = content;
        this.title = title;
        this.uploader = uploader;
    }

    public Announcement(Long aid, String content, String title) {
        Aid = aid;
        this.content = content;
        this.title = title;
    }

    public Long getAid() {
        return Aid;
    }

    public void setAid(Long aid) {
        Aid = aid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

   public Announcement(){
        super();
   }



}
