package com.su.navygayion15.fragment;

import android.content.Context;
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
import android.widget.TableRow;
import android.widget.TextView;

import com.su.navygayion15.Elements;
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
public class TableFragment extends Fragment {
    String yourTextValue = "text";
    int numvals = 5;
    public static final int NAME = 0;
    public static final int BRANCH = 1;
    public static final int EMAIL = 2;
    public static final int REGISTRATION = 3;
    public static final int ADMISSION = 4;

    String[] details = new String[5];
    String[] detailVals = new String[5]; // Get the values from JSON here



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

//        TextView titolo = (TextView)view.findViewById(R.id.textView1);
//        titolo.setText(yourTextValue);
        if (container == null)
        {
            return null;
        }

        details[NAME] = "Name";
        details[BRANCH] = "Branch";
        details[EMAIL] = "Email";
        details[REGISTRATION] = "Registration No.";
        details[ADMISSION] = "Admission No. ";

        detailVals[NAME] = "Some Name";
        detailVals[BRANCH] = "Computer Science";
        detailVals[EMAIL] = "some_email@email.com";
        detailVals[REGISTRATION] = "11101212";
        detailVals[ADMISSION] = "1345645";
        String[][] ele = Elements.getSubjects();

        /*TableLayout tl = (TableLayout)view.findViewById(R.id.detailsTable);
        for (int j = 0; j<3; j++)
            for (int i = 0; i < 3; i++)
            {
                TableRow tr = new TableRow(getContext());

                *//*ImageView iv = new ImageView(getContext());
                tr.setClickable(true);
                tr.setOnClickListener(this);
                try {
                    url = new URL(image_url[i]);
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                InputStream content = null;
                try {
                    content = (InputStream)url.getContent();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Drawable d = Drawable.createFromStream(content , "src");
                iv.setImageDrawable(d);*//*

    //            tr.addView(iv,new TableLayout.LayoutParams(150,150));
                TextView tv2 = new TextView(getContext());
                TextView tv3 = new TextView(getContext());

                tv2.setText(ele[j][i]);
                tv3.setText(ele[j][i]);

                tv2.setPadding(10, 0, 0, 0);

                tv3.setPadding(10, 0, 0, 0);
                tr.setPadding(0, 1, 0, 1);

                tr.addView(tv2); // add TextView to row.
                tr.addView(tv3); // add TextView to row.

                tl.addView(tr);
            }
*/
        /*for ( int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                // Make TR
                TableRow tr = new TableRow(getActivity());
                tr.setId(100 + i);
                tr.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));


                // Make TV to hold the details
                TextView detailstv = new TextView(getActivity());
                detailstv.setId(200 + i);
                detailstv.setText(details[i]);
                tr.addView(detailstv);

                // Make TV to hold the detailvals

                TextView valstv = new TextView(getActivity());
                valstv.setId(300 + i);
                valstv.setText(ele[j][i]);
                tr.addView(valstv);

                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));

            }
        }*/
        return view;

    }
}