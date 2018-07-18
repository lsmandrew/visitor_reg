package com.ja.visitor_reg.api;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.ja.visitor_reg.json.LOGIN_INFO;
import com.ja.visitor_reg.json.RESP_MSG;

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
    private static String TOKEN = "";

    /**
     * Login_Request
     * @return true/false
     * post form:
     * {
     * "deviceName": "string",
     * "password": "string"
     * }
     * success :
     *  {"msg":"success","code":0,"expire":43199823,"token":"901c40129c5841bba9c103fe207b3749"}
     * error :
     *
     */
    public boolean Login_Request(LOGIN_INFO login_info){
        try {
            Response response = null;
            String jsonData = JSON.toJSONString(login_info);
            Log.d(TAG, "json: " + jsonData);
            RequestBody postBody =  FormBody.create(
                    MediaType.parse("application/json; charset=utf-8"),
                    jsonData);
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://192.168.11.51:9090/ja-api/api/device/login")
                    .header("Accept", "text/html")
                    .addHeader("Content-Type", "application/json")
                    .post(postBody)
                    .build();
            //response
            response = client.newCall(request).execute();
            String strBody = response.body().string();
            Log.d(TAG, "resp: " + strBody);
            RESP_MSG resp_msg = JSON.parseObject(strBody, RESP_MSG.class);
            TOKEN = resp_msg.getToken();
            Log.d(TAG, "token: " + TOKEN);

        } catch (IOException e) {
            e.printStackTrace();
            return  false;
        }

        return true;
    }


    /**
     * Logout_Request
     * post：
     * +header: "token": "xxxxx"
     * @return true/false
     * success:
     *  {"msg":"success","code":0}
     * error:
     */

   public boolean Logout_Request(){
       try {
           Response response = null;
           OkHttpClient client = new OkHttpClient();
           RequestBody postBody =  FormBody.create(
                   MediaType.parse("application/json; charset=utf-8"),
                   "");
           Request request = new Request.Builder()
                   .url("http://192.168.11.51:9090/ja-api/api/device/logout")
                   .header("Accept", "text/html")
                   .addHeader("Content-Type", "application/json")
                   .addHeader("token", TOKEN)
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

    /**
     * GetDevId_Request
     * get
     * +header: "token": "xxxxx"
     * success:
     *
     * error
     * @return true/false
     */
   public boolean GetDevId_Request(){
       try {
           Response response = null;
           OkHttpClient client = new OkHttpClient();
           Request request = new Request.Builder()
                   .url("http://192.168.11.51:9090/ja-api/api/device/deviceId")
                   .header("Accept", "text/html")
                   .addHeader("Content-Type", "application/json")
                   .addHeader("token", TOKEN)
                   .get()
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

    /**
     * GetDevInfo_Request
     * get
     * +header: "token": "xxxxx"
     * success:
     * error:
     * @return true/false
     */
   public boolean GetDevInfo_Request(){
       try {
           Response response = null;
           OkHttpClient client = new OkHttpClient();
           Request request = new Request.Builder()
                   .url("http://192.168.11.51:9090/ja-api/api/device/deviceInfo")
                   .header("Accept", "text/html")
                   .addHeader("Content-Type", "application/json")
                   .addHeader("token", TOKEN)
                   .get()
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
