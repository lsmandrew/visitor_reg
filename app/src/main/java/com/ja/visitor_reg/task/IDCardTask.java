package com.ja.visitor_reg.task;

import android.app.Activity;
import android.os.AsyncTask;

import com.ja.visitor_reg.common.util.IdCardReaderUtil;

/**
 *  读卡任务
 */
public class IDCardTask extends AsyncTask<Void, Integer, Boolean> {
    private IdCardReaderUtil mIdUtil;

    public IDCardTask() {
        mIdUtil = IdCardReaderUtil.getInstance();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mIdUtil.init_data();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        if (null != mIdUtil){
            return mIdUtil.read_Idcard();
        }else {
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        mIdUtil.post_result(result);
    }

    public void start_ReadCardAsync(Activity activity, IdCardReaderUtil.readIDCardListener listener) {
        mIdUtil.setup_param(activity,listener);
        this.execute();
    }
}
