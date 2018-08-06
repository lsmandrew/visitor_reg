package com.ja.visitor_reg.ui.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.zxing.other.BeepManager;
import com.ja.visitor_reg.R;
import com.ja.visitor_reg.adapter.CauseAdapter;
import com.ja.visitor_reg.adapter.CertTypeAdapter;
import com.ja.visitor_reg.adapter.SexTypeAdapter;
import com.ja.visitor_reg.adapter.VisitorInInfoAdapter;
import com.ja.visitor_reg.common.base.BaseFragment;
import com.ja.visitor_reg.common.util.DateUtil;
import com.ja.visitor_reg.common.util.IdCardReaderUtil;
import com.ja.visitor_reg.entity.VisitEventEntity;
import com.ja.visitor_reg.entity.VisitInfoEntity;
import com.ja.visitor_reg.model.CauseTypeItem;
import com.ja.visitor_reg.model.CertTypeItem;
import com.ja.visitor_reg.model.SexTypeItem;
import com.ja.visitor_reg.model.VdInfoItem;
import com.ja.visitor_reg.model.VisitInInfoItem;
import com.ja.visitor_reg.task.DBTask;
import com.ja.visitor_reg.ui.camera.CameraView;
import com.ja.visitor_reg.ui.dialog.VdInfoDialog;
import com.orhanobut.logger.Logger;
import com.parkingwang.keyboard.KeyboardInputController;
import com.parkingwang.keyboard.OnInputChangedListener;
import com.parkingwang.keyboard.PopupKeyboard;
import com.parkingwang.keyboard.view.InputView;
import com.telpo.tps550.api.idcard.IdentityInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private VisitorInInfoAdapter m_VisitInAdapter;
    private List<CertTypeItem>  mCertTypeList = new ArrayList<CertTypeItem>();
    private List<SexTypeItem>  mSexTypeList = new ArrayList<SexTypeItem>();
    private List<CauseTypeItem> mCauseTypeList = new ArrayList<CauseTypeItem>();
    private List<VisitInInfoItem> mVisitInList = new ArrayList<VisitInInfoItem>();
    private PopupKeyboard mPopupKeyboard;
    private VisitEventEntity mEventEntity;
    private VisitInfoEntity mVisitInfoEntity;
    private boolean mIsStartCheckIn;


    @BindView(R.id.sp_cert_type) Spinner mSpCertType;
    @BindView(R.id.sp_sex_type) Spinner mSpSexType;
    @BindView(R.id.sp_cause) Spinner mSpCause;
    @BindView(R.id.input_view_car)  InputView mIvCar;
    @BindView(R.id.btn_newpower_car) Button mBtnNewPower;
    @BindView(R.id.edt_visitor_count) EditText mEdtVisitCount;
    @BindView(R.id.edt_interviewee) EditText mEdtInterviewee;
    @BindView(R.id.edt_visitor_phone) EditText mEdtVisitPhone;
    @BindView(R.id.edt_be_phone) EditText mEdtBePhone;
    @BindView(R.id.edt_id_code)EditText mEdtIdCode;
    @BindView(R.id.edt_name)EditText mEdtName;
    @BindView(R.id.edt_visitor_unit)EditText mEdtUnit;
    @BindView(R.id.edt_goods)EditText mEdtGoods;
    @BindView(R.id.img_head) ImageView mImgHead;
    @BindView(R.id.camera_preview)CameraView mCameraView;
    @BindView(R.id.recycle_view)RecyclerView mRecyVisitIn;
    @BindView(R.id.btn_start_checkin)Button mBtnStartCheckIn;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.activity_idcard2, null);
        ButterKnife.bind(this, view);
        //view.setOnClickListener(this);

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
                    if (null != getActivity()) {
                        mPopupKeyboard.dismiss(getActivity());
                    }
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
        String[] sexTypes = getResources().getStringArray(R.array.sex_types);
        for (String item : sexTypes){
            mSexTypeList.add(new SexTypeItem(item));
        }
        mSexAdapter = new SexTypeAdapter(mContext, mSexTypeList);
        mSpSexType.setAdapter(mSexAdapter);
        //cause type
        mCauseTypeList.add(new CauseTypeItem("商务"));
        mCauseTypeList.add(new CauseTypeItem("政务"));
        mCauseTypeList.add(new CauseTypeItem("军务"));
        mCauseAdapter = new CauseAdapter(mContext, mCauseTypeList);
        mSpCause.setAdapter(mCauseAdapter);
        //recycler
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyVisitIn.setLayoutManager(layoutManager);
        m_VisitInAdapter = new VisitorInInfoAdapter(mVisitInList);
        mRecyVisitIn.setAdapter(m_VisitInAdapter);

    }



    void ui_UpdateIdInfo(IdentityInfo info, Bitmap bitmapHead) {
        mEdtIdCode.setText(info.getNo());
        mEdtName.setText(info.getName().replace(" ", ""));
        mSpSexType.setSelection(getPosBySex(info.getSex().substring(0, 1)));
        if (null != bitmapHead) {
            mImgHead.setImageBitmap(bitmapHead);
        }
    }

    int getPosBySex(String sex) {
        Map<String, Integer> sexMap = new HashMap<>();
        sexMap.put("男", 0);
        sexMap.put("女", 1);
        sexMap.put("不详", 2);
        return sexMap.get(sex);

    }

    /**
     * 拍照
     */
    public void take_pic(String picName){
        mCameraView.doTakePicture(picName);
    }
    /**
     * 点击窗体隐藏键盘
     * @param v 视图
     */
    @OnClick(R.id.layout_idcard2)
    void onClick_OtherWindow(View v) {
        if (null != getActivity()) {
            mPopupKeyboard.dismiss(getActivity());
        }
        //关闭软键盘
        InputMethodManager inputManager = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getView().getWindowToken(), 0);

    }

    @OnClick(R.id.edt_interviewee)
    void onClick_Interviewee(View view){
        //Logger.d("interviewee onClick");
        //query
        //create dialog
        List<VdInfoItem> vdInfoList = new ArrayList<VdInfoItem>();
//        vdInfoList.add(new VdInfoItem("研发部", "李晓明", "11111111111", true));
//        vdInfoList.add(new VdInfoItem("市场调研部", "欧阳优雅", "22222222222", true));
//        vdInfoList.add(new VdInfoItem("软件部", "笑笑笑", "33333333333", true));
        VdInfoDialog vdInfoDialog = new VdInfoDialog(mContext, vdInfoList);
        vdInfoDialog.setOnGetVdInfoCallBack(new VdInfoDialog.OnGetVdInfoListener(){

            @Override
            public void getVdInfo(VdInfoItem vdInfoItem) {
                mEdtInterviewee.setText(vdInfoItem.getName());
                mEdtBePhone.setText(vdInfoItem.getWorkPhone());
            }
        });
        vdInfoDialog.show();
    }


    @OnClick(R.id.btn_scan_cert)
    void onClick_Scan_Cert(View v) {
        IdCardReaderUtil util = IdCardReaderUtil.getInstance();
        util.start_ReadCardAsync(getActivity(), new IdCardReaderUtil.readIDCardListener() {
            @Override
            public void onReadIDCardInfo(IdentityInfo info, Bitmap bitmapHead) {

                if (null != info) {
                    Toast.makeText(mContext, "身份证读取成功", Toast.LENGTH_SHORT).show();
                    //sucess 鸣叫
                    BeepManager beepManager = new BeepManager(getActivity(), R.raw.beep);
                    //beepManager.playBeepSoundAndVibrate();
                    //更新ui
                    ui_UpdateIdInfo(info, bitmapHead);
                } else {
                    Toast.makeText(mContext, "身份证读取失败", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @OnClick(R.id.btn_author_card)
    void onClick_Author_Card(View v){

    }

    /**
     * 拍摄人像
     * @param v
     */
    @OnClick(R.id.btn_take_portrait)
    void onClick_TakePortrait(View v){
        String picPath;

        //paht:LIVE_设备名_时间.jpg
        picPath = mContext.getFilesDir().getPath().toString();//获取file路径
        picPath += "/LIVE_" + DateUtil.getNowDateTimeFormat() + ".jpg";
        Logger.d("save path=" + picPath);
        take_pic(picPath);
        //save
        if (null == mVisitInfoEntity){
            mVisitInfoEntity = new VisitInfoEntity();
        }
        mVisitInfoEntity.setImg_portrait(picPath);
    }

    /**
     * 拍摄物品
     * @param v
     */
    @OnClick(R.id.btn_take_goods)
    void onClick_TakeGoods(View v) {
        String picPath;

        //paht:LIVE_设备名_时间.jpg
        picPath = mContext.getFilesDir().getPath().toString();//获取file路径
        picPath += "/Goods_" + DateUtil.getNowDateTimeFormat() + ".jpg";
        Logger.d("save path=" + picPath);
        take_pic(picPath);
        //save
        if (null == mVisitInfoEntity){
            mVisitInfoEntity = new VisitInfoEntity();
        }
        mVisitInfoEntity.setImg_portrait(picPath);
    }

    @OnClick(R.id.btn_start_checkin)
    void onClick_Start_CheckIn(View v){
        //title 不可编辑
        //check
        String strCount = mEdtVisitCount.getText().toString();

        if (null == strCount || 0 == strCount.length()) {
            return ;
        }
        //save 来访事件data
        if (!mIsStartCheckIn) {
            mBtnStartCheckIn.setText("重新登记");
            mEventEntity = new VisitEventEntity();
            mEventEntity.setVisitorCount(Integer.parseInt(strCount));
        }else {
            mBtnStartCheckIn.setText("开始登记");
        }

        mIsStartCheckIn = !mIsStartCheckIn;
    }

    /**
     * 完成登记
     */
    @OnClick(R.id.btn_finish)
    void onClick_Finish(View v) {
        if (!vaild_VisitorInfo()){
            Toast.makeText(mContext, "登记信息有误", Toast.LENGTH_SHORT).show();
            return;
        }
        //获取信息
        if (null == mVisitInfoEntity){
            mVisitInfoEntity = new VisitInfoEntity();
        }
        get_VisitorInfo(mVisitInfoEntity);
        DBTask task = DBTask.getInstance();
        task.start_AddVisitInfoAsync(mVisitInfoEntity, new DBTask.onDBResultListener() {
            @Override
            public void onResult(boolean result) {
                if (result) {
                    Toast.makeText(mContext, "登记保存成功", Toast.LENGTH_SHORT).show();
                    //update result show
                    mVisitInList.add(0, new VisitInInfoItem(mVisitInfoEntity.getVisitor_name(),
                            mEdtInterviewee.getText().toString(),  mVisitInfoEntity.getBook_phone(),
                            "", "", ""));
                    m_VisitInAdapter.notifyItemInserted(0);
                } else {
                    Toast.makeText(mContext, "登记保存失败", Toast.LENGTH_SHORT).show();
                }
                mVisitInfoEntity = null;
            }
        });


    }

    /**
     * 检测来访者信息是否有效
     *
     * @return true/false
     */
    private boolean vaild_VisitorInfo() {
        String strName = mEdtName.getText().toString();
        String strIdNum = mEdtIdCode.getText().toString();
        String strPhone = mEdtVisitPhone.getText().toString();

        if (null == strName || 0 == strName.length()) {
            return false;
        }

        if (null == strIdNum || 0 == strIdNum.length()) {
            return false;
        }

        if (null == strPhone || 0 == strPhone.length()) {
            return false;
        }

        return true;
    }

    private void get_VisitorInfo(VisitInfoEntity visitEntity) {

        //来访者名字
        if (null != mEdtName.getText()) {
            visitEntity.setVisitor_name(mEdtName.getText().toString());
        }
        //性别
        if (null != mSpSexType.getSelectedItem()) {
            SexTypeItem item = (SexTypeItem) mSpSexType.getSelectedItem();
            visitEntity.setSex(item.getName());
        }
        //证件号码
        if (null != mEdtIdCode.getText()) {
            visitEntity.setId_numer(mEdtIdCode.getText().toString());
        }
        //事由
        if (null != mEventEntity) {
            visitEntity.setVisit_event_id(mEventEntity.getId());
        }
        //来访电话
        if (null != mEdtVisitPhone.getText()) {
            visitEntity.setBook_phone(mEdtVisitPhone.getText().toString());
        }
        //部门
        if (null != mEdtUnit.getText()) {
            visitEntity.setDeparment(mEdtUnit.getText().toString());
        }
        //携带物品
        if (null != mEdtGoods.getText()){
            visitEntity.setGoods(mEdtGoods.getText().toString());
        }
        //车牌
        visitEntity.setCar_plate(mIvCar.getNumber());
        //头像图片

        //人像照片

        //来访时间
        visitEntity.setIn_time(new Date());
    }

}
