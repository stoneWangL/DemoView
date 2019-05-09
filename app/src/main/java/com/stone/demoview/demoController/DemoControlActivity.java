package com.stone.demoview.demoController;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.stone.demoview.R;

/**
 * author : stoneWang
 * date   : 2019/5/921:34
 */
public class DemoControlActivity extends AppCompatActivity {

    private com.stone.demoview.view.fanControllerView fanControllerView;
    private EditText et1, et2, et3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fan_controller);
        initView();
    }

    private void initView(){
        fanControllerView = findViewById(R.id.fan_control);
        et1 = findViewById(R.id.et_1);
        et2 = findViewById(R.id.et_2);
        et3 = findViewById(R.id.et_3);

    }

    /**
     * 3，自定义主界面
     * @param view
     */
    public void setMainUI(View view){
        String str1 = et1.getText().toString();
        String str2 = et2.getText().toString();
        String str3 = et3.getText().toString();



        try{
            int i2 = Integer.valueOf(str2).intValue();
            fanControllerView.controller2(i2);
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            int i1 = Integer.valueOf(str1).intValue();
            fanControllerView.controller1(i1);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            int i3 = Integer.valueOf(str3).intValue();
            fanControllerView.controller3(i3);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}