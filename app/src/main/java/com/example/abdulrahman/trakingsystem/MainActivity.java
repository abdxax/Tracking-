package com.example.abdulrahman.trakingsystem;

import android.app.FragmentManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void butsingin(View view) {
    }

    public void butsingup(View view) {
        FragmentManager fragmentManager=getFragmentManager();
        Register register=new Register();
        register.show(fragmentManager,"tees");
    }

    public void register(String type,String name,String IDjob,String pass){

            String url="http://192.168.1.1/Traking/webs.php?name="+name+"&id="+IDjob+"&pass="+pass+"";
            new dbmy().execute(url);


    }


   public class dbmy extends AsyncTask<String,String,String>{

       @Override
       protected void onPreExecute() {
           super.onPreExecute();
       }

       @Override
       protected void onPostExecute(String s) {
           super.onPostExecute(s);
       }

       @Override
       protected void onProgressUpdate(String... values) {
           super.onProgressUpdate(values);
       }

       @Override
       protected String doInBackground(String... strings) {
           String url=strings[0];
           try {
               URL url1=new URL(url);
               HttpURLConnection connection=(HttpURLConnection) url1.openConnection();
               connection.setReadTimeout(10000);
               connection.setConnectTimeout(15000);
               connection.setRequestMethod("GET");
               connection.setDoInput(true);
               connection.setDoOutput(true);



           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
           return null;
       }
   }
}
