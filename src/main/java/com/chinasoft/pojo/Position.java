package com.chinasoft.pojo;

public class Position {

    private int pId;
    private String pName;
    private String pDetail;

    public Position(int pId, String pName, String pDetail) {
        this.pId = pId;
        this.pName = pName;
        this.pDetail = pDetail;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDetail() {
        return pDetail;
    }

    public void setpDetail(String pDetail) {
        this.pDetail = pDetail;
    }

    @Override
    public String toString() {
        return "Position{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pDetail='" + pDetail + '\'' +
                '}';
    }
}
