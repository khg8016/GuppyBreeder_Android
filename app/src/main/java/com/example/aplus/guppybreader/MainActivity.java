package com.example.aplus.guppybreader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.output);//UI화면의 output 객체의 변수선언
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.submitBtn:
                new HttpRequest().execute();
                break;
            case R.id.graphBtn:
                startActivity(new Intent(this, GraphActivity.class));
                break;
        }
        System.out.println("clicked");
    }


}