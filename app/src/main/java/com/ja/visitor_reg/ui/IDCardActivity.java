package com.ja.visitor_reg.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ja.visitor_reg.R;
import com.ja.visitor_reg.common.base.BaseActivity;
import com.parkingwang.keyboard.PopupKeyboard;
import com.parkingwang.keyboard.view.InputView;

public class IDCardActivity extends BaseActivity implements View.OnClickListener {

    InputView mInputView;
    private PopupKeyboard mPopupKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idcard);
        //find
        mInputView = findViewById(R.id.car_keyboard_id);
        // 创建弹出键盘
        mPopupKeyboard = new PopupKeyboard(this);
        // 弹出键盘内部包含一个KeyboardView，在此绑定输入两者关联。
        mPopupKeyboard.attach(mInputView, this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.car_keyboard_id:
                Log.d("IDCardActivity", "onClick: ");
                break;
        }
    }
}
