package com.company.work;

/**
 * Created by houjinchao on 16/8/23.
 */
public class TimeData {
    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    private String start_time;

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    private String end_time;

    public TimeData(){
        this.start_time = "";
        this.end_time = "";
    }

}
