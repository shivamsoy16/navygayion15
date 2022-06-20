package com.su.periodictable;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        String str = "#ffffff" ;
        ImageView bar_logo = findViewById(R.id.bar_logo);
        TextView bar_tittle = findViewById(R.id.bar_tittle);
        ImageView bar_search = findViewById(R.id.search_bar);
        ImageView bar_setting = findViewById(R.id.setting_bar);
        ImageView wiki = findViewById(R.id.wiki);
        String[] urls = Elements.getUrls();
        int igi = 0;
        igi = (int) Elements.getCos();


        int finalIgi = igi - 1;
        wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(urls[finalIgi]); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        bar_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InfoActivity.this, "Click Search Icon.", Toast.LENGTH_SHORT).show();
            }
        });
        bar_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InfoActivity.this, "Click Setting Icon.", Toast.LENGTH_SHORT).show();
            }
        });
        bar_tittle.setText("Elements' Info");

        String ig3 = String.valueOf(igi);
        TextView ssid0 = findViewById(R.id.textView);
        TextView ssid1 = (TextView) findViewById(R.id.number);
        TextView ssid2 = (TextView) findViewById(R.id.symbol);
        TextView ssid3 = (TextView) findViewById(R.id.name);
        TextView ssid4 = (TextView) findViewById(R.id.mass);
        TextView ssid5 = (TextView) findViewById(R.id.valence);
        TextView ssid6 = (TextView) findViewById(R.id.radius);
        TextView ssid7 = (TextView) findViewById(R.id.ionization);
        TextView ssid8 = (TextView) findViewById(R.id.electronegativity);
        TextView ssid9 = (TextView) findViewById(R.id.electroaffinity);
        TextView ssid10 = (TextView) findViewById(R.id.discovered);
        TextView ssid11 = (TextView) findViewById(R.id.heat);
        TextView ssid12 = (TextView) findViewById(R.id.state);
        TextView ssid13 = (TextView) findViewById(R.id.density);
        TextView ssid14 = (TextView) findViewById(R.id.melting);
        TextView ssid15 = (TextView) findViewById(R.id.boiling);
        TextView ssid16 = (TextView) findViewById(R.id.conductivity);
        TextView ssid17 = (TextView) findViewById(R.id.hardness);
        TextView ssid18 = (TextView) findViewById(R.id.modulus);
        TextView ssid19 = (TextView) findViewById(R.id.electron);
        TextView ssid20 = (TextView) findViewById(R.id.proton);
        TextView ssid21 = (TextView) findViewById(R.id.neutron);
        TextView ssid22 = (TextView) findViewById(R.id.config);




        int value = igi - 1;
        /*ssid.setText(ig3);
        ssid2.setText(ele[value][1]);*/
        ssid0.setText(Elements.subjects[value][2]);
        ssid1.setText(ig3);
        ssid2.setText(Elements.subjects[value][1]);
        ssid3.setText(Elements.subjects[value][2]);
        ssid4.setText(Elements.subjects[value][3]);
        ssid5.setText(Elements.subjects[value][4]);
        ssid6.setText(Elements.subjects[value][5]);
        ssid7.setText(Elements.subjects[value][6]);
        ssid8.setText(Elements.subjects[value][7]);
        ssid9.setText(Elements.subjects[value][8]);
        ssid10.setText(Elements.subjects[value][9]);
        ssid11.setText(Elements.subjects[value][10]);
        ssid12.setText(Elements.subjects[value][11]);
        ssid13.setText(Elements.subjects[value][12]);
        ssid14.setText(Elements.subjects[value][13]);
        ssid15.setText(Elements.subjects[value][14]);
        ssid16.setText(Elements.subjects[value][15]);
        ssid17.setText(Elements.subjects[value][16]);
        ssid18.setText(Elements.subjects[value][17]);
        ssid19.setText(Elements.config[value][0]);
        ssid20.setText(Elements.config[value][1]);
        ssid21.setText(Elements.config[value][2]);
        ssid22.setText(Elements.config[value][3]);

    }
}