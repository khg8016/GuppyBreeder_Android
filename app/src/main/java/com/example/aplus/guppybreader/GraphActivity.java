package com.example.aplus.guppybreader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.listener.OnDrawListener;
/**
 * Created by KHG on 2016-10-04.
 */

public class GraphActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        LineChart chart = (LineChart) findViewById(R.id.chart);

        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(12, 30));
        entries.add(new Entry(13, 31));
        entries.add(new Entry(14, 32));
        entries.add(new Entry(15, 33));
        entries.add(new Entry(16, 31));
        entries.add(new Entry(17, 33));
        entries.add(new Entry(18, 35));
        entries.add(new Entry(19, 33));
        entries.add(new Entry(20, 31));
        entries.add(new Entry(21, 33));
        entries.add(new Entry(22, 29));
        entries.add(new Entry(23, 27));
        entries.add(new Entry(24, 30));
        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();
    }
}
