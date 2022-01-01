package com.su.navygayion15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class tabActivity extends AppCompatActivity implements View.OnClickListener {

    int i = 10; // input no of row
    String[] details = new String[5];
    public static final int NAME = 0;
    public static final int BRANCH = 1;
    public static final int EMAIL = 2;
    public static final int REGISTRATION = 3;
    public static final int ADMISSION = 4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);  // set here your layout xml name
        details[NAME] = "Name";
        details[BRANCH] = "Branch";
        details[EMAIL] = "Email";
        details[REGISTRATION] = "Registration No.";
        details[ADMISSION] = "Admission No. ";
//        TableLayout tl = new TableLayout(MainScreen.this);
        TableLayout tl = findViewById(R.id.table);
        for (int k = 0; k < i; k++) {

            TableRow tr = new TableRow(tabActivity.this);
            tr.layout(0, 0, 0, 0);
            TextView ids = new TextView(tabActivity.this);
            ids.setText(details[k]);
            ids.setPadding(30, 15, 30, 15);
            TextView loc = new TextView(tabActivity.this);
            loc.setText(details[k]);
            loc.setPadding(30, 15, 30, 15);
            tr.setPadding(0, 1, 0, 0);
            tr.addView(ids);
            tr.addView(loc);
            tr.setId(k); // here you can set unique id to TableRow for
            // identification
            tr.setOnClickListener(tabActivity.this); // set TableRow onClickListner
            tl.addView(tr, new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

        }

        //setContentView(tl);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        int clicked_id = v.getId(); // here you get id for clicked TableRow

        // now you can get value like this

        String ids = details[clicked_id];
        String loc = details[clicked_id];

    }
}
