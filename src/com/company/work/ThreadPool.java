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

    public void run() {
        this.run = true;
    }

    public ThreadPool(int num) {
        this.thread_num = num;
        data_pool = new LinkedBlockingQueue<byte[]>(this.thread_num);
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

