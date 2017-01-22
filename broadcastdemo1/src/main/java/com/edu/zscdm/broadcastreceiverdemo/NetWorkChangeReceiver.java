package com.edu.zscdm.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by ZSCDM on 2017/1/22.
 * 作者邮箱：2712220318@qq.com
 */

public class NetWorkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "network change!", Toast.LENGTH_SHORT).show();
    }
}
