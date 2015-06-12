package com.ibapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by imran on 12/04/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Register {

    private Integer id;
    private String userName;
    private String password;

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

}
