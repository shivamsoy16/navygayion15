package com.su.navygayion15.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.Toast;

import com.su.navygayion15.Elements;
import com.su.navygayion15.InfoActivity;
import com.su.navygayion15.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment implements View.OnClickListener {

    /*@Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().getActionBar().setTitle("List");

    }*/

    public int igg = 0;

    public void otab(View v)
    {   TableRow tbr1 = v.findViewById(R.id.but_1);
        tbr1.setOnClickListener(this);
        TableRow tbr2 = v.findViewById(R.id.but_2);
        tbr2.setOnClickListener(this);
        TableRow tbr3 = v.findViewById(R.id.but_3);
        tbr3.setOnClickListener(this);
        TableRow tbr4 = v.findViewById(R.id.but_4);
        tbr4.setOnClickListener(this);
        TableRow tbr5 = v.findViewById(R.id.but_5);
        tbr5.setOnClickListener(this);
        TableRow tbr6 = v.findViewById(R.id.but_6);
        tbr6.setOnClickListener(this);
        TableRow tbr7 = v.findViewById(R.id.but_7);
        tbr7.setOnClickListener(this);
        TableRow tbr8 = v.findViewById(R.id.but_8);
        tbr8.setOnClickListener(this);
        TableRow tbr9 = v.findViewById(R.id.but_9);
        tbr9.setOnClickListener(this);
        TableRow tbr10 = v.findViewById(R.id.but_10);
        tbr10.setOnClickListener(this);
        TableRow tbr11 = v.findViewById(R.id.but_11);
        tbr11.setOnClickListener(this);
        TableRow tbr12 = v.findViewById(R.id.but_12);
        tbr12.setOnClickListener(this);
        TableRow tbr13 = v.findViewById(R.id.but_13);
        tbr13.setOnClickListener(this);
        TableRow tbr14 = v.findViewById(R.id.but_14);
        tbr14.setOnClickListener(this);
        TableRow tbr15 = v.findViewById(R.id.but_15);
        tbr15.setOnClickListener(this);
        TableRow tbr16 = v.findViewById(R.id.but_16);
        tbr16.setOnClickListener(this);
        TableRow tbr17 = v.findViewById(R.id.but_17);
        tbr17.setOnClickListener(this);
        TableRow tbr18 = v.findViewById(R.id.but_18);
        tbr18.setOnClickListener(this);
        TableRow tbr19 = v.findViewById(R.id.but_19);
        tbr19.setOnClickListener(this);
        TableRow tbr20 = v.findViewById(R.id.but_20);
        tbr20.setOnClickListener(this);
    }
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
        View view =  inflater.inflate(R.layout.fragment_list, container, false);
        otab(view);
        return view;
            }

    @Override
    public void onClick(View view) {
        int goo = view.getId();
        Resources res = view.getResources();
        String idString = res.getResourceEntryName(goo);
        String[] part = idString.split("(?<=\\D)(?=\\d)");
        Elements.cos = Integer.parseInt(part[1]);
        int igg = (int) Elements.cos;
        String[][] ele = Elements.getSubjects();
        if (igg<16)
            Toast.makeText(getActivity(), "Clicked on Button:- "+goo+"  or  "+
                    idString+" "+part[0]+" and "+igg+ele[igg][2], Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        startActivity(intent);

    }
    /*static int extractInt(String str)
    {
        // Replacing every non-digit number
        // with a space(" ")
        str = str.replaceAll("[^\\d]", " ");

        // Remove extra spaces from the beginning
        // and the ending of the string
        str = str.trim();

        // Replace all the consecutive white
        // spaces with a single space
        str = str.replaceAll(" +", " ");

        if (str.equals(""))
            return "-1";

        return str;
    }*/

    public int getIgg() {
        return igg;
    }
}


