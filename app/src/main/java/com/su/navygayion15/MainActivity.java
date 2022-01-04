package com.su.navygayion15;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.su.navygayion15.fragment.ListFragment;
import com.su.navygayion15.fragment.TableFragment;
import com.su.navygayion15.fragment.TrendFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragment1 = new TableFragment();
        androidx.fragment.app.FragmentManager fm1 = getSupportFragmentManager();
        androidx.fragment.app.FragmentTransaction transaction1 = fm1.beginTransaction();
        transaction1.replace(R.id.fragment_container, fragment1);
        transaction1.commit();

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
                        changetitle("Periodic Table");
                        return true;
                    case R.id.m_list:
                        Toast.makeText(MainActivity.this, "List", Toast.LENGTH_SHORT).show();
                        Fragment fragment2 = new ListFragment();
                        androidx.fragment.app.FragmentManager fm2 = getSupportFragmentManager();
                        androidx.fragment.app.FragmentTransaction transaction2 = fm2.beginTransaction();
                        transaction2.replace(R.id.fragment_container, fragment2);
                        transaction2.commit();
                        changetitle("List of Elements");
                        return true;
                    case R.id.m_trend:
                        Toast.makeText(MainActivity.this, "Periodic Trend", Toast.LENGTH_SHORT).show();
                        Fragment fragment3 = new TrendFragment();
                        androidx.fragment.app.FragmentManager fm3 = getSupportFragmentManager();
                        androidx.fragment.app.FragmentTransaction transaction3 = fm3.beginTransaction();
                        transaction3.replace(R.id.fragment_container, fragment3);
                        transaction3.commit();
                        changetitle("Periodic Trend");
                        return true;
                }
                return true;
            }
        });


    }
    public void changetitle( String fm1){
        this.setTitle(fm1);
        }



    }
