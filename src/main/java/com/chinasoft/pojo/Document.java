package com.chinasoft.pojo;

import org.springframework.format.annotation.DateTimeFormat;

public class Document {
    private int Oid;
    private String title;
    private String uploadTime;
    private String uploader;
    private String description;


    public Document() {
    }

    public Document(int Oid, String title, String uploadTime, String uploader, String description) {
        this.Oid = Oid;
        this.title = title;
        this.uploadTime = uploadTime;
        this.uploader = uploader;
        this.description = description;
    }

    public int getOid() {
        return Oid;
    }

    public void setOid(int Oid) {
        this.Oid = Oid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Document{" +
                "Oid=" + Oid +
                ", title='" + title + '\'' +
                ", uploadTime='" + uploadTime + '\'' +
                ", uploader='" + uploader + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
