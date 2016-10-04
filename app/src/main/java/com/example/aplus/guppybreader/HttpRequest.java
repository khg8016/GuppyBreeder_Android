package com.example.aplus.guppybreader;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Aplus on 2016-09-28.
 */
public class HttpRequest extends AsyncTask<Void,Void,Void>{
    private String urlPath = null;
    private String Content;


    protected void onPreExecute() {
        super.onPreExecute();
        urlPath = "http://helloybz.dlinkddns.com:3331/temperature";
    }
    protected Void  doInBackground(Void... voids){
        try{
           URL url = new URL(urlPath);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setRequestMethod("POST");
            String data = URLEncoder.encode("msg", "UTF-8") + "=" + URLEncoder.encode("FOX", "UTF-8");

            OutputStream outputStream = con.getOutputStream();

            outputStream.write(data.getBytes());

            outputStream.flush();

            BufferedReader rd =null;
            rd = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb=new StringBuilder();
            while((line = rd.readLine()) != null){
                Log.d("BufferedReader", line);
                sb.append(line + "\n");
            }

            Content = sb.toString();
            rd.close();
            outputStream.close();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(Void aVoid) {
        System.out.println("postexcute");
        super.onPostExecute(aVoid);
        MainActivity.output.setText(Content);

        /*String OutputData = "";
        JSONObject jsonResponse;

        try {

            *//****** 문자열 Content변수내용을 JSON Object로 생성 ********//*
            jsonResponse = new JSONObject(Content);

            // JSONArray에서 항목 이름으로 결과 값 조회
            JSONArray jsonMainNode = jsonResponse.optJSONArray("Android");

            // 각각의 JSON Node를 처리/

            int lengthJsonArr = jsonMainNode.length();//"Android 로 시작하는 서브노드배열의 갯수를 구함

            for(int i=0; i < lengthJsonArr; i++)
            {
                *//****** JSON node에서 데이터를 얻어옴***********//*
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                *//******* 노드 밸류에서 값을 얻어옴**********//*
                String name       = jsonChildNode.optString("name").toString();
                String number     = jsonChildNode.optString("number").toString();
                String date_added = jsonChildNode.optString("date_added").toString();


                OutputData += " Name 		    : "+ name +" \n "
                        + "Number 		: "+ number +" \n "
                        + "Time 				: "+ date_added +" \n "
                        +"--------------------------------------------------\n";

                //Log.i("JSON parse", song_name);
            }
            *//****************** JSON Data parsing 완료 *************//*

            // 파싱된 결과값을 화면 UI jsonParsed객체에 뿌림줌
            MainActivity.output.setText( OutputData );

        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }
}
