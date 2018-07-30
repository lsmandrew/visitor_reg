package com.ja.visitor_reg.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.adapter.CauseAdapter;
import com.ja.visitor_reg.adapter.CertTypeAdapter;
import com.ja.visitor_reg.adapter.SexTypeAdapter;
import com.ja.visitor_reg.common.base.BaseFragment;
import com.ja.visitor_reg.model.CauseTypeItem;
import com.ja.visitor_reg.model.CertTypeItem;
import com.ja.visitor_reg.model.SexTypeItem;
import com.ja.visitor_reg.ui.dialog.VdInfoDialog;
import com.orhanobut.logger.Logger;
import com.parkingwang.keyboard.KeyboardInputController;
import com.parkingwang.keyboard.OnInputChangedListener;
import com.parkingwang.keyboard.PopupKeyboard;
import com.parkingwang.keyboard.view.InputView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 來訪登記
 */
public class VisitorInFragment extends BaseFragment {

    private CertTypeAdapter mCertAdapter;
    private SexTypeAdapter  mSexAdapter;
    private CauseAdapter    mCauseAdapter;
    private List<CertTypeItem>  mCertTypeList = new ArrayList<>();
    private List<SexTypeItem>  mSexTypeList = new ArrayList<>();
    private List<CauseTypeItem> mCauseTypeList = new ArrayList<>();
    private PopupKeyboard mPopupKeyboard;
    @BindView(R.id.sp_cert_type) Spinner mSpCertType;
    @BindView(R.id.sp_sex_type) Spinner mSpSexType;
    @BindView(R.id.sp_cause) Spinner mSpCause;
    @BindView(R.id.input_view_car)  InputView mIvCar;
    @BindView(R.id.btn_newpower_car) Button mBtnNewPower;
    @BindView(R.id.edt_visitor_count) EditText mEdtVisitCount;
    @BindView(R.id.edt_interviewee) EditText mEdtInterviewee;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.activity_idcard2, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    protected void initData() {
        //car
        mPopupKeyboard = new PopupKeyboard(mContext);
        mPopupKeyboard.attach(mIvCar, getActivity());
        mPopupKeyboard.getKeyboardEngine().setHideOKKey(true);
        // KeyboardInputController提供一个默认实现的新能源车牌锁定按钮
        mPopupKeyboard.getController()
                .setDebugEnabled(true)
                .bindLockTypeProxy(new KeyboardInputController.ButtonProxyImpl(mBtnNewPower) {
                    @Override
                    public void onNumberTypeChanged(boolean isNewEnergyType) {
                        super.onNumberTypeChanged(isNewEnergyType);
                        if (isNewEnergyType) {
                            mBtnNewPower.setTextColor(getResources().getColor(android.R.color.holo_green_light));

                        } else {
                            mBtnNewPower.setTextColor(getResources().getColor(android.R.color.black));

                        }
                    }
                });
        mPopupKeyboard.getController().addOnInputChangedListener(new OnInputChangedListener() {
            @Override
            public void onChanged(String number, boolean isCompleted) {
                Logger.i(number);
                if(isCompleted){
                    //mInputView.setVisibility(View.INVISIBLE);
                    mPopupKeyboard.dismiss(getActivity());
                }
            }

            @Override
            public void onCompleted(String number, boolean isAutoCompleted) {
                Log.e("car keyboard", "onCompleted: ");

            }

        });
        //cert type
        mCertTypeList.add(new CertTypeItem("身份证"));
        mCertTypeList.add(new CertTypeItem("学生证"));
        mCertTypeList.add(new CertTypeItem("军官证"));
        mCertAdapter = new CertTypeAdapter(mContext, mCertTypeList);
        mSpCertType.setAdapter(mCertAdapter);
        //sex type
        mSexTypeList.add(new SexTypeItem("男"));
        mSexTypeList.add(new SexTypeItem("女"));
        mSexTypeList.add(new SexTypeItem("不详"));
        mSexAdapter = new SexTypeAdapter(mContext, mSexTypeList);
        mSpSexType.setAdapter(mSexAdapter);
        //cause type
        mCauseTypeList.add(new CauseTypeItem("商务"));
        mCauseTypeList.add(new CauseTypeItem("政务"));
        mCauseTypeList.add(new CauseTypeItem("军务"));
        mCauseAdapter = new CauseAdapter(mContext, mCauseTypeList);
        mSpCause.setAdapter(mCauseAdapter);
        //bind
        //mEdtInterviewee.addTextChangedListener(new onTextWatcher());
        //mEdtInterviewee.setOnClickListener(new onAllClickListener());
        //mEdtVisitCount.addTextCangedListener(new onTextWatcher());
        //mEdtVisitCount.setOnEditorActionListener();
    }

    @OnClick(R.id.edt_interviewee)
    void onClick_Interviewee(View view){
        //Logger.d("interviewee onClick");
        //query
        //create dialog
        VdInfoDialog vdInfoDialog = new VdInfoDialog(mContext);
        vdInfoDialog.show();
    }



}
