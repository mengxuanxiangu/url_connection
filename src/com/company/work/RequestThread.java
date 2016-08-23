package com.company.work;

/**
 * Created by houjinchao on 16/8/23.
 */
public class RequestThread extends Thread {
    private int sleep_time;
    private ThreadPool thread_pool;

    public RequestThread(int sleep_time, ThreadPool thread_pool_ptr) {
        this.sleep_time = sleep_time;
        this.thread_pool = thread_pool_ptr;
    }

    public void run() {
        //TODO:: add read data @yali
        byte[] data = {1,1,1,1,1,11,1,1};
        while(thread_pool.get_status()) {
            thread_pool.put_data(data);
            try {
                sleep(sleep_time);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
