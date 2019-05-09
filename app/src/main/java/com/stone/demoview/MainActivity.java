package com.stone.demoview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.stone.demoview.demoController.DemoControlActivity;
import com.stone.demoview.demoTime.DemoTimeActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    private String[] strings = new String[]{
            "时间控件","风扇控件"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }




    private void initView(){
        listView = findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strings);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showIntent(i);
            }
        });
    }


    private void showIntent(int index){
        switch (index){
            case 0:
                startActivity(new Intent(MainActivity.this, DemoTimeActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, DemoControlActivity.class));
                break;
        }
    }
}
