package com.su.navygayion15.fragment;

import static android.view.View.inflate;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.su.navygayion15.Elements;
import com.su.navygayion15.InfoActivity;
import com.su.navygayion15.R;
import com.su.navygayion15.customtext;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrendFragment extends Fragment implements View.OnClickListener {


    public void otab1(View v)
    {
        customtext ct1 = v.findViewById(R.id.cut_1);
        ct1.setOnClickListener(this);
        customtext ct11 = v.findViewById(R.id.cut_11);
        ct11.setOnClickListener(this);
        customtext ct19 = v.findViewById(R.id.cut_19);
        ct19.setOnClickListener(this);
        customtext ct37 = v.findViewById(R.id.cut_37);
        ct37.setOnClickListener(this);
        customtext ct2 = v.findViewById(R.id.cut_3);
        ct2.setOnClickListener(this);


    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public TrendFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TrendFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TrendFragment newInstance(String param1, String param2) {
        TrendFragment fragment = new TrendFragment();
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
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_trend, container, false);
        otab1(view);
        return view;

    }


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