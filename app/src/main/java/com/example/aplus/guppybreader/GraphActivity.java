package com.example.aplus.guppybreader;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

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

public class GraphActivity extends Activity implements GestureDetector.OnGestureListener{

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private GestureDetector gestureScanner;
    private LineChart chart;
    private List<Entry> entries;
    private int flag;
    private int today;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        flag = 16;
        today = 27;
        gestureScanner = new GestureDetector(this, this);

        entries = new ArrayList<Entry>(); //최근 24개 데이터
        entries.add(new Entry(0, 30));
        entries.add(new Entry(1, 31));
        entries.add(new Entry(2, 32));
        entries.add(new Entry(3, 33));
        entries.add(new Entry(4, 31));
        entries.add(new Entry(5, 33));
        entries.add(new Entry(6, 35));
        entries.add(new Entry(7, 33));
        entries.add(new Entry(8, 31));
        entries.add(new Entry(9, 33));
        entries.add(new Entry(10, 29));
        entries.add(new Entry(11, 27));
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
        System.out.println(entries.size());
        LineChart chart = (LineChart) findViewById(R.id.chart);

        chart.setScaleEnabled(false);
        chart.setPinchZoom(false);
        chart.setDescription("2016.11."+today);
        List<Entry> today = new ArrayList<Entry>();
        for(int i = flag; i<flag+8; i++){
            today.add(entries.get(i));
        }
        LineDataSet dataSet = new LineDataSet(today, "Label"); // add entries to dataset
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        LineChart chart = (LineChart) findViewById(R.id.chart);
        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                return false;

            // right to left swipe
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

                if(flag <16){
                    flag += 8;today +=1;
                    System.out.println("flag크기"+flag);
                    System.out.println("전체크기"+entries.size());
                    List<Entry> abc = new ArrayList<Entry>();
                    for(int i = flag; i<flag+8; i++){
                        abc.add(entries.get(i));
                    }
                    LineDataSet dataSet = new LineDataSet(abc, "Label"); // add entries to dataset
                    LineData lineData = new LineData(dataSet);
                    chart.setDescription("2016.11."+today);
                    chart.setData(lineData);
                    chart.invalidate();

                    Toast.makeText(getApplicationContext(), "다음 날", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "불가능", Toast.LENGTH_SHORT).show();
                }
            }
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

                if(flag >=8){
                    today-=1;
                    flag = flag - 8;
                    System.out.println("flag크기"+flag);
                    System.out.println("전체크기"+entries.size());
                    List<Entry> abc = new ArrayList<Entry>();
                    for(int i = flag; i<flag+8; i++){
                        abc.add(entries.get(i));
                    }
                    LineDataSet dataSet = new LineDataSet(abc, "Label"); // add entries to dataset
                    LineData lineData = new LineData(dataSet);
                    chart.setDescription("2016.11."+today);
                    chart.setData(lineData);
                    chart.invalidate();

                    Toast.makeText(getApplicationContext(), "전 날", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "불가능", Toast.LENGTH_SHORT).show();
                }
            }
            // down to up swipe

        } catch (Exception e) {

        }
        return true;
    }



    public boolean dispatchTouchEvent(MotionEvent ev) {

        if(gestureScanner.onTouchEvent(ev)){
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }
    public boolean onDown(MotionEvent e) {
        return true;
    }

    public void onLongPress(MotionEvent e) {
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return true;
    }

    public void onShowPress(MotionEvent e) {
    }

    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }
}
