package com.chinasoft.pojo;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
    private int eId;
    private String Ename;
    private String identity;
    private String sex;
    private String pid;
    private String record;
    private String email;
    private String telphone;
    private String phone;
    private String politic;
    private String qq;
    private String address;
    private String postalcode;
    private String birthday;
    private String nation;
    private String major;
    private String habby;
    private String note;
    private String did;
    private Position position;
    private Department department;
    private String creatDate;

    public Employee() {
    }

    public Employee(int eId, String ename, String identity, String sex, String pid, String record, String email, String telphone, String phone, String politic, String qq, String address, String postalcode, String birthday, String nation, String major, String habby, String note, String did, Position position, Department department, String creatDate) {
        this.eId = eId;
        Ename = ename;
        this.identity = identity;
        this.sex = sex;
        this.pid = pid;
        this.record = record;
        this.email = email;
        this.telphone = telphone;
        this.phone = phone;
        this.politic = politic;
        this.qq = qq;
        this.address = address;
        this.postalcode = postalcode;
        this.birthday = birthday;
        this.nation = nation;
        this.major = major;
        this.habby = habby;
        this.note = note;
        this.did = did;
        this.position = position;
        this.department = department;
        this.creatDate = creatDate;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPolitic() {
        return politic;
    }

    public void setPolitic(String politic) {
        this.politic = politic;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getBirthday() {
        return birthday;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getHabby() {
        return habby;
    }

    public void setHabby(String habby) {
        this.habby = habby;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getCreatDate() {
        return creatDate;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", Ename='" + Ename + '\'' +
                ", identity='" + identity + '\'' +
                ", sex='" + sex + '\'' +
                ", pid='" + pid + '\'' +
                ", record='" + record + '\'' +
                ", email='" + email + '\'' +
                ", telphone='" + telphone + '\'' +
                ", phone='" + phone + '\'' +
                ", politic='" + politic + '\'' +
                ", qq='" + qq + '\'' +
                ", address='" + address + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nation='" + nation + '\'' +
                ", major='" + major + '\'' +
                ", habby='" + habby + '\'' +
                ", note='" + note + '\'' +
                ", did='" + did + '\'' +
                ", position=" + position +
                ", department=" + department +
                ", creatDate='" + creatDate + '\'' +
                '}';
    }
}
