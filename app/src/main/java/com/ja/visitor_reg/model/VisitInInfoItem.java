package com.ja.visitor_reg.model;

public class VisitInInfoItem {
    private String visitName;
    private String visitedName;
    private String visitPhone;
    private String imgHeadName;
    private String imgPortraitName;
    private String imgGoodsName;

    public VisitInInfoItem(String visitName, String visitedName, String visitPhone, String imgHeadName,
                           String imgPortraitName, String imgGoodsName) {
        this.visitName = visitName;
        this.visitedName = visitedName;
        this.visitPhone = visitPhone;
        this.imgHeadName = imgHeadName;
        this.imgPortraitName = imgPortraitName;
        this.imgGoodsName = imgGoodsName;
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

    @Override
    public String toString() {
        return "VisitInInfoItem{" +
                "visitName='" + visitName + '\'' +
                ", visitedName='" + visitedName + '\'' +
                ", imgHeadName='" + imgHeadName + '\'' +
                ", imgPortraitName='" + imgPortraitName + '\'' +
                ", imgGoodsName='" + imgGoodsName + '\'' +
                '}';
    }
}
