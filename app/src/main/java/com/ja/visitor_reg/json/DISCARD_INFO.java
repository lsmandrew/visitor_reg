package com.ja.visitor_reg.json;

/**
 * 撤销卡
 * {
 " cardNum": "string",
 " depId": 0,
 " vieweeId": 0,
 " visitorIdNum": "string"
 * }
 */
public class DISCARD_INFO {
    private String cardNum;
    private Long depId;
    private Long vieweeId;
    private String visitorIdNum;

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public Long getVieweeId() {
        return vieweeId;
    }

    public void setVieweeId(Long vieweeId) {
        this.vieweeId = vieweeId;
    }

    public String getVisitorIdNum() {
        return visitorIdNum;
    }

    public void setVisitorIdNum(String visitorIdNum) {
        this.visitorIdNum = visitorIdNum;
    }

    @Override
    public String toString() {
        return "DISCARD_INFO{" +
                "cardNum='" + cardNum + '\'' +
                ", depId=" + depId +
                ", vieweeId=" + vieweeId +
                ", visitorIdNum='" + visitorIdNum + '\'' +
                '}';
    }
}
