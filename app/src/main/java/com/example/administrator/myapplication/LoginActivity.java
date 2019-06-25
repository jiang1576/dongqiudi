package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class LoginActivity extends AppCompatActivity {
    private Button bt_denglu;
    private String username;
    private String passwed;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt_denglu = (Button) this.findViewById(R.id.bt_denglu);
        bt_denglu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, ShouYeActivity.class);
                startActivity(intent);
            }
        });

        EditText editText1 = (EditText) findViewById(R.id.passwd);
        Drawable drawable1 = getResources().getDrawable(R.drawable.mima);
        drawable1.setBounds(0, 0, 60, 60);
        //第一0是距左边距离，第二0是距上边距离，40分别是长宽
        editText1.setCompoundDrawables(drawable1, null, null, null);//只放左边

        EditText editText2 = (EditText) findViewById(R.id.username);
        Drawable drawable2 = getResources().getDrawable(R.drawable.user);
        drawable2.setBounds(0, 0, 60, 50);//第一0是距左边距离，第二0是距上边距离，40分别是长宽
        editText2.setCompoundDrawables(drawable2, null, null, null);//只放左边
    }
}
