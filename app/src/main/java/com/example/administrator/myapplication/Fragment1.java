package com.example.administrator.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Fragment1 extends Fragment {
    private  View mView;
    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private  int oldPosition=0;


    //存放图片的ID
    private int[] imageIds = new int[]{
            R.drawable.lunbo1,R.drawable.lunbo2,R.drawable.lunbo3,
            R.drawable.lunbo4,R.drawable.lunbo5,
    };

    //存放图片的标题
    private String[] titles = new String[]{
            "拜仁4：0客胜汉诺威，基米系传射",
            "尤文客场1:0都灵豪取七连胜",
            "瓦拉内皇马250次出场",
            "皇马1:0巴列卡诺积分暂列第三",
            "C罗同城战已进27球",
    };

    private TextView title;
    private ViewPagerAdapter  adapter;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment1, container, false);
        setmView();
        return mView;
    }

    private void setmView(){
        mViewPaper = (ViewPager)mView.findViewById( R.id.vpager );

        //显示图片
        images = new ArrayList<>(  );
        for (int i=0;i<imageIds.length;i++){
            ImageView imageView = new ImageView( getActivity() );
            imageView.setBackgroundResource( imageIds[i] );
            images.add( imageView );
        }

        //显示小白点
        dots = new ArrayList<>(  );
        dots.add( mView.findViewById( R.id.dot_0 ) );
        dots.add( mView.findViewById( R.id.dot_1 ) );
        dots.add( mView.findViewById( R.id.dot_2 ) );
        dots.add( mView.findViewById( R.id.dot_3 ) );
        dots.add( mView.findViewById( R.id.dot_4 ) );

        title  = (TextView)mView.findViewById( R.id.title );
        title.setText( titles[0] );

        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter( adapter );




        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                title.setText( titles[position] );
                dots.get( position ).setBackgroundResource( R.mipmap.ic_launcher );
                dots.get( position ).setBackgroundResource( R.mipmap.ic_launcher );

                oldPosition = position;
                currentItem = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /*定义适配器*/
    public class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount(){
            return  images.size();
        }

        @Override
        public  boolean isViewFromObject(View arg0,Object arg1){
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view,int position,Object object){
            view.removeView( images.get( position ) );
        }

        @Override
        public  Object instantiateItem(ViewGroup view ,int position){
            view.addView( images.get( position ) );
            return images.get( position );
        }
    }

    //利用线性池执行动画轮播

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }


    //图片轮播任务
    private class ViewPageTask implements Runnable {
        @Override
        public void run() {
            currentItem = (currentItem+1)%imageIds.length;
            mHandler.sendEmptyMessage(0);

        }
    }

    //接受子线程传递过来的数据

    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg){
            mViewPaper.setCurrentItem( currentItem );
        }

    };

    @Override
    public  void onStop(){
        super.onStop();
        if(scheduledExecutorService != null){
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }

    }

}


