package com.company.net;

import com.company.work.TimeData;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by houjinchao on 16/8/21.
 */
public class Connection {

    public boolean httpUrlConnection(byte[] data, TimeData time) {

        // TODO:: tobe delete
        time.setStart_time("aaa");
        time.setEnd_time("bbb");
        return true;
        /*
        try {
            String pathUrl = "http://10.189.196.254:7001/trkproxy/trkPoint?socolimei=12345678901234";
            //String pathUrl = "http:://www.baidu.com";

            URL url = new URL(pathUrl);

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod("POST");

            String request_str = "[{\"x\":123.345,\"y\":123.345,\"bearing\":204,\"timestap\":1461726264875,\"speed\":80},{\"x\":123.345,\"y\":123.345,\"bearing\":204,\"timestap\":1461726269875,\"speed\":80}]";
            //String request_str = "[{\"a\":\"b\"}]";

            byte[] requestStringBytes = request_str.getBytes();
            httpConn.setRequestProperty("Content-Type", "application/Json");
            //httpConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpConn.setRequestProperty("Accept-Charset", "UTF-8");
            httpConn.setRequestProperty("imei", "1234567891234");
            httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length);

            OutputStream output_str = httpConn.getOutputStream();
            output_str.write(requestStringBytes);
            output_str.close();

            int res_p_code = httpConn.getResponseCode();

            if (res_p_code == HttpURLConnection.HTTP_OK) {
                System.out.println("success");
                //TODO::judge and get response data @yali
                return true;
            } else {
                System.out.println("faild" + res_p_code);
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        */
    }

    public boolean httpUrlConnection_pb(byte[] data, ArrayList<String> list) {
        //TODO: to be delete
        list.add("ccc");
        return true;
        /*
        try {
            String pathUrl = "http://10.189.200.68:7001/trkproxy/trkPoint?imei=12345678901234&id=1461726264875_1461726270875";
            //String pathUrl = "http:://www.baidu.com";

            URL url = new URL(pathUrl);

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod("POST");

            String request_str = "[{\"x\":123.345,\"y\":123.345,\"bearing\":204,\"timestap\":1461726264875,\"speed\":80},{\"x\":123.345,\"y\":123.345,\"bearing\":204,\"timestap\":1461726269875,\"speed\":80}]";
            //String request_str = "[{\"a\":\"b\"}]";

            byte[] requestStringBytes = request_str.getBytes();
            httpConn.setRequestProperty("Content-Type", "application/PB");
            httpConn.setRequestProperty("Accept-Charset", "UTF-8");
            httpConn.setRequestProperty("imei", "1234567891234");
            httpConn.setRequestProperty("Content-length", "" + requestStringBytes.length);

            OutputStream output_str = httpConn.getOutputStream();
            output_str.write(requestStringBytes);
            output_str.close();

            int res_p_code = httpConn.getResponseCode();

            if (res_p_code == HttpURLConnection.HTTP_OK) {
                System.out.println("success");
                //TODO judge and get response data @yali
                return true;
            } else {
                System.out.println("faild" + res_p_code);
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        */
    }

    public boolean httpUrlConnection_pic(byte[] data) {
        //TODO: to be delete
        return true;
        //TODO: add upload code @yali
    }
}
