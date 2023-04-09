package com.example.halatongis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestPost {
    public static void main(String[] args){
        String urlAdress = "http://127.0.0.1:3000/api/doit/";
        URL url;
        HttpURLConnection httpURLConnection;
        OutputStream os= null;
        InputStreamReader isR = null;
        BufferedReader biR = null;


        try{
            Map<String, String> postarcgs = new HashMap<>();
            postarcgs.put("User", "Bob");
            postarcgs.put("password", "123");

            byte[] out = postarcgs.toString().getBytes();


            url= new URL(urlAdress);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
            httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            httpURLConnection.setConnectTimeout(200);
            httpURLConnection.setReadTimeout(200);
            httpURLConnection.connect();



            try{
                os = httpURLConnection.getOutputStream();
                os.write();
            } catch (Exception e){
                System.err.print(e.getMessage());

            }

        } catch (MalformedURLException e) {
           e.printStackTrace();
        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }
}
