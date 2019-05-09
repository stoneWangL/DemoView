package com.stone.demoview.demoTime;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.stone.demoview.R;
import com.stone.demoview.view.TimeView;


/**
 * author : stoneWang
 * date   : 2019/5/916:39
 */
public class DemoTimeActivity extends AppCompatActivity {
    private static final String TAG = "DemoTimeActivity";

    private TimeView timeView;
    private TextView tvTimeDiff;

    private static final int SEND_UPDATA_TEXT=0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        initView();
    }

    private void initView(){
        timeView = findViewById(R.id.time_view);
        tvTimeDiff = findViewById(R.id.tv_time_diff);
    }

    public void getTimeDiff(View view){
        Message message = new Message();
        message.what = SEND_UPDATA_TEXT;
        handler.sendMessage(message);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case SEND_UPDATA_TEXT:
                    int hour = timeView.getTimeDiff() / 60;
                    int min = timeView.getTimeDiff() % 60;
                    tvTimeDiff.setText("" + hour + "小时" + min + "分钟");
                    break;
                default:
                    break;
            }
        }
    };
}

