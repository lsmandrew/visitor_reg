package com.ja.visitor_reg.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.common.base.BaseActivity;

/**
 * 信息查詢
 */
public class QueryInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query_info);
    }

    public void onClick_Visitor(View view) {
        Intent intent = new Intent(this, VisitorInfoActivity.class);
        startActivity(intent);
    }

    public void onClick_Interviewee(View view) {
        Intent intent = new Intent(this, InterviewInfoActivity.class);
        startActivity(intent);
    }

    public void onClick_VisitRecord(View view) {
        Intent intent = new Intent(this, VisitRecordActivity.class);
        startActivity(intent);
    }


    public void onClick_BookInfo(View view) {
        Intent intent = new Intent(this, BookInfoActivity.class);
        startActivity(intent);

    }


    public void onClick_WhiteList(View view) {
        Intent intent = new Intent(this, WhiteListActivity.class);
        startActivity(intent);
    }


    public void onClick_BlackList(View view) {
        Intent intent = new Intent(this, BlackListActivity.class);
        startActivity(intent);
    }
}
