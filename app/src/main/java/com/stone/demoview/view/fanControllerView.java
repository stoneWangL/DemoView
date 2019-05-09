package com.stone.demoview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.stone.demoview.R;


/**
 * author : stoneWang
 * date   : 2019/5/923:09
 */
public class fanControllerView extends RelativeLayout {
    private static final String TAG = "fanControllerView";

    private LinearLayout firstLinearLayout,secondLinearLayout;
    private ImageView fan1, fan2, fan3, fan4, fan5, fan6, fan7, fan8, fan9;
    private static int fanNum = 0;

    public fanControllerView(Context context) {
        super(context);
    }

    public fanControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.controller_layout,this,true);
        firstLinearLayout = findViewById(R.id.first_ly);
        secondLinearLayout = findViewById(R.id.second_ly);

        fan1 = findViewById(R.id.iv_fan_1);
        fan2 = findViewById(R.id.iv_fan_2);
        fan3 = findViewById(R.id.iv_fan_3);
        fan4 = findViewById(R.id.iv_fan_4);
        fan5 = findViewById(R.id.iv_fan_5);
        fan6 = findViewById(R.id.iv_fan_6);
        fan7 = findViewById(R.id.iv_fan_7);
        fan8 = findViewById(R.id.iv_fan_8);
        fan9 = findViewById(R.id.iv_fan_9);

    }

    public fanControllerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 风扇图标可以根据参数自定义是否转动（1风扇可以转动，0不可以转动）
     * @param num
     */
    public void controller1(int num){
        //动画
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_img_rotate);
        LinearInterpolator lin = new LinearInterpolator();//设置动画匀速运动
        animation.setInterpolator(lin);
        if(num == 0){
            clearAnim();

        }else if(num == 1){

            switch (fanNum){
                case 1:
                    fan1.startAnimation(animation);
                    break;
                case 2:
                    fan2.startAnimation(animation);
                    break;
                case 3:
                    fan3.startAnimation(animation);
                    break;
                case 4:
                    fan4.startAnimation(animation);
                    break;
                case 5:
                    fan5.startAnimation(animation);
                    break;
                case 6:
                    fan6.startAnimation(animation);
                    break;
                case 7:
                    fan7.startAnimation(animation);
                    break;
                case 8:
                    fan8.startAnimation(animation);
                    break;
                case 9:
                    fan9.startAnimation(animation);
                    break;
            }

        }
    }

    private void clearAnim(){
        fan1.clearAnimation();
        fan2.clearAnimation();
        fan3.clearAnimation();
        fan4.clearAnimation();
        fan5.clearAnimation();
        fan6.clearAnimation();
        fan7.clearAnimation();
        fan8.clearAnimation();
        fan9.clearAnimation();
    }

    /**
     * 控件1，档位可以根据参数自定义档位
     * @param num 1-9，输入对应数字，设置成对应档位
     */
    public void controller2(int num){
        clearAnim();
        fanNum = num;
        fan1.setVisibility(INVISIBLE);
        fan2.setVisibility(INVISIBLE);
        fan3.setVisibility(INVISIBLE);
        fan4.setVisibility(INVISIBLE);
        fan5.setVisibility(INVISIBLE);
        fan6.setVisibility(INVISIBLE);
        fan7.setVisibility(INVISIBLE);
        fan8.setVisibility(INVISIBLE);
        fan9.setVisibility(INVISIBLE);

        switch (num){
            case 1:
                fan1.setVisibility(VISIBLE);
                break;
            case 2:
                fan2.setVisibility(VISIBLE);
                break;
            case 3:
                fan3.setVisibility(VISIBLE);
                break;
            case 4:
                fan4.setVisibility(VISIBLE);
                break;
            case 5:
                fan5.setVisibility(VISIBLE);
                break;
            case 6:
                fan6.setVisibility(VISIBLE);
                break;
            case 7:
                fan7.setVisibility(VISIBLE);
                break;
            case 8:
                fan8.setVisibility(VISIBLE);
                break;
            case 9:
                fan9.setVisibility(VISIBLE);
                break;
            default:
                break;
        }
    }

    /**
     * 控件1，控件可以根据参数自定义主界面
     * @param num 1，显示温度和绿色按钮 ；0，显示红色按钮和红色按钮下的文本
     */
    public void controller3(int num){
        switch (num){
            case 0:
                firstLinearLayout.setVisibility(GONE);
                secondLinearLayout.setVisibility(VISIBLE);
                break;
            case 1:
                firstLinearLayout.setVisibility(VISIBLE);
                secondLinearLayout.setVisibility(GONE);
                break;
            default:
                break;
        }
    }
}
