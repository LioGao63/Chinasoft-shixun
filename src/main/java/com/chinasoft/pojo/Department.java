package com.chinasoft.pojo;

import java.io.Serializable;

public class Department implements Serializable {
    private Long Did;
    private String Dname;
    private String detail;

    public Department(long did, String dname, String detail) {
        Did = did;
        Dname = dname;
        this.detail = detail;
    }

    public Department(String dname, String detail) {
        Dname = dname;
        this.detail = detail;
    }

    public Long getDid() {
        return Did;
    }

    public void setDid(Long did) {
        Did = did;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Department{" +
                "Did=" + Did +
                ", Dname='" + Dname + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }


}
