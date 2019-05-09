package com.stone.demoview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TimePicker;

import com.stone.demoview.R;


/**
 * author : stoneWang
 * date   : 2019/5/916:41
 */
public class TimeView extends RelativeLayout {
    private static final String TAG = "TimeView";

    private TimePicker startTimePicker, endTimePicker;

    public TimeView(Context context) {
        super(context);
    }

    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.time_layout,this,true);
        startTimePicker = findViewById(R.id.start_tp);
        endTimePicker = findViewById(R.id.end_tp);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TimeView);
        //设置背景
        if (typedArray != null){
            //背景设置
            int timeViewBackGround = typedArray.getColor(R.styleable.TimeView_timeView_background_color, Color.GRAY);
            setBackgroundColor(timeViewBackGround);

            typedArray.recycle();
        }

        initEndViewListener();
    }

    public TimeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initEndViewListener(){
        this.setStartTimeOnClickListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Log.e(TAG, "hourOfDay=" + hourOfDay + " minute=" + minute);
                if (getTimeDiff() == -1)
                    setMinEndTime();
            }
        });

        this.setEndTimeOnClickListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Log.e(TAG, "hourOfDay=" + hourOfDay + " minute=" + minute);
                if (getTimeDiff() == -1)
                    setMinEndTime();
            }
        });
    }

    public void setMinEndTime(){
        int startHourOfDay = startTimePicker.getHour();
        int startMinOfDay = startTimePicker.getMinute();
        endTimePicker.setHour(startHourOfDay);
        endTimePicker.setMinute(startMinOfDay);
    }


    /**
     * 开始时间 change监听
     * @param onTimeChangedListener
     */
    public void setStartTimeOnClickListener(TimePicker.OnTimeChangedListener onTimeChangedListener){
        if (onTimeChangedListener != null){
            startTimePicker.setOnTimeChangedListener(onTimeChangedListener);
        }
    }

    /**
     * 结束时间 change监听
     * @param onTimeChangedListener
     */
    public void setEndTimeOnClickListener(TimePicker.OnTimeChangedListener onTimeChangedListener){
        if (onTimeChangedListener != null){
            endTimePicker.setOnTimeChangedListener(onTimeChangedListener);
        }
    }



    /**
     * 返回时间差
     * @return
     */
    public int getTimeDiff(){
        int startHourOfDay = startTimePicker.getHour();
        int startMinOfDay = startTimePicker.getMinute();
        int endHourOfDay = endTimePicker.getHour();
        int endMinOfDay = endTimePicker.getMinute();
        int startTime = startHourOfDay * 60 + startMinOfDay;
        int endTime = endHourOfDay * 60 + endMinOfDay;

        if (startTime <= endTime)
            return endTime - startTime;
        else
            return -1;
    }

}
