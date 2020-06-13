package com.chinasoft.pojo;

public class Department {
    private int dId;
    private String Dname;
    private String detail;

    public Department() {
    }

    public Department(int dId, String dname, String detail) {
        this.dId = dId;
        Dname = dname;
        this.detail = detail;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
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
                "dId=" + dId +
                ", Dname='" + Dname + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
