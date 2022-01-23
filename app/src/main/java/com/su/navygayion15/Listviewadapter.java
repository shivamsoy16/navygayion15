package com.su.navygayion15;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Listviewadapter extends BaseAdapter {

    //variables
    Context mcontext;
    LayoutInflater inflater;
    List<Model> modelList;
    ArrayList<Model> arrayList;

    //constructor


    public Listviewadapter(Context context, List<Model> modelList) {
        this.mcontext = context;
        this.modelList = modelList;
        inflater = LayoutInflater.from(mcontext);
        this.arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modelList);
    }

    public class ViewHolder{
        TextView mNoTv, mSymbolTv, mNameTv;
    }

    @Override
    public int getCount() {
        return modelList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_row,null);

            //locate the views in row xml
            holder.mNoTv = view.findViewById(R.id.row_no);
            holder.mNameTv = view.findViewById(R.id.row_name);
            holder.mSymbolTv = view.findViewById(R.id.row_symbol);

            view.setTag(holder);

        }
        else {

            holder = (ViewHolder)view.getTag();

        }

        //set the results in textview
        holder.mNameTv.setText(modelList.get(position).getName());
        holder.mNoTv.setText(modelList.get(position).getNo());
        holder.mSymbolTv.setText(modelList.get(position).getSymbol());


        //list view item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                int index = -1;
                for (int i=0;i<118;i++) {
                    if (modelList.get(position).getName().equals(SearchActivity.name[i])) {
                        index = i;
                        Elements.cos = i+1;
                        Intent intent = new Intent(mcontext, InfoActivity.class);
                        mcontext.startActivity(intent);
                        break;
                    }
                }
               /* if (modelList.get(position).getName().equals("one")){
                    Elements.cos = 11;
                    Intent intent = new Intent(mcontext, InfoActivity.class);
                    mcontext.startActivity(intent);
                }
                if (modelList.get(position).getName().equals("two")){
                    Elements.cos = 12;
                    Intent intent = new Intent(mcontext, InfoActivity.class);
                    mcontext.startActivity(intent);
                }
                if (modelList.get(position).getName().equals("three")){
                    Elements.cos = 13;
                    Intent intent = new Intent(mcontext, InfoActivity.class);
                    mcontext.startActivity(intent);
                }*/


            }
        });


        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modelList.clear();
        if (charText.length()==0) {
            modelList.addAll(arrayList);
        }
        else{
            for (Model model : arrayList){
                if (model.getName().toLowerCase(Locale.getDefault())
                    .contains(charText)){
                    modelList.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}
