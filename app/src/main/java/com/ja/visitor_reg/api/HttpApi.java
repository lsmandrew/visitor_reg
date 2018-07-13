package com.ja.visitor_reg.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * HttpApi
 * author: lsm
 * data: 2018-7-13
 */
public class HttpApi {


    private static final String TAG = "HttpApi";

    class reg_info{
        String deviceName;
        String password;
    }
    /**
     * Register_Request
     * @return true/false
     * post form:
     * {
     * "deviceName": "string",
     * "password": "string"
     * }
     */
    public boolean Register_Request(reg_info reg_info){
        try {
            Response response = null;
            String  jsonData = "{ " +
                    "\"deviceName\": \"admin\"," +
                    "\"password\": \"123\"}";
            RequestBody postBody =  FormBody.create(
                    MediaType.parse("application/json; charset=utf-8"),
                    jsonData);
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://192.168.11.51:9090/ja-api/api/device/register")
                    .header("Accept", "text/html")
                    .addHeader("Content-Type", "application/json")
                    .post(postBody)
                    .build();
            //response
            response = client.newCall(request).execute();
            Log.d(TAG, "resp: " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
            return  false;
        }

        return true;
    }


}
