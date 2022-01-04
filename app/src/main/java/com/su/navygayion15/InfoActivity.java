package com.su.navygayion15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.su.navygayion15.fragment.ListFragment;

public class InfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        TextView ssid = (TextView) findViewById (R.id.woo);
        TextView ssid2 = (TextView) findViewById (R.id.woo2);
        Intent intent = getIntent();
        int value = intent.getIntExtra("key", 0);
        ListFragment fragment = new ListFragment();
        int igi = (int) Elements.getCos();
        String ig3 = String.valueOf(igi);
        String[][] ele = Elements.getSubjects();
        int val = value;
        ssid.setText(ig3);
        if (igi<=10)
            ssid2.setText(ele[igi-1][1]);
        else
            ssid2.setText("Data not fed");

    }
}