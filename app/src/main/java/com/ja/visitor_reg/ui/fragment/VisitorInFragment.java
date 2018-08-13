package com.ja.visitor_reg.ui.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
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
import com.ja.visitor_reg.common.util.BitmapUtil;
import com.ja.visitor_reg.common.util.DateUtil;
import com.ja.visitor_reg.common.util.IdCardReaderUtil;
import com.ja.visitor_reg.common.util.QRUtil;
import com.ja.visitor_reg.common.util.SharedPreferencesUtil;
import com.ja.visitor_reg.common.util.StringUtil;
import com.ja.visitor_reg.config.GlobalConfig;
import com.ja.visitor_reg.entity.VisitEventEntity;
import com.ja.visitor_reg.entity.VisitInfoEntity;
import com.ja.visitor_reg.json.AUTHOR_CARD;
import com.ja.visitor_reg.json.RESP_DICT;
import com.ja.visitor_reg.model.CauseTypeItem;
import com.ja.visitor_reg.model.CertTypeItem;
import com.ja.visitor_reg.model.SexTypeItem;
import com.ja.visitor_reg.model.VdInfoItem;
import com.ja.visitor_reg.model.VisitInInfoItem;
import com.ja.visitor_reg.task.DBTask;
import com.ja.visitor_reg.task.HttpTask;
import com.ja.visitor_reg.task.IDCardTask;
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
    private SexTypeAdapter mSexAdapter;
    private CauseAdapter mCauseAdapter;
    private VisitorInInfoAdapter mVisitInAdapter;
    private List<CertTypeItem> mCertTypeList = new ArrayList<CertTypeItem>();
    private List<SexTypeItem> mSexTypeList = new ArrayList<SexTypeItem>();
    private List<CauseTypeItem> mCauseTypeList = new ArrayList<CauseTypeItem>();
    private List<VisitInInfoItem> mVisitInList = new ArrayList<VisitInInfoItem>();
    private PopupKeyboard mPopupKeyboard;
    private boolean mIsStartCheckIn;
    private static VisitEventEntity mEventEntity;
    private static VisitInfoEntity mVisitInfoEntity;


    @BindView(R.id.sp_cert_type) Spinner mSpCertType;
    @BindView(R.id.sp_sex_type) Spinner mSpSexType;
    @BindView(R.id.sp_cause) Spinner mSpCause;
    @BindView(R.id.input_view_car) InputView mIvCar;
    @BindView(R.id.btn_newpower_car) Button mBtnNewPower;
    @BindView(R.id.edt_visitor_count) EditText mEdtVisitCount;
    @BindView(R.id.edt_interviewee) EditText mEdtInterviewee;
    @BindView(R.id.edt_visitor_phone) EditText mEdtVisitPhone;
    @BindView(R.id.edt_be_phone) EditText mEdtBePhone;
    @BindView(R.id.edt_id_code) EditText mEdtIdCode;
    @BindView(R.id.edt_name) EditText mEdtName;
    @BindView(R.id.edt_visitor_unit) EditText mEdtUnit;
    @BindView(R.id.edt_goods) EditText mEdtGoods;
    @BindView(R.id.img_head) ImageView mImgHead;
    @BindView(R.id.camera_preview) CameraView mCameraView;
    @BindView(R.id.recycle_view) RecyclerView mRecyVisitIn;
    @BindView(R.id.btn_start_checkin) Button mBtnStartCheckIn;
    @BindView(R.id.edt_book_phone)EditText mEdtBookPhone;
    @BindView(R.id.cb_isbook)CheckBox mCBIsBook;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_visit_in, null);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (null == mEventEntity) {
            mEventEntity = new VisitEventEntity();
        }
        if (null == mVisitInfoEntity) {
            mVisitInfoEntity = new VisitInfoEntity();
        }

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
                if (isCompleted) {
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
        //mCertTypeList.add(new CertTypeItem("身份证"));
        //mCertTypeList.add(new CertTypeItem("其他"));
        mCertAdapter = new CertTypeAdapter(mContext, mCertTypeList);
        mSpCertType.setAdapter(mCertAdapter);
        //sex type
        String[] sexTypes = getResources().getStringArray(R.array.sex_types);
        for (String item : sexTypes) {
            mSexTypeList.add(new SexTypeItem(item));
        }
        mSexAdapter = new SexTypeAdapter(mContext, mSexTypeList);
        mSpSexType.setAdapter(mSexAdapter);
        //cause type
        mCauseAdapter = new CauseAdapter(mContext, mCauseTypeList);
        mSpCause.setAdapter(mCauseAdapter);
        //recycler
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        mRecyVisitIn.setLayoutManager(layoutManager);
        mVisitInAdapter = new VisitorInInfoAdapter(mVisitInList);
        mRecyVisitIn.setAdapter(mVisitInAdapter);
        //query cause type
        mCauseTypeList.clear();
        new HttpTask().start_Query_CauseType(new HttpTask.onQueryDictResultListener() {
            @Override
            public void onQueryDictResult(RESP_DICT resp_dict) {
                if (null != resp_dict) {
                    for (RESP_DICT.ListItem item : resp_dict.getList()) {
                        mCauseTypeList.add(new CauseTypeItem(item.getName(), item.getCode()));
                    }
                    mCauseAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(mContext, "查询字典失败", Toast.LENGTH_SHORT);
                }
            }
        });
        //query cert type
        mCertTypeList.clear();
        new HttpTask().start_Query_CertType(new HttpTask.onQueryDictResultListener() {
            @Override
            public void onQueryDictResult(RESP_DICT resp_dict) {
                if (null != resp_dict) {
                    for (RESP_DICT.ListItem item : resp_dict.getList()) {
                        mCertTypeList.add(new CertTypeItem(item.getName(), item.getCode()));
                    }
                    mCertAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(mContext, "查询字典失败", Toast.LENGTH_SHORT);
                }
            }
        });

    }


    void ui_UpdateIdInfo(IdentityInfo info, Bitmap bitmapHead) {

        mEdtIdCode.setText(info.getNo());
        mEdtName.setText(info.getName().replace(" ", ""));
        mSpSexType.setSelection(getPosBySex(info.getSex().substring(0, 1)));
        if (null != bitmapHead) {
            mImgHead.setImageBitmap(bitmapHead);
            //save img_head
            String picPath;
            String picName;
            picName = mVisitInfoEntity.getImg_head();
            if (StringUtil.isEmptyTrimed(picName)) {
                SharedPreferencesUtil spUtil = SharedPreferencesUtil.getInstance();
                //name:A_设备名_证件号码_时间.jpg
                String strIdCode = mEdtIdCode.getText().toString();
                StringBuilder stringBuilder = new StringBuilder("A_")
                        .append(spUtil.getStringValue("devName", ""))
                        .append("_")
                        .append(strIdCode)
                        .append("_")
                        .append(DateUtil.getNowDateTime("yyyyMMdd_HHmmss"))
                        .append(".jpg");
                picName = stringBuilder.toString();
            }
            StringBuilder pathBuilder = new StringBuilder(GlobalConfig.get_ImgPath())
                    .append("/")
                    .append(picName);
            picPath = pathBuilder.toString();
            Logger.d("head save= " + picPath);
            BitmapUtil.saveBitmap(picPath, bitmapHead, "JPG", 100);
            mVisitInfoEntity.setImg_head(picName);
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
    public void take_pic(String picPath, String picName) {
        mCameraView.doTakePicture(picPath, picName);
    }

    /**
     * 点击窗体隐藏键盘
     *
     * @param v 视图
     */
    @OnClick(R.id.layout_idcard2)
    void onClick_OtherWindow(View v) {
        if (null != getActivity()) {
            mPopupKeyboard.dismiss(getActivity());
        }
        //关闭软键盘
        InputMethodManager inputManager = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != inputManager && null != getView().getWindowToken()) {
            inputManager.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }

    }

    @OnClick(R.id.edt_interviewee)
    void onClick_Interviewee(View view) {
        //Logger.d("interviewee onClick");
        //query
        //create dialog
        List<VdInfoItem> vdInfoList = new ArrayList<VdInfoItem>();
//        vdInfoList.add(new VdInfoItem("研发部", "李晓明", "11111111111", true));
        VdInfoDialog vdInfoDialog = new VdInfoDialog(mContext, vdInfoList);
        vdInfoDialog.setOnGetVdInfoCallBack(new VdInfoDialog.OnGetVdInfoListener() {

            @Override
            public void getVdInfo(VdInfoItem vdInfoItem) {
                mEdtInterviewee.setText(vdInfoItem.getName());
                mEdtBePhone.setText(vdInfoItem.getWorkPhone());
                mEventEntity.setIntervieweeId(vdInfoItem.getId());//被訪者id
                mEventEntity.setDeparmentId(vdInfoItem.getDeparmentId());//部门id

            }
        });
        vdInfoDialog.show();
    }


    @OnClick(R.id.btn_scan_cert)
    void onClick_Scan_Cert(View v) {
        IDCardTask task = new IDCardTask();
        task.start_ReadCardAsync(getActivity(), new IdCardReaderUtil.readIDCardListener() {
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
    void onClick_Author_Card(View v) {
        //check
        String strIdCode = mEdtIdCode.getText().toString();
        if (StringUtil.isEmptyTrimed(strIdCode)) {
            Toast.makeText(mContext, "请输入证件号码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (null == mEventEntity.getIntervieweeId()) {
            Toast.makeText(mContext, "请输入被访者", Toast.LENGTH_SHORT).show();
            return;
        }
        //author card
        AUTHOR_CARD author_card = new AUTHOR_CARD();
        author_card.setCardNum("0102030405060708");
        author_card.setDepId(mEventEntity.getDeparmentId());
        author_card.setType((long) 0);
        author_card.setVieweeId(mEventEntity.getIntervieweeId());
        author_card.setVisitorIdNum(strIdCode);
        Logger.d("Author Card= " + author_card);
        new HttpTask().start_Author_Card(author_card, new HttpTask.onAuthorCardResultListener() {
            @Override
            public void onAuthorCardResult(Boolean result) {
                if (result) {
                    Toast.makeText(mContext, "授权成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(mContext, "授权失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick(R.id.btn_print_qr)
    void onClick_Author_QR(View v) {
        Bitmap bitmap = QRUtil.create_QRImg("123456");
        if (null != bitmap) {
            //paht:GOODS_设备名_时间.jpg
            String picPath = mContext.getFilesDir().getPath().toString();//获取file路径
            picPath += "/QR_" + DateUtil.getNowDateTimeFormat() + ".jpg";
            Logger.d("save path=" + picPath);
            BitmapUtil.saveBitmap(picPath, bitmap, "JPG", 100);
        }

    }
    /**
     * 拍摄人像
     *
     * @param v
     */
    @OnClick(R.id.btn_take_portrait)
    void onClick_TakePortrait(View v) {
        String picPath;
        String picName;

        //check
        String strIdCode = mEdtIdCode.getText().toString();
        if (StringUtil.isEmptyTrimed(strIdCode)){
            Toast.makeText(mContext, "请先输入证件号码", Toast.LENGTH_SHORT).show();
            return;
        }
        //take pic
        picName = mVisitInfoEntity.getImg_portrait();
        if (StringUtil.isEmptyTrimed(picName)) {
            SharedPreferencesUtil spUtil = SharedPreferencesUtil.getInstance();
            //name:C_设备名_证件号码_时间.jpg
            StringBuilder stringBuilder = new StringBuilder("C_")
                    .append(spUtil.getStringValue("devName", ""))
                    .append("_")
                    .append(strIdCode)
                    .append("_")
                    .append(DateUtil.getNowDateTime("yyyyMMdd_HHmmss"))
                    .append(".jpg");
            picName = stringBuilder.toString();

        }

        picPath = GlobalConfig.get_ImgPath();//获取file路径
        picPath += "/";
        Logger.d("save path=" + picPath + picName);
        take_pic(picPath, picName);
        //save
        mVisitInfoEntity.setImg_portrait(picName);
    }

    /**
     * 拍摄物品
     *
     * @param v
     */
    @OnClick(R.id.btn_take_goods)
    void onClick_TakeGoods(View v) {
        String picPath;
        String picName;

        //check
        String strIdCode = mEdtIdCode.getText().toString();
        if (StringUtil.isEmptyTrimed(strIdCode)){
            Toast.makeText(mContext, "请先输入证件号码", Toast.LENGTH_SHORT).show();
            return;
        }
        //take pic
        picName = mVisitInfoEntity.getImg_goods();
        if (StringUtil.isEmptyTrimed(picName)) {
            SharedPreferencesUtil spUtil = SharedPreferencesUtil.getInstance();
            //name:E_设备名_证件号码_时间.jpg
            StringBuilder stringBuilder = new StringBuilder("E_")
                    .append(spUtil.getStringValue("devName", ""))
                    .append("_")
                    .append(strIdCode)
                    .append("_")
                    .append(DateUtil.getNowDateTime("yyyyMMdd_HHmmss"))
                    .append(".jpg");
            picName = stringBuilder.toString();
        }

        picPath = GlobalConfig.get_ImgPath();//获取file路径
        picPath += "/";
        Logger.d("save path=" + picPath);
        take_pic(picPath, picName);
        //save
        mVisitInfoEntity.setImg_goods(picName);
    }

    /**
     * 拍摄证件
     *
     * @param v
     */
    @OnClick(R.id.btn_take_cert)
    void onClick_TakeCert(View v) {
        String picPath;
        String picName;

        //check
        String strIdCode = mEdtIdCode.getText().toString();
        if (StringUtil.isEmptyTrimed(strIdCode)){
            Toast.makeText(mContext, "请先输入证件号码", Toast.LENGTH_SHORT).show();
            return;
        }
        //take pic
        picName = mVisitInfoEntity.getImg_cert();
        if (StringUtil.isEmptyTrimed(picName)) {
            SharedPreferencesUtil spUtil = SharedPreferencesUtil.getInstance();
            //name:B_设备名_证件号码_时间.jpg
            StringBuilder stringBuilder = new StringBuilder("B_")
                    .append(spUtil.getStringValue("devName", ""))
                    .append("_")
                    .append(strIdCode)
                    .append("_")
                    .append(DateUtil.getNowDateTime("yyyyMMdd_HHmmss"))
                    .append(".jpg");
            picName = stringBuilder.toString();

        }
        picPath = GlobalConfig.get_ImgPath();//获取file路径
        picPath += "/";
        take_pic(picPath, picName);
        //save
        mVisitInfoEntity.setImg_cert(picName);
    }

    void ui_Disable() {
        mEdtVisitCount.setEnabled(false);
        mEdtBePhone.setEnabled(false);
        mEdtBookPhone.setEnabled(false);
        mEdtInterviewee.setEnabled(false);
        mCBIsBook.setEnabled(false);
    }

    void ui_Enable() {
        mEdtVisitCount.setEnabled(true);
        mEdtBePhone.setEnabled(true);
        mEdtBookPhone.setEnabled(true);
        mEdtInterviewee.setEnabled(true);
        mCBIsBook.setEnabled(true);
    }

    @OnClick(R.id.btn_start_checkin)
    void onClick_Start_CheckIn(View v) {
        //check
        String strCount = mEdtVisitCount.getText().toString();
        if (StringUtil.isEmptyTrimed(strCount)) {
            Toast.makeText(mContext, "请输入来访人数", Toast.LENGTH_SHORT).show();
            return;
        }
        String strInterviewee = mEdtInterviewee.getText().toString();
        if (StringUtil.isEmptyTrimed(strInterviewee)) {
            Toast.makeText(mContext, "请选择被访人", Toast.LENGTH_SHORT).show();
            return;
        }
        //visit event 不可编辑
        ui_Disable();
        //save 来访事件data
        if (!mIsStartCheckIn) {
            mBtnStartCheckIn.setText("重新登记");
            mEventEntity.setVisitorCount(Integer.parseInt(strCount));
            mEventEntity.setInsetTime(new Date());
            //clear id
            mEventEntity.setId(null);
            //sava db
            DBTask task = new DBTask();
            task.start_AddVisitEventAsync(mEventEntity, new DBTask.onDBAddResultListener() {

                @Override
                public void onAddResult(boolean result) {
                    if (result) {
                        Logger.d("save id=" + mEventEntity.getId());
                    }
                }

            });

        } else {
            mBtnStartCheckIn.setText("开始登记");
            ui_Enable();
        }

        mIsStartCheckIn = !mIsStartCheckIn;
    }

    /**
     * 完成登记
     */
    @OnClick(R.id.btn_finish)
    void onClick_Finish(View v) {
        if (!vaild_VisitorInfo()) {
            Toast.makeText(mContext, "登记信息有误", Toast.LENGTH_SHORT).show();
            return;
        }
        //获取信息
        get_VisitorInfo(mVisitInfoEntity);
        DBTask task = new DBTask();
        task.start_AddVisitInfoAsync(mVisitInfoEntity, new DBTask.onDBAddResultListener() {
            @Override
            public void onAddResult(boolean result) {
                if (result) {
                    Toast.makeText(mContext, "登记保存成功", Toast.LENGTH_SHORT).show();
                    //update result show
                    mVisitInList.add(0, new VisitInInfoItem(mVisitInfoEntity.getVisitor_name(),
                            mEdtInterviewee.getText().toString(), mVisitInfoEntity.getBook_phone(),
                            DateUtil.getDateTimeFormat(mVisitInfoEntity.getIn_time())));
                    mVisitInAdapter.notifyItemInserted(0);

                } else {
                    Toast.makeText(mContext, "登记保存失败", Toast.LENGTH_SHORT).show();
                }
                //clear
                ui_ClearData();

            }

        });


    }

    private void ui_ClearVisitEvent() {
        mEdtVisitCount.setText("");
        mEdtBePhone.setText("");
        mEdtInterviewee.setText("");
        mEdtBePhone.setText("");
        mBtnStartCheckIn.setText("開始登記");
        mIsStartCheckIn = false;
        ui_Enable();
        //clear data
        mEventEntity.setId(null);
        mEventEntity.setDeparmentId(null);
        mEventEntity.setVisitorCount(null);
        mEventEntity.setInsetTime(null);
    }

    private void ui_ClearData() {
        //clear show
        mEdtIdCode.setText("");
        mEdtName.setText("");
        mEdtVisitPhone.setText("");
        mEdtUnit.setText("");
        mEdtGoods.setText("");
        mIvCar.updateNumber("");
        mImgHead.setImageBitmap(null);
        //clear img
        mVisitInfoEntity.setImg_cert("");
        mVisitInfoEntity.setImg_goods("");
        mVisitInfoEntity.setImg_portrait("");
        mVisitInfoEntity.setImg_head("");
        mEventEntity.setVisitorCount(mEventEntity.getVisitorCount() - 1);
        if (0 == mEventEntity.getVisitorCount()) {
            //clear visitinfo list
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mVisitInList.clear();
                    mVisitInAdapter.notifyDataSetChanged();
                    ui_ClearVisitEvent();
                }
            }, 2000);

        }

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
        //check name
        if (StringUtil.isEmptyTrimed(strName)) {
            return false;
        }
        //check idnum
        if (StringUtil.isEmptyTrimed(strIdNum)) {
            return false;
        }
        //check phone
        if (StringUtil.isEmptyTrimed(strPhone)) {
            return false;
        }

        if (!mIsStartCheckIn) {
            return false;
        }
        return true;
    }

    private void get_VisitorInfo(VisitInfoEntity visitEntity) {

        //clear id
        visitEntity.setId(null);
        //來訪事件
        visitEntity.setVisit_event_id(mEventEntity.getId());
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
        if (null != mEdtGoods.getText()) {
            visitEntity.setGoods(mEdtGoods.getText().toString());
        }
        //车牌
        visitEntity.setCar_plate(mIvCar.getNumber());

        //来访时间
        visitEntity.setIn_time(new Date());

    }

}