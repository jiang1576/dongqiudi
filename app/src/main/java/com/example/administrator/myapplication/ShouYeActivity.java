package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity; // 注意这里我们导入的V4的包，不要导成app的包了
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ShouYeActivity extends FragmentActivity implements View.OnClickListener {
    private TextView text_name, text_condition;
    private String name;
    private LinearLayout register;




    // 定义4个Fragment对象
    private Fragment1 fg1;
    private Fragment2 fg2;
    private Fragment3 fg3;
    private Fragment4 fg4;
    // 帧布局对象，用来存放Fragment对象
    // 定义每个选项中的相关控件
    private RelativeLayout firstLayout;
    private RelativeLayout secondLayout;
    private RelativeLayout thirdLayout;
    private RelativeLayout fourthLayout;
    private ImageView firstImage;
    private ImageView secondImage;
    private ImageView thirdImage;
    private ImageView fourthImage;
    private TextView firstText;
    private TextView secondText;
    private TextView thirdText;
    private TextView fourthText;
    // 定义几个颜色
    private int whirt = 0xFFFFFFFF;
    private int gray = 0xFF7597B3;
    private int dark = 0xff000000;
    // 定义FragmentManager对象管理器
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_ye);
        fragmentManager = getSupportFragmentManager();
        initView(); // 初始化界面控件
        setChioceItem(0); // 初始化页面加载时显示第一个选项
        init();
        register = (LinearLayout) this.findViewById(R.id.login11);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ShouYeActivity.this, Login_Activity.class);
                startActivity(intent);
            }
        });
    }



    /**
     * 初始化页面
     */
    private void initView() {
// 初始化页面标题栏

// 初始化底部导航栏的控件
        firstImage = (ImageView) findViewById(R.id.first_image);
        secondImage = (ImageView) findViewById(R.id.second_image);
        thirdImage = (ImageView) findViewById(R.id.third_image);
        fourthImage = (ImageView) findViewById(R.id.fourth_image);
        firstText = (TextView) findViewById(R.id.first_text);
        secondText = (TextView) findViewById(R.id.second_text);
        thirdText = (TextView) findViewById(R.id.third_text);
        fourthText = (TextView) findViewById(R.id.fourth_text);
        firstLayout = (RelativeLayout) findViewById(R.id.first_layout);
        secondLayout = (RelativeLayout) findViewById(R.id.second_layout);
        thirdLayout = (RelativeLayout) findViewById(R.id.third_layout);
        fourthLayout = (RelativeLayout) findViewById(R.id.fourth_layout);
        firstLayout.setOnClickListener(ShouYeActivity.this);
        secondLayout.setOnClickListener(ShouYeActivity.this);
        thirdLayout.setOnClickListener(ShouYeActivity.this);
        fourthLayout.setOnClickListener(ShouYeActivity.this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_layout:
                setChioceItem(0);
                break;
            case R.id.second_layout:
                setChioceItem(1);
                break;
            case R.id.third_layout:
                setChioceItem(2);
                break;
            case R.id.fourth_layout:
                setChioceItem(3);
                break;
            default:
                break;
        }
    }
    /**
     * 设置点击选项卡的事件处理
     *
     * @param index 选项卡的标号：0, 1, 2, 3
     */
    private void setChioceItem(int index) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        clearChioce(); // 清空, 重置选项, 隐藏所有Fragment
        hideFragments(fragmentTransaction);
        switch (index) {
            case 0:
                //firstImage.setImageResource(R.drawable.xxx);
                firstText.setTextColor(dark);
                firstLayout.setBackgroundColor(gray);
// 如果fg1为空，则创建一个并添加到界面上
                if (fg1 == null) {
                    fg1 = new Fragment1();
                    fragmentTransaction.add(R.id.content, fg1);
                } else {
// 如果不为空，则直接将它显示出来
                    fragmentTransaction.show(fg1);
                }
                break;
            case 1:
// secondImage.setImageResource(R.drawable.XXXX);
                secondText.setTextColor(dark);
                secondLayout.setBackgroundColor(gray);
                if (fg2 == null) {
                    fg2 = new Fragment2();
                    fragmentTransaction.add(R.id.content, fg2);
                } else {
                    fragmentTransaction.show(fg2);
                }
                break;
            case 2:
// thirdImage.setImageResource(R.drawable.XXXX);
                thirdText.setTextColor(dark);
                thirdLayout.setBackgroundColor(gray);
                if (fg3 == null) {
                    fg3 = new Fragment3();
                    fragmentTransaction.add(R.id.content, fg3);
                } else {
                    fragmentTransaction.show(fg3);
                }
                break;
            case 3:
// fourthImage.setImageResource(R.drawable.XXXX);
                fourthText.setTextColor(dark);
                fourthLayout.setBackgroundColor(gray);
                if (fg4 == null) {
                    fg4 = new Fragment4();
                    fragmentTransaction.add(R.id.content, fg4);
                } else {
                    fragmentTransaction.show(fg4);
                }
                break;
        }
        fragmentTransaction.commit(); // 提交
    }
    /**
     * 当选中其中一个选项卡时，其他选项卡重置为默认
     */
    private void clearChioce() {
// firstImage.setImageResource(R.drawable.XXX);
        firstText.setTextColor(gray);
        firstLayout.setBackgroundColor(whirt);
// secondImage.setImageResource(R.drawable.XXX);
        secondText.setTextColor(gray);
        secondLayout.setBackgroundColor(whirt);
// thirdImage.setImageResource(R.drawable.XXX);
        thirdText.setTextColor(gray);
        thirdLayout.setBackgroundColor(whirt);
// fourthImage.setImageResource(R.drawable.XXX);
        fourthText.setTextColor(gray);
        fourthLayout.setBackgroundColor(whirt);
    }
    /**
     * 隐藏Fragment
     *
     * @param fragmentTransaction
     */
    private void hideFragments(FragmentTransaction fragmentTransaction) {
        if (fg1 != null) {
            fragmentTransaction.hide(fg1);
        }
        if (fg2 != null) {
            fragmentTransaction.hide(fg2);
        }
        if (fg3 != null) {
            fragmentTransaction.hide(fg3);
        }
        if (fg4 != null) {
            fragmentTransaction.hide(fg4);
        }
    }
    protected void init() {
        Intent intent = getIntent();
        name = intent.getStringExtra("Username");
        text_name = (TextView) findViewById(R.id.text_name);
        text_name.setText(name);
        System.out.printf(text_name.toString());
        if (name==null){
            text_condition = (TextView) findViewById(R.id.text_condition);
            text_condition.setText("未登入");
        }else {
            text_condition = (TextView) findViewById(R.id.text_condition);
            text_condition.setText("在线");
        }

    }

}

