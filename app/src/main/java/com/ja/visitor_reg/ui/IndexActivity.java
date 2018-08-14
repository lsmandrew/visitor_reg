package com.ja.visitor_reg.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.common.base.BaseActivity;
import com.ja.visitor_reg.common.base.BaseFragment;
import com.ja.visitor_reg.common.util.CallerTool;
import com.ja.visitor_reg.serve.UploadService;
import com.ja.visitor_reg.ui.fragment.MoreFragment;
import com.ja.visitor_reg.ui.fragment.QueryInfoFragment;
import com.ja.visitor_reg.ui.fragment.VisitorBookFragment;
import com.ja.visitor_reg.ui.fragment.VisitorInFragment;
import com.ja.visitor_reg.ui.fragment.VisitorOutFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 首頁
 */
public class IndexActivity extends BaseActivity {
    private RadioGroup mRg_Main;
    private List<BaseFragment> mBaseFragments;
    private int mPos;
    private Fragment mCurContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        //find
        findAllViewById();
        //ready fragment
        initFragment();
        //bind listener
        bindListener();
        //server
        start_server();
    }

    private void start_server() {
        //开启副屏服务
        CallerTool.Start_Service(this, UploadService.class);
    }


    private void initFragment() {
        mBaseFragments = new ArrayList<>();
        mBaseFragments.add(new VisitorInFragment());//来访登记
        mBaseFragments.add(new VisitorBookFragment());//预约来访
        mBaseFragments.add(new VisitorOutFragment());//来访签退
        mBaseFragments.add(new QueryInfoFragment());//信息查询
        mBaseFragments.add(new MoreFragment());///更多
    }

    private void findAllViewById() {
        mRg_Main = findViewById(R.id.rg_main);
    }

    private void bindListener() {
        mRg_Main.setOnCheckedChangeListener(new MainOnCheckChangeListener());
        //设置默认
        mRg_Main.check(R.id.rb_visit_in);
    }



    class MainOnCheckChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_visit_in:
                    mPos = 0;
                    break;
                case R.id.rb_visit_book:
                    mPos = 1;
                    break;
                case R.id.rb_visit_out:
                    mPos = 2;
                    break;
                case R.id.rb_query_info:
                    mPos = 3;
                    break;
                case R.id.rb_more:
                    mPos = 4;
                    break;
            }
            //根据位置得到对应的Fragment
            BaseFragment to = getFragmentByPos(mPos);
            //替换
            switchFrament(mCurContent, to);
        }
    }

    /**
     * 根据位置获取fragment
     * @param nPos 位置
     * @return
     */
    private BaseFragment getFragmentByPos(int nPos) {
        if (mBaseFragments.size() > nPos) {
            return mBaseFragments.get(nPos);
        } else {
            return null;
        }
    }

    /**
     * 切换fragment
     * @param from
     * @param to
     */
    private void switchFrament(Fragment from, Fragment to) {

        if (to == null) {
            return;
        }

        if(from != to) {
            mCurContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if (!to.isAdded()) {
                //to没有被添加
                //from隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //添加to
                if (to != null) {
                    ft.add(R.id.fl_content, to).commit();
                }
            } else {
                //to已经被添加
                // from隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //显示to
                if (to != null) {
                    ft.show(to).commit();
                }
            }
        }

    }
}
