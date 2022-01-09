package com.su.navygayion15.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.su.navygayion15.Elements;
import com.su.navygayion15.InfoActivity;
import com.su.navygayion15.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment implements View.OnClickListener {

    String[][] ele = Elements.getSubjects();
    public int igg = 0;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ListFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
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
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        TableLayout tl = (TableLayout) view.findViewById(R.id.table_n);

        for (int i = 0; i < 108; i++) {
            // Make TR
            TableRow tr = new TableRow(getActivity());
            tr.setId(2456 + i);
            tr.setOnClickListener(this);
            //tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                    "fonts/merri.ttf");
            // Make TV to hold the details
            TextView tv = new TextView(getActivity());
            tv.setText(ele[i][0]);
            tv.setTextColor(Color.BLACK);
            tv.setPadding(10, 5, 10, 5);
            tv.setTextSize(21);
            tv.setGravity(Gravity.CENTER);
            tv.setTypeface(face);
            tr.addView(tv);

            // Make TV to hold the detailvals

            TextView tv1 = new TextView(getActivity());
            tv1.setText(ele[i][1]);
            tv1.setTextColor(Color.BLACK);
            tv1.setPadding(10, 5, 10, 5);
            tv1.setTextSize(21);
            tv1.setGravity(Gravity.CENTER);
            tv1.setTypeface(face);
            tr.addView(tv1);

            TextView tv2 = new TextView(getActivity());
            tv2.setText(ele[i][2]);
            tv2.setTextColor(Color.BLACK);
            tv2.setPadding(10, 5, 10, 5);
            tv2.setTextSize(21);
            tv2.setTypeface(face);
            tr.addView(tv2);

            tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        int goo = view.getId();
        int got = goo - 2456;
        Elements.cos = got + 1;
        Toast.makeText(getActivity(), "Clicked on Button:- " + goo + " Atm no " + got, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        startActivity(intent);

    }

}


