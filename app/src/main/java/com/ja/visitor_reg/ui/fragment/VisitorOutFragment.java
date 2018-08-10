package com.ja.visitor_reg.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.adapter.VisitRecordAdapter;
import com.ja.visitor_reg.common.base.BaseFragment;
import com.ja.visitor_reg.common.util.DateUtil;
import com.ja.visitor_reg.entity.VisitInfoEntity;
import com.ja.visitor_reg.model.VisitRecordItem;
import com.ja.visitor_reg.task.DBTask;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VisitorOutFragment extends BaseFragment {
    private VisitRecordAdapter mVisitRecordAdapter;
    private List<VisitRecordItem> mRecordList = new ArrayList<VisitRecordItem>();

    @BindView(R.id.recy_visitin_record) RecyclerView mRecyVisitRecord;


    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_visit_out, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        //recycler
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyVisitRecord.setLayoutManager(layoutManager);
        mVisitRecordAdapter = new VisitRecordAdapter(mRecordList);
        mRecyVisitRecord.setAdapter(mVisitRecordAdapter);
    }

    @OnClick(R.id.btn_visitout_search)
    void onClick_Search(View v) {
        Toast.makeText(mContext,"搜索", Toast.LENGTH_SHORT).show();
        DBTask dbTask = DBTask.getInstance();
        dbTask.start_QueryVisitRecord(new DBTask.onDBQueryResultListener() {
            @Override
            public void onQueryResult(List<?> list) {
                List<VisitInfoEntity> visitList = (List<VisitInfoEntity>) list;
                for (VisitInfoEntity itme : visitList) {
                    VisitRecordItem recordItem = new VisitRecordItem();
                    recordItem.setVisitName(itme.getVisitor_name());
                    recordItem.setIdNum(itme.getId_numer());
                    recordItem.setVisitPhone(itme.getBook_phone());
                    recordItem.setVisitTime(DateUtil.getDateTimeFormat(itme.getIn_time()));
                    mRecordList.add(recordItem);
                }
                mVisitRecordAdapter.notifyDataSetChanged();
            }
        });

    }
}
