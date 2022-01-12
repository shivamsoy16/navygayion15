package com.su.navygayion15.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.su.navygayion15.Elements;
import com.su.navygayion15.InfoActivity;
import com.su.navygayion15.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TableFragment extends Fragment implements View.OnClickListener {
    String yourTextValue = "text";
    int numvals = 5;
    public static final int NAME = 0;
    public static final int BRANCH = 1;
    public static final int EMAIL = 2;
    public static final int REGISTRATION = 3;
    public static final int ADMISSION = 4;

    String[] details = new String[5];
    String[] detailVals = new String[5]; // Get the values from JSON here
/*    public void otab1(View v)
    {   Button bt1 = v.findViewById(R.id.butt_1);
        bt1.setOnClickListener(this);
        Button bt2 = v.findViewById(R.id.butt_2);
        bt2.setOnClickListener(this);
        Button bt3 = v.findViewById(R.id.butt_3);
        bt3.setOnClickListener(this);
        Button bt4 = v.findViewById(R.id.butt_4);
        bt4.setOnClickListener(this);
        Button bt5 = v.findViewById(R.id.butt_5);
        bt5.setOnClickListener(this);
        Button bt6 = v.findViewById(R.id.butt_6);
        bt6.setOnClickListener(this);
        Button bt7 = v.findViewById(R.id.butt_7);
        bt7.setOnClickListener(this);
        Button bt8 = v.findViewById(R.id.butt_8);
        bt8.setOnClickListener(this);
        Button bt9 = v.findViewById(R.id.butt_9);
        bt9.setOnClickListener(this);
        Button bt10 = v.findViewById(R.id.butt_10);
        bt10.setOnClickListener(this);
        Button bt11 = v.findViewById(R.id.butt_11);
        bt11.setOnClickListener(this);
        Button bt12 = v.findViewById(R.id.butt_12);
        bt12.setOnClickListener(this);
        Button bt13 = v.findViewById(R.id.butt_13);
        bt13.setOnClickListener(this);
        Button bt14 = v.findViewById(R.id.butt_14);
        bt14.setOnClickListener(this);
        Button bt15 = v.findViewById(R.id.butt_15);
        bt15.setOnClickListener(this);
        Button bt16 = v.findViewById(R.id.butt_16);
        bt16.setOnClickListener(this);
        Button bt17 = v.findViewById(R.id.butt_17);
        bt17.setOnClickListener(this);
        Button bt18 = v.findViewById(R.id.butt_18);
        bt18.setOnClickListener(this);
        Button bt19 = v.findViewById(R.id.butt_19);
        bt19.setOnClickListener(this);
        Button bt20 = v.findViewById(R.id.butt_20);
        bt20.setOnClickListener(this);
    }*/



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TableFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TableFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TableFragment newInstance(String param1, String param2) {
        TableFragment fragment = new TableFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
//            TextView myTextView = getActivity().findViewById(R.id.textView1);
//            myTextView.setText(yourTextValue);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table, container, false);
        /*otab1(view);*/
       return view;


    }

    @Override
    public void onClick(View view) {

        int goo1 = view.getId();
        Resources res1 = view.getResources();
        String idString = res1.getResourceEntryName(goo1);
        String[] part1 = idString.split("(?<=\\D)(?=\\d)");
        Elements.cos = Integer.parseInt(part1[1]);
        int igg1 = (int) Elements.cos;
        String[][] ele = Elements.getSubjects();
        if (igg1<=16)
            Toast.makeText(getActivity(), "Clicked on Button:- "+goo1+"  or  "+
                    idString+" "+part1[0]+" and "+igg1+" "+ele[igg1-1][2], Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        startActivity(intent);


    }
}