package com.swufe.myfinaltest.Service;

import java.io.Serializable;

public class Time implements Serializable {
    private int id;
    private String time;
    private String username;
    private String thing;
    private String detail;
    public Time() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", thing='" + thing + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Time(String username, String time, String thing , String detail) {
        super();
        this.username = username;
        this.thing = thing;
        this.time = time;
        this.detail = detail;

    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
