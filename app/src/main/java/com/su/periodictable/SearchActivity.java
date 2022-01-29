package com.su.periodictable;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    public static String[] name;
    public String[] symbol;
    public String[] no;
    ListView listView;
    Listviewadapter adapter;
    ArrayList<Model> arrayList = new ArrayList<Model>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        name = new String[118];
        no = new String[118];
        symbol = new String[118];

        for (int i = 0; i < 118; i++) {
            no[i] = Elements.subjects[i][0];
            name[i] = Elements.subjects[i][2];
            symbol[i] = Elements.subjects[i][1];
        }

        listView = findViewById(R.id.search_element);

        for (int i = 0; i < name.length; i++) {

            Model model = new Model(no[i], symbol[i], name[i]);
            //bind all strings in o=ne array
            arrayList.add(model);

        }

        //pass results to listviewadapter class
        adapter = new Listviewadapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchview = (SearchView) myActionMenuItem.getActionView();
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)) {
                    adapter.filter("");
                    listView.clearTextFilter();
                } else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}