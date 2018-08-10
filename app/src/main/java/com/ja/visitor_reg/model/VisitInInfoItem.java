package com.ja.visitor_reg.model;

public class VisitInInfoItem {
    private String visitName;
    private String visitedName;
    private String visitPhone;
    private String imgHeadName;
    private String imgPortraitName;
    private String imgGoodsName;
    private String visitTime;

    public VisitInInfoItem(String visitName, String visitedName, String visitPhone, String imgHeadName,
                           String imgPortraitName, String imgGoodsName, String visitTime) {
        this.visitName = visitName;
        this.visitedName = visitedName;
        this.visitPhone = visitPhone;
        this.imgHeadName = imgHeadName;
        this.imgPortraitName = imgPortraitName;
        this.imgGoodsName = imgGoodsName;
        this.visitTime = visitTime;
    }

    public VisitInInfoItem(String visitName, String visitedName, String visitPhone, String visitTime) {
        this.visitName = visitName;
        this.visitedName = visitedName;
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

    public String getImgHeadName() {
        return imgHeadName;
    }

    public void setImgHeadName(String imgHeadName) {
        this.imgHeadName = imgHeadName;
    }

    public String getImgPortraitName() {
        return imgPortraitName;
    }

    public void setImgPortraitName(String imgPortraitName) {
        this.imgPortraitName = imgPortraitName;
    }

    public String getImgGoodsName() {
        return imgGoodsName;
    }

    public void setImgGoodsName(String imgGoodsName) {
        this.imgGoodsName = imgGoodsName;
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
        return "VisitInInfoItem{" +
                "visitName='" + visitName + '\'' +
                ", visitedName='" + visitedName + '\'' +
                ", visitPhone='" + visitPhone + '\'' +
                ", imgHeadName='" + imgHeadName + '\'' +
                ", imgPortraitName='" + imgPortraitName + '\'' +
                ", imgGoodsName='" + imgGoodsName + '\'' +
                ", visitTime='" + visitTime + '\'' +
                '}';
    }
}
