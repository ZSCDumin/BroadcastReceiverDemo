package com.edu.zscdm.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private IntentFilter intentFilter;
    private NetWorkChangeReceiver netWorkChangeReceiver;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

        /****************动态方式注册**************/
        intentFilter = new IntentFilter();//intent过滤器
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");//添加action
        netWorkChangeReceiver = new NetWorkChangeReceiver();//广播接收器
        registerReceiver(netWorkChangeReceiver, intentFilter);//注册广播接收器
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netWorkChangeReceiver);//取消注册广播接收器
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent("com.edu.zscdm.broadcastreceiver.MY_BROADCAST");
        sendBroadcast(intent);//发送广播
    }

    class NetWorkChangeReceiver extends BroadcastReceiver {

        /**
         * 当有广播来时，此方法执行
         *
         * @param context
         * @param intent
         */
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);//连接管理器
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();//网络信息
            if (networkInfo != null && networkInfo.isAvailable()) {
                Toast.makeText(context, "当前网络可用！", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(context, "当前网络不可用！", Toast.LENGTH_SHORT).show();
        }
    }
}
