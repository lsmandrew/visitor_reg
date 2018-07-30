package com.ja.visitor_reg.common.auto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ja.visitor_reg.ui.IndexActivity;

/**
 * Auto Run
 * function: 開機自動啓動
 * author: by lsm
 * date: 2018-7-12
 */
public class AutoRun extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Intent intent2 = new Intent(context, IndexActivity.class);
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent2);
        }
    }
}
