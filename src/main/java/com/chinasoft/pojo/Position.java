package com.chinasoft.pojo;

public class Position {

    private Long pId;
    private String pName;
    private String pDetail;

    public Position(Long pId, String pName, String pDetail) {
        this.pId = pId;
        this.pName = pName;
        this.pDetail = pDetail;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
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
