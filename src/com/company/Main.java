package com.company;
import com.company.net.Connection;
import com.company.work.ThreadPool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello world");
        Connection test = new Connection();
        //10 is thread num, 2 is sleep_time
        ThreadPool thread_pool = new ThreadPool(10, 2);
        thread_pool.start();

        try {
            Thread.currentThread().sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*byte[][] test_data = new byte[][]{{1,1,1,1,1,},{2,2,2,2,2},{3,3,3,3,3}};
        for (int i = 0;i < 3; i++) {
            thread_pool.put_data(test_data[i]);
        }*/
        thread_pool.stop();
        /*for (int i = 0;i < 30; i++) {
            thread_pool.put_data(test_data[1]);
        }*/
    }
}
