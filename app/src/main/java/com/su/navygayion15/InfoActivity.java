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
        int igi = 0;
        igi = (int) Elements.getCos();
        String ig3 = String.valueOf(igi);
        String[][] ele = Elements.getSubjects();
        TextView ssid = (TextView) findViewById (R.id.number);
        TextView ssid2 = (TextView) findViewById (R.id.symbol);
        TextView ssid3 = (TextView) findViewById (R.id.name);
        TextView ssid4 = (TextView) findViewById (R.id.mass);
        TextView ssid5 = (TextView) findViewById (R.id.valence);
        TextView ssid6 = (TextView) findViewById (R.id.radius);
        TextView ssid7 = (TextView) findViewById (R.id.ionization);
        TextView ssid8 = (TextView) findViewById (R.id.electronegativity);
        TextView ssid9 = (TextView) findViewById (R.id.electroaffinity);
        TextView ssid10 = (TextView) findViewById (R.id.discovered);
        TextView ssid11 = (TextView) findViewById (R.id.heat);
        TextView ssid12 = (TextView) findViewById (R.id.state);
        TextView ssid13 = (TextView) findViewById (R.id.density);
        TextView ssid14 = (TextView) findViewById (R.id.melting);
        TextView ssid15 = (TextView) findViewById (R.id.boiling);
        TextView ssid16 = (TextView) findViewById (R.id.conductivity);
        TextView ssid17 = (TextView) findViewById (R.id.hardness);
        TextView ssid18 = (TextView) findViewById (R.id.modulus);


        int value = igi-1;
        /*ssid.setText(ig3);
        ssid2.setText(ele[value][1]);*/
        if (igi<=16) {
            ssid.setText(ig3);
            ssid2.setText(ele[value][1]);
            ssid3.setText(ele[value][2]);
            ssid4.setText(ele[value][3]);
            ssid5.setText(ele[value][4]);
            ssid6.setText(ele[value][5]);
            ssid7.setText(ele[value][6]);
            ssid8.setText(ele[value][7]);
            ssid9.setText(ele[value][8]);
            ssid10.setText(ele[value][9]);
            ssid11.setText(ele[value][10]);
            ssid12.setText(ele[value][11]);
            ssid13.setText(ele[value][12]);
            ssid14.setText(ele[value][13]);
            ssid15.setText(ele[value][14]);
            ssid16.setText(ele[value][15]);
            ssid17.setText(ele[value][16]);
            ssid18.setText(ele[value][17]);

        }


    }
}