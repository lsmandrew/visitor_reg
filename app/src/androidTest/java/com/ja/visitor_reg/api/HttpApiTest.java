package com.ja.visitor_reg.api;

import com.ja.visitor_reg.json.LOGIN_INFO;

import org.junit.Test;

public class HttpApiTest {

    @Test
    public void login_Request() {
        LOGIN_INFO login_info = new LOGIN_INFO();
        HttpApi client = new HttpApi();

        login_info.setDeviceName("ja-20180703-001");
        login_info.setPassword("123456");
        client.Login_Request(login_info);
    }

    @Test
    public void logout_Request() {
        HttpApi httpApi = new HttpApi();
        httpApi.Logout_Request();
    }

    @Test
    public void getDevId_Request() {

    }

    @Test
    public void getDevInfo_Request() {
    }
}