package com.swufe.myfinaltest.Service;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String restime;
    private String usedTime;
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }




    public User(String username, String password, String restime, String usedTime) {
        super();
        this.username = username;
        this.password = password;
        this.restime = restime;
        this.usedTime = usedTime;

    }
    public String getRestime() {
        return restime;
    }

    public void setRestime(String restime) {
        this.restime = restime;
    }

    public String getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(String usedTime) {
        this.usedTime = usedTime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password +  "]";
    }
}
