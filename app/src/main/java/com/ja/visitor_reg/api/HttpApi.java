package com.ja.visitor_reg.api;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.ja.visitor_reg.common.util.ApplicationUtil;
import com.ja.visitor_reg.common.util.SharedPreferencesUtil;
import com.ja.visitor_reg.json.AUTHOR_CARD;
import com.ja.visitor_reg.json.DISCARD_INFO;
import com.ja.visitor_reg.json.LOGIN_INFO;
import com.ja.visitor_reg.json.RESP_DICT;
import com.ja.visitor_reg.json.RESP_MSG;
import com.ja.visitor_reg.json.RESP_VISITEDINFO;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
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
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    private static final MediaType MEDIA_TYPE_JPG = MediaType.parse("image/jpg");
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
    public boolean login_Request(LOGIN_INFO login_info, long timeout){
        try {
            Response response = null;
            String jsonData = JSON.toJSONString(login_info);
            Log.d(TAG, "json: " + jsonData);
            RequestBody postBody =  FormBody.create(
                    MediaType.parse("application/json; charset=utf-8"),
                    jsonData);
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(timeout, TimeUnit.SECONDS)
                    .build();
            //packet url
            SharedPreferencesUtil sp = SharedPreferencesUtil.getInstance();
            StringBuilder urlBuilder = new StringBuilder().append("http://")
                    .append(sp.getStringValue("serIp", ""))
                    .append(":")
                    .append(sp.getIntValue("serPort", 0))
                    .append("/ja-api/api/device/login");

            Log.d(TAG, "Login_Request url=" + urlBuilder.toString());
            Request request = new Request.Builder()
                    //.url("http://192.168.11.51:9090/ja-api/api/device/login")
                    .url(urlBuilder.toString())
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

   public boolean logout_Request(long timeout){
       try {
           Response response = null;
           OkHttpClient client = new OkHttpClient.Builder()
                   .connectTimeout(timeout, TimeUnit.SECONDS)
                   .build();
           RequestBody postBody =  FormBody.create(
                   MediaType.parse("application/json; charset=utf-8"),
                   "");
           //packet url
           SharedPreferencesUtil sp = SharedPreferencesUtil.getInstance();
           StringBuilder urlBuilder = new StringBuilder().append("http://")
                   .append(sp.getStringValue("serIp", ""))
                   .append(":")
                   .append(sp.getIntValue("serPort", 0))
                   .append("/ja-api/api/device/logout");

           Log.d(TAG, "Logout_Request url=" + urlBuilder.toString());
           Request request = new Request.Builder()
                   //.url("http://192.168.11.51:9090/ja-api/api/device/logout")
                   .url(urlBuilder.toString())
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
   public boolean getDevId_Request(long timeout){
       try {
           Response response = null;
           OkHttpClient client = new OkHttpClient.Builder()
                   .connectTimeout(timeout, TimeUnit.SECONDS)
                   .build();
           //packet url
           SharedPreferencesUtil sp = SharedPreferencesUtil.getInstance();
           StringBuilder urlBuilder = new StringBuilder().append("http://")
                   .append(sp.getStringValue("serIp", ""))
                   .append(":")
                   .append(sp.getIntValue("serPort", 0))
                   .append("/ja-api/api/device/deviceId");

           Log.d(TAG, "GetDevId_Request url=" + urlBuilder.toString());
           Request request = new Request.Builder()
                   //.url("http://192.168.11.51:9090/ja-api/api/device/deviceId")
                   .url(urlBuilder.toString())
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
   public boolean getDevInfo_Request(long timeout){
       try {
           Response response = null;
           OkHttpClient client = new OkHttpClient.Builder()
                   .connectTimeout(timeout, TimeUnit.SECONDS)
                   .build();
           //packet url
           SharedPreferencesUtil sp = SharedPreferencesUtil.getInstance();
           StringBuilder urlBuilder = new StringBuilder().append("http://")
                   .append(sp.getStringValue("serIp", ""))
                   .append(":")
                   .append(sp.getIntValue("serPort", 0))
                   .append("/ja-api/api/device/deviceInfo");

           Log.d(TAG, "GetDevInfo_Request url=" + urlBuilder.toString());
           Request request = new Request.Builder()
                   //.url("http://192.168.11.51:9090/ja-api/api/device/deviceInfo")
                   .url(urlBuilder.toString())
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
     * GetIntervieweeInfoByMobile
     * no token
     * @param strPhone 电话号码
     * @return RESP_VISITEDINFO
     */
   public RESP_VISITEDINFO getVDInfoByMobile_Request(String strPhone, long timeout){
       RESP_VISITEDINFO resp_msg = null;
       try {
           Response response = null;
           String strUrl;
           OkHttpClient client = new OkHttpClient.Builder()
                   .connectTimeout(timeout, TimeUnit.SECONDS)
                   .build();
           //ready param
           //strUrl = "http://192.168.11.51:9090/ja-api/api/sysuser/getbymobile?mobile=";
           //packet url
           SharedPreferencesUtil sp = SharedPreferencesUtil.getInstance();
           StringBuilder urlBuilder = new StringBuilder().append("http://")
                   .append(sp.getStringValue("serIp", ""))
                   .append(":")
                   .append(sp.getIntValue("serPort", 0))
                   .append("/ja-api/api/sysuser/getbymobile?mobile=")
                   .append(strPhone);

           Log.d(TAG, "GetVisitedInfoByMobile url=" + urlBuilder.toString());
           Request request = new Request.Builder()
                   .url(urlBuilder.toString())
                   .header("Accept", "text/html")
                   .get()
                   .build();
           //response
           response = client.newCall(request).execute();
           String strBody = response.body().string();
           Log.d(TAG, "resp: " + strBody);
           resp_msg  = JSON.parseObject(strBody, RESP_VISITEDINFO.class);
           Log.d(TAG, "parse msg: " + resp_msg.getMsg());
           Log.d(TAG, "parse list len: " + resp_msg.getList().size());
       } catch (IOException e) {
           e.printStackTrace();
           return null;
       }
       return resp_msg;
   }

    /**
     * 查询字典
     * no token
     * @param type 查询的类型
     * @param timeout 超时时间(s)
     * @return RESP_DICT对象
     */
   public RESP_DICT getDict_Request(String type, long timeout) {
       RESP_DICT resp_dict = null;
       try {
           Response response = null;
           String strUrl;
           OkHttpClient client = new OkHttpClient.Builder()
                   .connectTimeout(timeout, TimeUnit.SECONDS)
                   .build();
           Log.d(TAG, "read_timeout:"+client.readTimeoutMillis());
           //packet url
           SharedPreferencesUtil sp = SharedPreferencesUtil.getInstance();
           StringBuilder urlBuilder = new StringBuilder().append("http://")
                   .append(sp.getStringValue("serIp", ""))
                   .append(":")
                   .append(sp.getIntValue("serPort", 0))
                   .append("/ja-api/api/dict/list?type=")
                   .append(type);

           Log.d(TAG, "getDict_Request url=" + urlBuilder.toString());
           Request request = new Request.Builder()
                   .url(urlBuilder.toString())
                   .header("Accept", "text/html")
                   .get()
                   .build();
           //response
           response = client.newCall(request).execute();
           String strBody = response.body().string();
           Log.d(TAG, "resp: " + strBody);
           resp_dict  = JSON.parseObject(strBody, RESP_DICT.class);
           Log.d(TAG, "parse msg: " + resp_dict.getMsg());
           Log.d(TAG, "parse list len: " + resp_dict.getList().size());
       } catch (IOException e) {
           e.printStackTrace();
           return null;
       }
       return resp_dict;
   }

    /**
     * 授权卡请求
     * @param author_card 请求卡数据
     * @param timeout 连接超时时间(s)
     * @return true/false
     * post form
     * {
     * "cardNum": "111",
     * "depId": 0,
     * "vieweeId": 0,
     * "visitorIdNum": "222"
     * }
     * resp
     * {"msg":"success","code":0}
     */
   public boolean authorCard_Request(AUTHOR_CARD author_card, long timeout) {
       try {
           String strUrl;
           Response response = null;
           String jsonData = JSON.toJSONString(author_card);
           Log.d(TAG, "json: " + jsonData);
           RequestBody postBody =  FormBody.create(
                   MediaType.parse("application/json; charset=utf-8"),
                   jsonData);
           OkHttpClient client = new OkHttpClient.Builder()
                   .connectTimeout(timeout, TimeUnit.SECONDS)
                   .build();
           Log.d(TAG, "read_timeout:"+client.readTimeoutMillis());
           //packet url
           SharedPreferencesUtil sp = SharedPreferencesUtil.getInstance();
           StringBuilder urlBuilder = new StringBuilder().append("http://")
                   .append(sp.getStringValue("serIp", ""))
                   .append(":")
                   .append(sp.getIntValue("serPort", 0))
                   .append("/ja-api/api/access/auth");

           Log.d(TAG, "authorCard_Request url=" + urlBuilder.toString());
           Request request = new Request.Builder()
                   .url(urlBuilder.toString())
                   .header("Accept", "text/html")
                   .addHeader("Content-Type", "application/json")
                   .post(postBody)
                   .build();
           //response
           response = client.newCall(request).execute();
           String strBody = response.body().string();
           Log.d(TAG, "resp: " + strBody);
           RESP_MSG resp_msg = JSON.parseObject(strBody, RESP_MSG.class);
           return resp_msg.getMsg().equals("success");

       } catch (IOException e) {
           e.printStackTrace();
           return false;
       }
   }


    /**
     * 撤销卡
     * @param discard_info 撤销信息
     * @param timeout 连接超时(s)
     * @return true/false
     * post form
     * {
     * "cardNum": "string",
     * "depId": 0,
     * "vieweeId": 0,
     * "visitorIdNum": "string"
     * }
     * resp
     * {"msg":"success","code":0}
     */
   public boolean discard_Request(DISCARD_INFO discard_info, long timeout) {
       try {
           String strUrl;
           Response response = null;
           String jsonData = JSON.toJSONString(discard_info);
           Log.d(TAG, "json: " + jsonData);
           RequestBody postBody =  FormBody.create(
                   MediaType.parse("application/json; charset=utf-8"),
                   jsonData);
           OkHttpClient client = new OkHttpClient.Builder()
                   .connectTimeout(timeout, TimeUnit.SECONDS)
                   .build();
           //packet url
           SharedPreferencesUtil sp = SharedPreferencesUtil.getInstance();
           StringBuilder urlBuilder = new StringBuilder().append("http://")
                   .append(sp.getStringValue("serIp", ""))
                   .append(":")
                   .append(sp.getIntValue("serPort", 0))
                   .append("/ja-api/api/access/discard");

           Log.d(TAG, "authorCard_Request url=" + urlBuilder.toString());
           Request request = new Request.Builder()
                   .url(urlBuilder.toString())
                   .header("Accept", "text/html")
                   .addHeader("Content-Type", "application/json")
                   .post(postBody)
                   .build();
           //response
           response = client.newCall(request).execute();
           String strBody = response.body().string();
           Log.d(TAG, "resp: " + strBody);
           RESP_MSG resp_msg = JSON.parseObject(strBody, RESP_MSG.class);
           return resp_msg.getMsg().equals("success");

       } catch (IOException e) {
           e.printStackTrace();
           return false;
       }
   }
    /**
     * http上传图片 单张图片
     * @param imgPath
     * @return
     */
   public boolean upload_ImgFile(String imgPath) {
       int cacheSize = 10 * 1024 * 1024;

       try {
           //设置时间和缓存
           OkHttpClient client = new OkHttpClient.Builder()
                   .connectTimeout(15, TimeUnit.SECONDS)
                   .writeTimeout(20, TimeUnit.SECONDS)
                   .readTimeout(20, TimeUnit.SECONDS)
                   .cache(new Cache(new File(ApplicationUtil.getContext().getFilesDir().getPath()), cacheSize))
                   .build();

           MultipartBody.Builder mbody=new MultipartBody.Builder().setType(MultipartBody.FORM);

           File imgFile = new File(imgPath);
           if(imgFile.exists()){
               Log.i(TAG, imgFile.getName());
               mbody.addFormDataPart("image", imgFile.getName(), RequestBody.create(MEDIA_TYPE_JPG, imgFile));
           }

           //packet url
           SharedPreferencesUtil sp = SharedPreferencesUtil.getInstance();
           StringBuilder urlBuilder = new StringBuilder().append("http://")
                   .append(sp.getStringValue("serIp", ""))
                   .append(":")
                   .append(sp.getIntValue("serPort", 0))
                   .append("/ja-api/api/image/imageUpload");

           RequestBody requestBody = mbody.build();
           Request request = new Request.Builder()
                   .header("Accept", "text/html")
                   .url(urlBuilder.toString())
                   .post(requestBody)
                   .build();

//       client.newCall(request).enqueue(new Callback() {
//           @Override
//           public void onFailure(Call call, IOException e) {
//           }
//
//           @Override
//           public void onResponse(Call call, Response response) throws IOException {
//               Log.i("InfoMSG", response.body().string());
//           }
//       });

           Response resp = client.newCall(request).execute();
           String strBody = resp.body().string();
           Log.d(TAG, "resp: " + strBody);
           RESP_MSG resp_msg  = JSON.parseObject(strBody, RESP_MSG.class);
           Log.d(TAG, "parse msg: " + resp_msg.getMsg());

       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }

       return true;
   }

}
