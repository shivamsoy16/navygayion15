package com.su.periodictable;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    public int[] graphy;
    int size=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_graph);
        getData();
        LineChart mChart;
        mChart = findViewById(R.id.linechart);
        mChart.setTouchEnabled(true);
        mChart.setPinchZoom(true);
        MyMarkerView mv = new MyMarkerView(GraphActivity.this, R.layout.custom_marker_view);
        mv.setChartView(mChart);
        mChart.setMarker(mv);
        renderData(mChart);

    }

    public void renderData(LineChart mChart) {
        LimitLine llXAxis = new LimitLine(10f, "Index 10");
        llXAxis.setLineWidth(4f);
        llXAxis.enableDashedLine(10f, 10f, 0f);
        llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        llXAxis.setTextSize(10f);
        if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) ==Configuration.UI_MODE_NIGHT_YES) {
            llXAxis.setLineColor(Color.rgb(255, 255, 255));
            llXAxis.setTextColor(Color.rgb(255, 255, 255));
            mChart.getLegend().setTextColor(Color.rgb(255, 255, 255));
            mChart.getDescription().setTextColor(Color.rgb(255, 255, 255));
        }
        llXAxis.setLineColor(Color.rgb(255, 255, 255));
        XAxis xAxis = mChart.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMaximum(18f);
        xAxis.setAxisMinimum(0f);
        xAxis.setDrawLimitLinesBehindData(true);




//        LimitLine ll2 = new LimitLine(60f, "Maximum Limit");
//        ll1.setLineColor(Color.BLACK);
//        ll1.setLineWidth(2f);
//        ll1.enableDashedLine(30f, 10f, 0f);
//        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
//        ll1.setTextSize(10f);

//        LimitLine ll2 = new LimitLine(31f, "Minimum Limit");
//        ll2.setLineWidth(2f);
//        ll2.enableDashedLine(30f, 10f, 0f);
//        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
//        ll2.setTextSize(10f);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        for (int i =0;i<graphy.length;i++){
            if (Trenddata.trendy==1) {
                LimitLine lli = new LimitLine(graphy[i], Trenddata.trendelementgrp[Trenddata.trendz][i]);
                if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) ==Configuration.UI_MODE_NIGHT_YES) {
                        lli.setLineColor(Color.rgb(255, 255, 255));
                        lli.setTextColor(Color.rgb(255, 255, 255));
                }
                lli.setLineWidth(2f);
                lli.enableDashedLine(30f, 10f, 0f);
                lli.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
                lli.setTextSize(10f);

                leftAxis.addLimitLine(lli);
            }else if (Trenddata.trendy==2){
                LimitLine lli = new LimitLine(graphy[i], Trenddata.trendelementprd[Trenddata.trendz][i]);
                if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) ==Configuration.UI_MODE_NIGHT_YES) {
                    lli.setLineColor(Color.rgb(255, 255, 255));
                    lli.setTextColor(Color.rgb(255, 255, 255));
                }
                lli.setLineWidth(2f);
                lli.enableDashedLine(30f, 10f, 0f);
                lli.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
                lli.setTextSize(10f);
                leftAxis.addLimitLine(lli);
            }

        }

//        leftAxis.addLimitLine(ll2);
        switch (Trenddata.trendx){
            case 1:
                leftAxis.setAxisMaximum(350f);
                break;
            case 2:
                leftAxis.setAxisMaximum(2050f);
                break;
            default:
                break;
        }
//        leftAxis.setAxisMaximum(2050f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawLimitLinesBehindData(false);
        if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) ==Configuration.UI_MODE_NIGHT_YES) {
            leftAxis.setTextColor(Color.rgb(255, 255, 255));
            leftAxis.setGridColor(Color.rgb(255, 255, 255));
            leftAxis.setZeroLineColor(Color.rgb(255, 255, 255));
            leftAxis.setAxisLineColor(Color.rgb(255, 255, 255));
            mChart.getLegend().setTextColor(Color.rgb(255, 255, 255));
            mChart.getDescription().setTextColor(Color.rgb(255, 255, 255));

        }
        mChart.getAxisRight().setEnabled(false);
        setData(mChart);
    }

    private void setData(LineChart mChart) {

        ArrayList<Entry> values = new ArrayList<>();
        for (int i = 0;i<graphy.length;i++) {
            values.add(new Entry(i+1, graphy[i]));
        }
/*        values.add(new Entry(3, 80));
        values.add(new Entry(4, 120));
        values.add(new Entry(5, 110));
        values.add(new Entry(7, 150));
        values.add(new Entry(8, 250));
        values.add(new Entry(9, 190));*/

        LineDataSet set1;
        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            if(Trenddata.trendy==1){
                set1 = new LineDataSet(values, "Group Wise Trend");
            }else{
                set1 = new LineDataSet(values, "Period Wise Trend");
            }
            set1 = new LineDataSet(values, "Sample Data");
            set1.setDrawIcons(false);
            set1.enableDashedLine(10f, 5f, 0f);
            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(Color.DKGRAY);
            set1.setCircleColor(Color.DKGRAY);
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawFilled(true);
            set1.setFormLineWidth(1f);
            set1.setFormLineDashEffect(new DashPathEffect(new float[]{10f, 5f}, 0f));
            set1.setFormSize(15.f);

            if (Utils.getSDKInt() >= 18) {
                Drawable drawable = ContextCompat.getDrawable(GraphActivity.this, R.drawable.fade_blue);
                set1.setFillDrawable(drawable);
            } else {
                set1.setFillColor(Color.DKGRAY);
            }
            if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) ==Configuration.UI_MODE_NIGHT_YES)
            {
                set1.setValueTextColor(Color.rgb(255, 255, 255));
            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);
            mChart.setData(data);
        }
    }

    public void getData(){
        /** trendx being 1=size, 2=inonization enthalpy
         * trendy being 1=group, 2= period
         */
        switch(Trenddata.trendx){
            case 1:
                if(Trenddata.trendy==1){
                    size = Trenddata.graphSizegrp[Trenddata.trendz].length;
                    int[] graph = new int[size];
                    for (int i = 0; i < size; i++) {
                        graph[i] = Trenddata.graphSizegrp[Trenddata.trendz][i];
                    }
                    graphy = graph;
                }else if(Trenddata.trendy==2){
                    size = Trenddata.graphSizeprd[Trenddata.trendz].length;
                    int[] graph = new int[size];
                    for (int i = 0; i < size; i++) {
                        graph[i] = Trenddata.graphSizeprd[Trenddata.trendz][i];
                    }
                    graphy = graph;
                }
                break;
            case 2:
                if(Trenddata.trendy==1){
                    size = Trenddata.graphiegrp[Trenddata.trendz].length;
                    int[] graph = new int[size];
                    for (int i = 0; i < size; i++) {
                        graph[i] = (int) Trenddata.graphiegrp[Trenddata.trendz][i];
                    }
                    graphy = graph;
                }else if(Trenddata.trendy==2){
                    size = Trenddata.graphieprd[Trenddata.trendz].length;
                    int[] graph = new int[size];
                    for (int i = 0; i < size; i++) {
                        graph[i] = (int) Trenddata.graphieprd[Trenddata.trendz][i];
                    }
                    graphy = graph;
                }
                break;
            default:
                break;

        }

    }


}