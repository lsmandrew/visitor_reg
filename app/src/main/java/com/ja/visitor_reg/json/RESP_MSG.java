package com.ja.visitor_reg.json;

public class RESP_MSG {
    private String msg;
    private Long code;
    private Long expire;
    private String token;

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

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "RESP_MSG{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", expire=" + expire +
                ", token='" + token + '\'' +
                '}';
    }
}
