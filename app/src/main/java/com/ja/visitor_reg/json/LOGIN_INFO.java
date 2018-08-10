package com.ja.visitor_reg.json;

/**
 * 登陆信息
 */
public class LOGIN_INFO {
    private  String deviceName;
    private  String password;

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "LOGIN_INFO{" +
                "deviceName='" + deviceName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
