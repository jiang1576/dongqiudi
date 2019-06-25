package com.example.administrator.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Fragment2 extends Fragment {

    private int whirt = 0xFFFFFFFF;
    private int nocolour=0xFFFFFF;
    private int textcolour=0xFF2C2C2C;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);





        final FrameLayout mlayout1 = (FrameLayout) getActivity().findViewById(R.id.sel1);
        final FrameLayout mlayout2 = (FrameLayout) getActivity().findViewById(R.id.sel2);
        final FrameLayout mlayout3 = (FrameLayout) getActivity().findViewById(R.id.sel3);
        final FrameLayout mlayout4 = (FrameLayout) getActivity().findViewById(R.id.sel4);
        final TextView text1=(TextView)getActivity().findViewById(R.id.textView4) ;
        final TextView text2=(TextView)getActivity().findViewById(R.id.textView5) ;
        final TextView text3=(TextView)getActivity().findViewById(R.id.textView8) ;
        final TextView text4=(TextView)getActivity().findViewById(R.id.textView9) ;
        final  LinearLayout changdi=(LinearLayout)getActivity().findViewById(R.id.changdi);
        changdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), changdiActivity.class);
                startActivity(intent);
            }
        });
        mlayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlayout1.setBackgroundColor(whirt);
                mlayout2.setBackgroundColor(nocolour);
                mlayout3.setBackgroundColor(nocolour);
                mlayout4.setBackgroundColor(nocolour);
                text1.setTextColor(textcolour);
                text2.setTextColor(whirt);
                text3.setTextColor(whirt);
                text4.setTextColor(whirt);


            }
        });
        mlayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlayout1.setBackgroundColor(nocolour);
                mlayout2.setBackgroundColor(whirt);
                mlayout3.setBackgroundColor(nocolour);
                mlayout4.setBackgroundColor(nocolour);
                text1.setTextColor(whirt);
                text2.setTextColor(textcolour);
                text3.setTextColor(whirt);
                text4.setTextColor(whirt);


            }
        });
        mlayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlayout1.setBackgroundColor(nocolour);
                mlayout2.setBackgroundColor(nocolour);
                mlayout3.setBackgroundColor(whirt);
                mlayout4.setBackgroundColor(nocolour);
                text1.setTextColor(whirt);
                text2.setTextColor(whirt);
                text3.setTextColor(textcolour);
                text4.setTextColor(whirt);


            }
        });
        mlayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlayout1.setBackgroundColor(nocolour);
                mlayout2.setBackgroundColor(nocolour);
                mlayout3.setBackgroundColor(nocolour);
                mlayout4.setBackgroundColor(whirt);
                text1.setTextColor(whirt);
                text2.setTextColor(whirt);
                text3.setTextColor(whirt);
                text4.setTextColor(textcolour);


            }
        });

    }



}