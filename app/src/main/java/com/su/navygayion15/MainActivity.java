package com.su.navygayion15;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.su.navygayion15.fragment.ListFragment;
import com.su.navygayion15.fragment.TableFragment;
import com.su.navygayion15.fragment.TrendFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.m_table);

    }
    ListFragment listFragment = new ListFragment();
    TableFragment tableFragment = new TableFragment();
    TrendFragment trendFragment = new TrendFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.m_table:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, tableFragment).commit();
                return true;

            case R.id.m_list:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, listFragment).commit();
                return true;

            case R.id.m_trend:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, trendFragment).commit();
                return true;
        }
        return false;
    }
}