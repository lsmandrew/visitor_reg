package com.ja.visitor_reg.json;

/**
 * 来访事件回复
 * {"msg":"success","code":0,"visitEventId":6}
 * {"msg":"token不能为空","code":500}
 */
public class RESP_MSG_EVENT {
    private String msg;
    private Long code;
    private Long visitEventId;

    @Override
    public String toString() {
        return "RESP_MSG_EVENT{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", visitEventId=" + visitEventId +
                '}';
    }

    public RESP_MSG_EVENT() {
    }

    public RESP_MSG_EVENT(String msg, Long code, Long visitEventId) {
        this.msg = msg;
        this.code = code;
        this.visitEventId = visitEventId;
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

    public Long getVisitEventId() {
        return visitEventId;
    }

    public void setVisitEventId(Long visitEventId) {
        this.visitEventId = visitEventId;
    }
}
