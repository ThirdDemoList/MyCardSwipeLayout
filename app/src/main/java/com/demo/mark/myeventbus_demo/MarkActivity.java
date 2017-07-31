package com.demo.mark.myeventbus_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.mark.myeventbus_demo.event.FirstEvent;
import com.demo.mark.myeventbus_demo.event.SecondEvent;
import com.demo.mark.myeventbus_demo.event.ThirdEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class MarkActivity extends AppCompatActivity {
    Button btn;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark);
//        EventBus.getDefault().register(this);
//        EventBus.builder().throwSubscriberException(BuildConfig.DEBUG).installDefaultEventBus();
        if (!EventBus.getDefault().isRegistered(this))
        {
           EventBus.getDefault().register(this);
        }

        btn = (Button) findViewById(R.id.btn_try);
        tv = (TextView)findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });

    }
    @Subscribe//一定要加上这几话。参考地址：http://blog.csdn.net/u013164293/article/details/52854425
    public void onEventMainThread(FirstEvent event) {

        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Subscribe//一定要加上这几话。参考地址：http://blog.csdn.net/u013164293/article/details/52854425
    public void onEventMainThread(SecondEvent event) {

        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Subscribe//一定要加上这几话。参考地址：http://blog.csdn.net/u013164293/article/details/52854425
    public void onEventMainThread(ThirdEvent event) {

        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

}
