package com.stmikbanisaleh.navbottom.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class responseModelsingle {
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("status")
    @Expose
    private boolean status;

    @SerializedName("data")
    @Expose
    private buku_m data;

    public responseModelsingle() {

    }

    public responseModelsingle(String message, boolean status, buku_m data) {
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

    public buku_m getData() {
        return data;
    }

    public void setData(buku_m data) {
        this.data = data;
    }
}
