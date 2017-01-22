package com.edu.zscdm.broadcastdemo2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    private IntentFilter intentFilter;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.edu.zscdm.broadcastdemo2.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    @Override
    public void onClick(View v) {
        //Intent intent = new Intent("com.edu.zscdm.broadcastreceiver.MY_BROADCAST");
        //sendOrderedBroadcast(intent, null);//发送有序广播

        Intent intent = new Intent("com.edu.zscdm.broadcastdemo2.LOCAL_BROADCAST");
        localBroadcastManager.sendBroadcast(intent);//发送广播

    }

    /**
     * 本地广播接收器
     */
    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "recevied localbroadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
