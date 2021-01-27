package com.stmikbanisaleh.navbottom.model.user;

import java.util.List;

public class responseUser {
    private String message;
    private boolean status;
    private List<user_m> data;

    public responseUser() {

    }

    public responseUser(String message, boolean status, List<user_m> data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<user_m> getData() {
        return data;
    }

    public void setData(List<user_m> data) {
        this.data = data;
    }
}
