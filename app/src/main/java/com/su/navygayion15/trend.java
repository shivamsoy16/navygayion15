package com.su.navygayion15;

import static android.view.View.inflate;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.su.navygayion15.fragment.GraphlistFragment;
import com.su.navygayion15.fragment.TableFragment;

public class trend extends FrameLayout {

    private final TypedArray attributes;
    private final TextView trendtext;
    private final Button trendgrp;
    private final Button trendprd;
    public String ttext;
    public int tx;

    public trend(@NonNull Context context, @Nullable AttributeSet attrs) {
                super(context, attrs);
        inflate(context, R.layout.trend,this);

        attributes  = context.obtainStyledAttributes(attrs, R.styleable.trendattrs);
        trendtext = findViewById(R.id.trendtext);
        trendgrp = findViewById(R.id.trendgrp);
        trendprd = findViewById(R.id.trendprd);
        setTrendtext(attributes.getString(R.styleable.trendattrs_trendtext));
        setTrendgrp(attributes.getString(R.styleable.trendattrs_trendgrp));
        setTrendprd(attributes.getString(R.styleable.trendattrs_trendprd));
        ttext = attributes.getString(R.styleable.trendattrs_trendtext);
        tx = attributes.getInt(R.styleable.trendattrs_tx,0);
        Elements.trendx = tx;
        init();
    }

    private void setTrendtext(String string) {
        trendtext.setText(string);
    }

    private void setTrendgrp(String string) {
        trendgrp.setText(string);
    }

    private void setTrendprd(String string) {
        trendprd.setText(string);
    }


    private void init() {
        trendgrp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Elements.trendy = 1;
                GraphlistFragment nextFrag= new GraphlistFragment();
                FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;

                fragmentManager = ((AppCompatActivity) getContext()).getSupportFragmentManager();
                fragmentTransaction =   fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragment_container, nextFrag).addToBackStack(null);
                fragmentTransaction.commit();
                Toast.makeText(getContext(), "Clicked on Button:- trendgrp of "+ttext+"and no:"+Elements.trendx+" and "+Elements.trendy, Toast.LENGTH_SHORT).show();
            }
        });
        trendprd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Elements.trendy = 2;
                GraphlistFragment nextFrag= new GraphlistFragment();
                FragmentManager fragmentManager;
                FragmentTransaction fragmentTransaction;

                fragmentManager = ((AppCompatActivity) getContext()).getSupportFragmentManager();
                fragmentTransaction =   fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragment_container, nextFrag).addToBackStack(null);
                fragmentTransaction.commit();
                Toast.makeText(getContext(), "Clicked on Button:- trendprd  of  "+ttext+"and no:"+Elements.trendx+" and "+Elements.trendy, Toast.LENGTH_SHORT).show();
            }
        });

    }




}


