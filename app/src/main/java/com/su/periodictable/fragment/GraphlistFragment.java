package com.su.periodictable.fragment;

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

import com.su.periodictable.Elements;
import com.su.periodictable.GraphActivity;
import com.su.periodictable.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GraphlistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GraphlistFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String[] grp = {"Group 1",
            "Group 2",
            "Group 3",
            "Group 4",
            "Group 5",
            "Group 6",
            "Group 7",
            "Group 8",
            "Group 9",
            "Group 10",
            "Group 11",
            "Group 12",
            "Group 13",
            "Group 14",
            "Group 15",
            "Group 16",
            "Group 17",
            "Group 18"};
    String[] prd = {"Period 1",
            "Period 2",
            "Period 3",
            "Period 4",
            "Period 5",
            "Period 6",
            "Lanthanoid Series"};
    TextView graphlisthead;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GraphlistFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GraphlistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GraphlistFragment newInstance(String param1, String param2) {
        GraphlistFragment fragment = new GraphlistFragment();
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
        View view = inflater.inflate(R.layout.fragment_graphlist, container, false);
        graphlisthead = view.findViewById(R.id.graphlisthead);
        TableLayout tl = (TableLayout) view.findViewById(R.id.table_n1);
        if (Elements.trendy == 1) {
            graphlisthead.setText("Group wise Trends");
            for (int i = 0; i < grp.length; i++) {
                // Make TR
                TableRow tr = new TableRow(getActivity());
                tr.setId(2142 + i);
                tr.setOnClickListener(this);
                //tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
                Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                        "fonts/merri.ttf");
                // Make TV to hold the details
                TextView tv = new TextView(getActivity());
                tv.setText(grp[i]);
                tv.setTextColor(Color.BLACK);
                tv.setPadding(10, 10, 10, 10);
                tv.setTextSize(18);
                tv.setTypeface(face);
                tr.addView(tv);

                // Make TV to hold the detailvals

                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            }
        } else if (Elements.trendy == 2) {
            graphlisthead.setText("Period wise Trends");
            for (int i = 0; i < prd.length; i++) {
                // Make TR
                TableRow tr = new TableRow(getActivity());
                tr.setId(2142 + i);
                tr.setOnClickListener(this);
                //tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
                Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                        "fonts/merri.ttf");
                // Make TV to hold the details
                TextView tv = new TextView(getActivity());
                tv.setText(prd[i]);
                tv.setTextColor(Color.BLACK);
                tv.setPadding(10, 10, 10, 10);
                tv.setTextSize(18);
                tv.setGravity(Gravity.CENTER);
                tv.setTypeface(face);
                tr.addView(tv);

                // Make TV to hold the detailvals

                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            }
        }

        return view;
    }

    @Override
    public void onClick(View view) {
        int goo = view.getId();
        int got = goo - 2142;
        Elements.trendz = got;
        Toast.makeText(getActivity(), "Clicked on Button:- " + goo + " Atm no " + Elements.trendz, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), GraphActivity.class);
        startActivity(intent);
    }
}