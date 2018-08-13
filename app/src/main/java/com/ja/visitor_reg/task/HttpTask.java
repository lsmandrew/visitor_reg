package com.ja.visitor_reg.task;

import android.os.AsyncTask;

import com.ja.visitor_reg.api.HttpApi;
import com.ja.visitor_reg.json.AUTHOR_CARD;
import com.ja.visitor_reg.json.RESP_DICT;

public class HttpTask extends AsyncTask<Integer, Integer, Boolean> {

    private RESP_DICT mDict;
    private AUTHOR_CARD mAuthorCard;
    private onQueryDictResultListener mQueryDictListener;
    private onAuthorCardResultListener mAuthorCardListener;
    private int nCmd = 0x00;

    private static final int HTTP_QUERY_CERTTYPE = 0x01;
    private static final int HTTP_QUERY_CAUSETYPE = 0x02;
    private static final int HTTP_AUTHOR_CARD = 0x03;


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(Integer... args) {
        Boolean result = false;
        nCmd = args[0];
        switch (nCmd) {
            case HTTP_QUERY_CERTTYPE:
                mDict = http_QueryCertType();
                result = null == mDict ?  false : true;
                break;
            case HTTP_QUERY_CAUSETYPE:
                mDict = http_QueryCauseType();
                result = null == mDict ? false : true;
                break;
            case HTTP_AUTHOR_CARD:
                if (null != mAuthorCard) {
                    result = http_AuthorCard(mAuthorCard);
                }else {
                    result = false;
                }
                break;
        }

        return result;
    }



    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        switch (nCmd) {
            case HTTP_QUERY_CERTTYPE:
            case HTTP_QUERY_CAUSETYPE:
                if (null != mQueryDictListener) {
                    mQueryDictListener.onQueryDictResult(mDict);
                }
                break;
            case HTTP_AUTHOR_CARD:
                if (null != mAuthorCardListener) {
                    mAuthorCardListener.onAuthorCardResult(result);
                }
                break;
        }

    }



    /////////////////////接口///////////////////////////
    public interface onQueryDictResultListener {
        void onQueryDictResult(RESP_DICT resp_dict);
    }

    public interface onAuthorCardResultListener {
        void onAuthorCardResult(Boolean result);
    }
    ////////////////////////////////////////////////////////
    private RESP_DICT http_QueryCauseType() {
        HttpApi httpApi = new HttpApi();
        String type = "causeofvisit";
        return httpApi.getDict_Request(type, 2);
    }

    private RESP_DICT http_QueryCertType() {
        HttpApi httpApi = new HttpApi();
        String type = "cert_type";
        return httpApi.getDict_Request(type, 2);
    }

    private Boolean http_AuthorCard(AUTHOR_CARD authorCard) {
        HttpApi client = new HttpApi();
        return client.authorCard_Request(authorCard, 2000);
    }
    //////////////////////////////////////////////////////////////
    /**
     * 查询证件字典类型
     */
    public void start_Query_CertType(onQueryDictResultListener listener) {
        mQueryDictListener = listener;
        this.execute(HTTP_QUERY_CERTTYPE);
    }

    /**
     * 查询事由类型
     */
    public void start_Query_CauseType(onQueryDictResultListener listener) {
        mQueryDictListener = listener;
        this.execute(HTTP_QUERY_CAUSETYPE);
    }

    /**
     * 授权卡
     * @param listener
     */
    public void start_Author_Card(AUTHOR_CARD author_card, onAuthorCardResultListener listener) {
        mAuthorCardListener = listener;
        mAuthorCard = author_card;
        this.execute(HTTP_AUTHOR_CARD);
    }
}
