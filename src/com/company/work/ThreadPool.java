package com.company.work;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by houjinchao on 16/8/23.
 */
public class ThreadPool {
    private BlockingQueue<byte[]> data_pool;
    private boolean run = false;
    private int thread_num = 1000;
    private int sleep_time = 1000;
    private WorkThread []thread_array;
    private RequestThread request_thread;

    public void start() {
        this.run = true;
        init();
    }

    public boolean init() {
        thread_array = new WorkThread [thread_num];
        for (int i = 0; i < thread_num; i++) {
            thread_array[i] = new WorkThread(this);
            thread_array[i].start();
        }
        request_thread.start();
        return true;
    }

    public void stop() {
        this.run = false;
    }

    public boolean get_status() {
        return this.run;
    }

    public ThreadPool(int num, int sleep_time) {
        this.thread_num = num;
        this.sleep_time = sleep_time;
        data_pool = new LinkedBlockingQueue<byte[]>(this.thread_num);
        request_thread = new RequestThread(sleep_time, this);
    }

    public boolean get_data(byte[] data) {
        try{
            data = data_pool.take();
            return true;
        } catch (InterruptedException e) {
            System.out.println("get data error");
            return false;
        }
    }

    public  boolean put_data(byte[] data) {
        return data_pool.offer(data);
    }
}

