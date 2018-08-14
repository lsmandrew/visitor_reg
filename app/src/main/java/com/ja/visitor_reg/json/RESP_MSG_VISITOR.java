package com.ja.visitor_reg.json;

/**
 * 来访信息回复
 * {"msg":"success","code":0,"visitorId":6}
 * {"msg":"token不能为空","code":500}
 */
public class RESP_MSG_VISITOR {
    private String msg;
    private Long code;
    private Long visitorId;

    @Override
    public String toString() {
        return "RESP_MSG_VISITOR{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", visitId=" + visitorId +
                '}';
    }

    public RESP_MSG_VISITOR() {
    }

    public RESP_MSG_VISITOR(String msg, Long code, Long visitorId) {
        this.msg = msg;
        this.code = code;
        this.visitorId = visitorId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }
}
