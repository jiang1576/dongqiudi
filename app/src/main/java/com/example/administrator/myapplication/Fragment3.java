package com.example.administrator.myapplication;

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


public class Fragment3 extends Fragment {
    private int whirt = 0xFFFFFFFF;
    private int nocolour = 0xFFFFFF;
    private int textcolour = 0xFF2C2C2C;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3, container, false);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final FrameLayout mlayout1 = (FrameLayout) getActivity().findViewById(R.id.sel5);
        final FrameLayout mlayout2 = (FrameLayout) getActivity().findViewById(R.id.sel6);
        final TextView text1 = (TextView) getActivity().findViewById(R.id.textVie4);
        final TextView text2 = (TextView) getActivity().findViewById(R.id.textVie5);
        final TextView text3 = (TextView) getActivity().findViewById(R.id.textView16);
        final LinearLayout loca1=(LinearLayout)getActivity().findViewById(R.id.loca1);
        final LinearLayout loca2=(LinearLayout)getActivity().findViewById(R.id.loca2);
        final LinearLayout loca3=(LinearLayout)getActivity().findViewById(R.id.loca3);
        final LinearLayout loca4=(LinearLayout)getActivity().findViewById(R.id.loca4);
        final LinearLayout loca5=(LinearLayout)getActivity().findViewById(R.id.loca5);
        loca1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LinearLayout imag1=(LinearLayout)getActivity().findViewById(R.id.imag1);
                final LinearLayout imag2=(LinearLayout)getActivity().findViewById(R.id.imag2);
                final LinearLayout imag3=(LinearLayout)getActivity().findViewById(R.id.imag3);
                imag1.setBackground(getResources().getDrawable(R.drawable.ic_action_name));
                imag2.setBackground(getResources().getDrawable(R.drawable.ic_action_name));
                imag3.setBackground(getResources().getDrawable(R.drawable.ic_action_name));
                text3.setText("前锋");
            }
        });
        loca2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text3.setText("前腰");
            }
        });
        loca3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text3.setText("中场");
            }
        });
        loca4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text3.setText("后卫");
            }
        });
        loca5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text3.setText("门将");
            }
        });

        mlayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlayout1.setBackgroundColor(whirt);
                mlayout2.setBackgroundColor(nocolour);
                text1.setTextColor(textcolour);
                text2.setTextColor(whirt);


            }
        });
        mlayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mlayout1.setBackgroundColor(nocolour);
                mlayout2.setBackgroundColor(whirt);
                text1.setTextColor(whirt);
                text2.setTextColor(textcolour);


            }
        });
    }
}
