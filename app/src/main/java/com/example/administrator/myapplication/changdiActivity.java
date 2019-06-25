package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class changdiActivity extends Activity{


    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private ListView listView;
    private SimpleAdapter adapter;
    private DBUtil dbUtil;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.changdi);

        btn1 = (Button) findViewById(R.id.btn_all);
        btn2 = (Button) findViewById(R.id.btn_add);
        btn3 = (Button) findViewById(R.id.btn_delete);
        btn4 =(Button) findViewById(R.id.btn_update);
        listView = (ListView) findViewById(R.id.listView);
        dbUtil = new DBUtil();

        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                System.out.println(1);
                hideButton(true);
                setListView();
                System.out.println(1);
            }
        });

        btn2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                hideButton(true);
                setAddDialog();
            }
        });

        btn3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                hideButton(true);
                setDeleteDialog();
            }
        });
        btn4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                hideButton(true);
                setUpdateDialog();
            }
        });

    }

    /**
     * 设置弹出删除对话框
     */
    private void setDeleteDialog() {


        final Dialog dialog = new Dialog(changdiActivity.this);
        dialog.setContentView(R.layout.dialog_delete);
        dialog.setTitle("取消预约");
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER);
        dialogWindow.setAttributes(lp);

        final EditText cNoEditText = (EditText) dialog.findViewById(R.id.editText5);
        Button btnConfirm = (Button) dialog.findViewById(R.id.button1);
        Button btnCancel = (Button) dialog.findViewById(R.id.button2);


        btnConfirm.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dbUtil.deleteCargoInfo(cNoEditText.getText().toString());
                dialog.dismiss();
                hideButton(false);
                Toast.makeText(changdiActivity.this, "成功删除数据", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
                hideButton(false);
            }
        });

        dialog.show();
    }


    private void setUpdateDialog() {


        final Dialog dialog = new Dialog(changdiActivity.this);
        dialog.setContentView(R.layout.dialog_update);
        dialog.setTitle("取消预约");
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER);
        dialogWindow.setAttributes(lp);
        final Spinner sp3=(Spinner)dialog.findViewById(R.id.spinner4);
        final Spinner sp4=(Spinner)dialog.findViewById(R.id.spinner5);

        final EditText cNoEditText = (EditText) dialog.findViewById(R.id.editText18);
        Button btnConfirm = (Button) dialog.findViewById(R.id.button1);
        Button btnCancel = (Button) dialog.findViewById(R.id.button2);


        btnConfirm.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String str2 = (String) sp3.getSelectedItem();
                String str3 = (String) sp4.getSelectedItem();
                dbUtil.updateCargoInfo(cNoEditText.getText().toString(),str2,str3);
                dialog.dismiss();
                hideButton(false);
                Toast.makeText(changdiActivity.this, "删除数据", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
                hideButton(false);
            }
        });

        dialog.show();
    }

    /**
     * 设置弹出添加对话框
     */
    private void setAddDialog() {

        final Dialog dialog = new Dialog(changdiActivity.this);
        dialog.setContentView(R.layout.dialog_add);
        dialog.setTitle("场地时间选择");
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER);
        dialogWindow.setAttributes(lp);

        final Spinner sp1=(Spinner)dialog.findViewById(R.id.spinner2);
        final Spinner sp2=(Spinner)dialog.findViewById(R.id.spinner3);


        Button btnConfirm = (Button) dialog.findViewById(R.id.button1);
        Button btnCancel = (Button) dialog.findViewById(R.id.button2);

        Calendar calendar = Calendar.getInstance();
        int min=0;
        int max=99;
        Random random = new Random();
        int num = random.nextInt(max)%(max-min+1) + min;
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int id=year*1000000+month*10000+day*100+num;
        System.out.println(id);
        final String s = String.valueOf(id);
        SharedPreferences sharedata = getSharedPreferences("data", 0);

        final String data = sharedata.getString("item", null);

        btnConfirm.setOnClickListener(new OnClickListener() {





            @Override
            public void onClick(View v) {


                 String str = (String) sp1.getSelectedItem();
                String str1 = (String) sp2.getSelectedItem();
                dbUtil.insertCargoInfo(s,str,str1,data);
                dialog.dismiss();
                hideButton(false);
                Toast.makeText(changdiActivity.this, "用户："+data+",您已预约成功，您获取的订单编号为："+s, Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
                hideButton(false);
            }
        });


        dialog.show();
    }

    /**
     * 设置listView
     */
    private void setListView() {

        listView.setVisibility(View.VISIBLE);

        List<HashMap<String,String>> list=new ArrayList<HashMap<String, String>>();
        System.out.println(5);

//        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        list = dbUtil.getAllInfo();

        adapter = new SimpleAdapter(
                changdiActivity.this,
                list,
                R.layout.adapter_item,
                new String[] { "订单编号", "场地类型", "预约时间","用户名" },
                new int[] { R.id.txt_Cno, R.id.txt_Cname, R.id.txt_Cnum ,R.id.name});

        listView.setAdapter(adapter);

    }

    /**
     * 设置button的可见性
     */
    private void hideButton(boolean result) {
        if (result) {
            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
        } else {
            btn1.setVisibility(View.VISIBLE);
            btn2.setVisibility(View.VISIBLE);
            btn3.setVisibility(View.VISIBLE);
            btn4.setVisibility(View.VISIBLE);
        }

    }

    /**
     * 返回按钮的重写
     */
    @Override
    public void onBackPressed()
    {
        if (listView.getVisibility() == View.VISIBLE) {
            listView.setVisibility(View.GONE);
            hideButton(false);
        }else {
            changdiActivity.this.finish();
        }
    }
}
