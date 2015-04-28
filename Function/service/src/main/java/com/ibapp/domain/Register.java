package com.ibapp.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by imran on 12/04/15.
 */
public class Register {

    private Integer id;
    private String userName;
    private String password;
    private Date userDOB;
    private ArrayList<String> userInterest;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Date getUserDOB() { return userDOB; }

    public void setUserDOB(Date userDOB) { this.userDOB = userDOB; }

    public ArrayList<String> getUserInterest() {
        return userInterest;
    }

    public void setUserInterest(ArrayList<String> userInterest) {
        this.userInterest = userInterest;
    }
}
