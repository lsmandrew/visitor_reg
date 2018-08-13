package com.ja.visitor_reg.json;

/**
 * 上传来访事件
 * {
 * "causeId": 0,
 * "deviceId": 0,
 * "id": 0,
 * "insetTime": "2018-08-13T02:00:45.235Z",
 * "intervieweeId": 0,
 * "isOrder": 0,
 * "orderPhone": "string",
 * "shifitId": 0,
 * "visitorCount": 0
 * }
 */
public class VISIT_EVENT_UPLOAD {
    private Long causeId;
    private Long deviceId;
    private Long id;
    private String insetTime;
    private Long intervieweeId;
    private Long isOrder;
    private String orderPhone;
    private Long shifitId;
    private Long visitorCount;

    public VISIT_EVENT_UPLOAD() {
    }

    public VISIT_EVENT_UPLOAD(Long causeId, Long deviceId, Long id, String insetTime, Long intervieweeId, Long
            isOrder, String orderPhone, Long shifitId, Long visitorCount) {
        this.causeId = causeId;
        this.deviceId = deviceId;
        this.id = id;
        this.insetTime = insetTime;
        this.intervieweeId = intervieweeId;
        this.isOrder = isOrder;
        this.orderPhone = orderPhone;
        this.shifitId = shifitId;
        this.visitorCount = visitorCount;
    }

    public Long getCauseId() {
        return causeId;
    }

    public void setCauseId(Long causeId) {
        this.causeId = causeId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInsetTime() {
        return insetTime;
    }

    public void setInsetTime(String insetTime) {
        this.insetTime = insetTime;
    }

    public Long getIntervieweeId() {
        return intervieweeId;
    }

    public void setIntervieweeId(Long intervieweeId) {
        this.intervieweeId = intervieweeId;
    }

    public Long getIsOrder() {
        return isOrder;
    }

    public void setIsOrder(Long isOrder) {
        this.isOrder = isOrder;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public Long getShifitId() {
        return shifitId;
    }

    public void setShifitId(Long shifitId) {
        this.shifitId = shifitId;
    }

    public Long getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount(Long visitorCount) {
        this.visitorCount = visitorCount;
    }

    @Override
    public String toString() {
        return "VISIT_EVENT_UPLOAD{" +
                "causeId=" + causeId +
                ", deviceId=" + deviceId +
                ", id=" + id +
                ", insetTime='" + insetTime + '\'' +
                ", intervieweeId=" + intervieweeId +
                ", isOrder=" + isOrder +
                ", orderPhone='" + orderPhone + '\'' +
                ", shifitId=" + shifitId +
                ", visitorCount=" + visitorCount +
                '}';
    }
}
