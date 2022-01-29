package com.su.periodictable;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class customtext extends ConstraintLayout {

    private final TypedArray attributes;
    private final TextView name;
    private final TextView no;
    private final TextView symbol;
    private OnClickListener listener;


    public customtext(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.custom_text, this);
        attributes = context.obtainStyledAttributes(attrs, R.styleable.customtext);
        name = findViewById(R.id.ct_name);
        no = findViewById(R.id.ct_no);
        symbol = findViewById(R.id.ct_symbol);
        setNo(attributes.getString(R.styleable.customtext_no));
        setName(attributes.getString(R.styleable.customtext_name));
        setSymbol(attributes.getString(R.styleable.customtext_symbol));
        /*init();*/
    }

    private void setSymbol(String string) {
        symbol.setText(string);
    }

    private void setName(String string) {
        name.setText(string);
    }

    public TextView getNo() {
        return no;
    }

    private void setNo(String string) {
        no.setText(string);
    }

    private void init() {
        name.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Clicked on Button:- oopopop ", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
