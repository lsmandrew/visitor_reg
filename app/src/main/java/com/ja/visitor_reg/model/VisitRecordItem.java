package com.ja.visitor_reg.model;

public class VisitRecordItem {
    private String visitName;//来访人
    private String visitedName;//被访人
    private String idNum;//证件号码
    private String visitPhone;//来访电话
    private String visitTime;//来访时间
    private Long   visitId;//来访信息id

    public VisitRecordItem() {
    }

    public VisitRecordItem(String visitName, String visitedName, String idNum, String visitPhone, String visitTime,
                           Long visitId) {
        this.visitName = visitName;
        this.visitedName = visitedName;
        this.idNum = idNum;
        this.visitPhone = visitPhone;
        this.visitTime = visitTime;
        this.visitId = visitId;
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

    public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }

    @Override
    public String toString() {
        return "VisitRecordItem{" +
                "visitName='" + visitName + '\'' +
                ", visitedName='" + visitedName + '\'' +
                ", idNum='" + idNum + '\'' +
                ", visitPhone='" + visitPhone + '\'' +
                ", visitTime='" + visitTime + '\'' +
                ", visitId=" + visitId +
                '}';
    }
}
