package com.ja.visitor_reg.json;

/**
 * 签退
 * {
 * "id": 0,
 * "leaveTime": "2018-08-14T06:14:24.950Z"
 * }
 */
public class VISITOUT_UPLOAD {
    private Long id;
    private String leaveTime;

    @Override
    public String toString() {
        return "VISITOUT_UPLOAD{" +
                "id=" + id +
                ", leaveTime='" + leaveTime + '\'' +
                '}';
    }

    public VISITOUT_UPLOAD() {
    }

    public VISITOUT_UPLOAD(Long id, String leaveTime) {
        this.id = id;
        this.leaveTime = leaveTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }
}
