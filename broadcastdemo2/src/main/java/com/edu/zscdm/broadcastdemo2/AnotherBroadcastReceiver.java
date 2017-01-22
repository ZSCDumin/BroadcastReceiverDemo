package com.edu.zscdm.broadcastdemo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnotherBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"recevied in AnotherBroadcastReceiver",Toast.LENGTH_SHORT).show();
        abortBroadcast();//截断广播，优先级比其低的无法收到广播消息
    }
}
