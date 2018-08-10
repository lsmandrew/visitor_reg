package com.ja.visitor_reg.model;

public class VisitRecordItem {
    private String visitName;
    private String visitedName;
    private String idNum;
    private String visitPhone;
    private String visitTime;

    public VisitRecordItem() {
    }

    public VisitRecordItem(String visitName, String visitedName, String idNum, String visitPhone, String visitTime) {
        this.visitName = visitName;
        this.visitedName = visitedName;
        this.idNum = idNum;
        this.visitPhone = visitPhone;
        this.visitTime = visitTime;
    }

    public String getVisitName() {
        return visitName;
    }

    public void setVisitName(String visitName) {
        this.visitName = visitName;
    }

    public String getVisitedName() {
        return visitedName;
    }

    public void setVisitedName(String visitedName) {
        this.visitedName = visitedName;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getVisitPhone() {
        return visitPhone;
    }

    public void setVisitPhone(String visitPhone) {
        this.visitPhone = visitPhone;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    @Override
    public String toString() {
        return "VisitRecordItem{" +
                "visitName='" + visitName + '\'' +
                ", visitedName='" + visitedName + '\'' +
                ", idNum='" + idNum + '\'' +
                ", visitPhone='" + visitPhone + '\'' +
                ", visitTime='" + visitTime + '\'' +
                '}';
    }
}
