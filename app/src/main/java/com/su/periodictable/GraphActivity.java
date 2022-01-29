package com.su.periodictable;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

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
        XAxis xAxis = mChart.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);
        xAxis.setAxisMaximum(18f);
        xAxis.setAxisMinimum(0f);
        xAxis.setDrawLimitLinesBehindData(true);
        LimitLine ll1 = new LimitLine(53f, "Maximum Limit");
        ll1.setLineColor(Color.BLACK);
        ll1.setLineWidth(2f);
        ll1.enableDashedLine(30f, 10f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        ll1.setTextSize(10f);

        LimitLine ll2 = new LimitLine(31f, "Minimum Limit");
        ll2.setLineWidth(2f);
        ll2.enableDashedLine(30f, 10f, 0f);
        ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        ll2.setTextSize(10f);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines();
        leftAxis.addLimitLine(ll1);
        leftAxis.addLimitLine(ll2);
        leftAxis.setAxisMaximum(350f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawLimitLinesBehindData(false);

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
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);
            LineData data = new LineData(dataSets);
            mChart.setData(data);
        }
    }

    public void getData(){
        int size = 0;
        if(Elements.trendx.equals("Size")) {
            if (Elements.trendy == 2) {
                size = Elements.graphSizeprd[Elements.trendz].length;
                int[] graph = new int[size];
                for (int i = 0; i < size; i++) {
                    graph[i] = Elements.graphSizeprd[Elements.trendz][i];
                }
                graphy = graph;
            }else if(Elements.trendy == 1){
                size = Elements.graphSizegrp[Elements.trendz].length;
                int[] graph = new int[size];
                for (int i = 0; i < size; i++) {
                    graph[i] = Elements.graphSizegrp[Elements.trendz][i];
                }
                graphy = graph;

            }
        }

    }

}