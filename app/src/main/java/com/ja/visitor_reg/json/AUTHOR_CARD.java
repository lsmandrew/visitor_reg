package com.ja.visitor_reg.json;

/**
 * 授权发卡
 * =======================
 * {
 * "cardNum": "111",
 * "depId": 0,
 * "type":0,
 * "vieweeId": 0,
 * "visitorIdNum": "222"
 * }
 * ======================
 */
public class AUTHOR_CARD {
    private String cardNum;
    private Long depId;
    private Long type;
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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AUTHOR_CARD{" +
                "cardNum='" + cardNum + '\'' +
                ", depId=" + depId +
                ", type=" + type +
                ", vieweeId=" + vieweeId +
                ", visitorIdNum='" + visitorIdNum + '\'' +
                '}';
    }
}
