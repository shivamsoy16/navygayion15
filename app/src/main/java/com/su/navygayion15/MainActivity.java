package com.su.navygayion15;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.su.navygayion15.fragment.ListFragment;
import com.su.navygayion15.fragment.TableFragment;
import com.su.navygayion15.fragment.TrendFragment;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment1 = new TableFragment();
        androidx.fragment.app.FragmentManager fm1 = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction1 = fm1.beginTransaction();
        transaction1.replace(R.id.fragment_container, fragment1);
        transaction1.commit();
        ImageView bar_logo = findViewById(R.id.bar_logo);
        TextView bar_tittle = findViewById(R.id.bar_tittle);
        ImageView bar_search = findViewById(R.id.search_bar);
        ImageView bar_setting = findViewById(R.id.setting_bar);

        bar_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click Search Icon.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(intent);
            }
        });
        bar_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Click Setting Icon.", Toast.LENGTH_SHORT).show();
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.m_table:
                        Toast.makeText(MainActivity.this, "Periodic Table", Toast.LENGTH_SHORT).show();
                        /*Intent intent = new Intent(MainActivity.this, tabActivity.class);
                        startActivity(intent);*/
                        Fragment fragment1 = new TableFragment();
                        androidx.fragment.app.FragmentManager fm1 = getSupportFragmentManager();
                        androidx.fragment.app.FragmentTransaction transaction1 = fm1.beginTransaction();
                        transaction1.replace(R.id.fragment_container, fragment1);
                        transaction1.commit();
                        bar_tittle.setText("Periodic Table");
                        return true;
                    case R.id.m_list:
                        Toast.makeText(MainActivity.this, "List", Toast.LENGTH_SHORT).show();
                        Fragment fragment2 = new ListFragment();
                        androidx.fragment.app.FragmentManager fm2 = getSupportFragmentManager();
                        androidx.fragment.app.FragmentTransaction transaction2 = fm2.beginTransaction();
                        transaction2.replace(R.id.fragment_container, fragment2);
                        transaction2.commit();
                        bar_tittle.setText("List of Elements");
                        return true;
                    case R.id.m_trend:
                        Toast.makeText(MainActivity.this, "Periodic Trend", Toast.LENGTH_SHORT).show();
                        Fragment fragment3 = new TrendFragment();
                        androidx.fragment.app.FragmentManager fm3 = getSupportFragmentManager();
                        androidx.fragment.app.FragmentTransaction transaction3 = fm3.beginTransaction();
                        transaction3.replace(R.id.fragment_container, fragment3);
                        transaction3.commit();
                        bar_tittle.setText("Periodic Trend");
                        return true;
                }
                return true;
            }
        });


    }


/*    public void changetittle( String fm1) {
        bar_tittle.setText(fm1);
    }*/


/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }*/


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_search){
        }
        else if (item.getItemId() == R.id.nav_settings){
            Toast.makeText(this, "Clicked Settings Icon..", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}
