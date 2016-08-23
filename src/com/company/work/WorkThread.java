package com.company.work;

import com.company.net.Connection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by houjinchao on 16/8/23.
 */
public class WorkThread extends Thread {
    private ThreadPool thread_pool;
    private Connection conn;
    private String name;

    public WorkThread(ThreadPool thread_pool_ptr) {
        name = "work_thread_" + this.getId();
        this.thread_pool = thread_pool_ptr;
        conn = new Connection();
    }

    public void setThread_pool(ThreadPool thread_pool) {
        this.thread_pool = thread_pool;
    }

    public WorkThread() {
        conn = new Connection();
        name = "work_thread_" + this.getId();
    }

    public void write_log(String buffer_str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        String header = "[" + sdf.format(new Date()) + "]" + " " + name + " ";
        System.out.println(header + buffer_str);
    }

    public boolean create_data(byte[]data, TimeData time) {
        //TODO to be add @yali
        return true;
    }

    public boolean create_data(byte[]data, ArrayList<String> list) {
        //TODO to be add @yali
        return true;
    }

    public void run(){
        write_log(" start to work");
        while (thread_pool.get_status()) {
            byte [] data = new byte[10240000];
            TimeData time = new TimeData();
            if(!thread_pool.get_data(data)) {
                write_log("get_data faild");
                continue;
            }
            boolean ret = conn.httpUrlConnection(data, time);
            if (!ret) {
                write_log("request no response");
                continue;
            }
            byte[] data2 = new byte[10240000];
            ArrayList<String> list = new ArrayList<String>();
            if (!create_data(data2, time)) {
                write_log("create data2 faild");
                continue;
            }
            ret = conn.httpUrlConnection_pb(data2, list);
            if (!ret) {
                write_log("request[pb] no response");
                continue;
            }
            byte[] data3 = new byte[10240000];
            if (!create_data(data3, list)) {
                write_log("create data3 faild");
                continue;
            }
            ret = conn.httpUrlConnection_pic(data3);
            if (ret) {
                write_log("request process success");
            } else {
                write_log("request[pic] no response");
            }

        }
        write_log("thread stop success");
    }
}
