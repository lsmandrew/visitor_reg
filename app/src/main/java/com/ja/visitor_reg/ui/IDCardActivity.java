package com.ja.visitor_reg.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.common.base.BaseActivity;
import com.parkingwang.keyboard.PopupKeyboard;
import com.parkingwang.keyboard.view.InputView;

public class IDCardActivity extends BaseActivity implements  View.OnClickListener{

    private InputView mInputView;
    private PopupKeyboard mPopupKeyboard;
    private Button mBtnSave;
    private Button mBtnCancel;
    private Button mBtnTake;
    LinearLayout mRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idcard);
//        View view = View.inflate(this, R.layout.activity_idcard, null);
//        view.setOnClickListener(this);
//        setContentView(view);

        //find
        findbyall();
        //listen
        mBtnSave.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
        mBtnTake.setOnClickListener(this);
        mRootLayout.setOnClickListener(this);
        // 创建弹出键盘
        mPopupKeyboard = new PopupKeyboard(this);
        // 弹出键盘内部包含一个KeyboardView，在此绑定输入两者关联。
        mPopupKeyboard.attach(mInputView, this);


    }

    private void findbyall(){
        //find
        mInputView = findViewById(R.id.car_keyboard_id);
        mBtnSave = findViewById(R.id.btn_save_id);
        mBtnCancel = findViewById(R.id.btn_cancel_id);
        mBtnTake = findViewById(R.id.btn_take_id);
        mRootLayout = findViewById(R.id.idcard_layout_id);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.car_keyboard_id:
                Log.d("IDCardActivity", "onClick: ");
                break;
            case R.id.btn_cancel_id:
                Log.d("IDCardActivity", "cancel onClick: ");
                break;
            case R.id.btn_save_id:
                Log.d("IDCardActivity", "save onClick: ");
                break;
            case R.id.btn_take_id:
                Log.d("IDCardActivity", "take onClick: ");
                break;
            default:
                Log.d("IDCardActivity", "Other onClick: ");
                mPopupKeyboard.dismiss(this);
                break;
        }
    }


}
