package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AppDetailsResponse {

    @SerializedName("Status")
    @Expose
    private Boolean status;

    @SerializedName("Message")
    @Expose
    private String msg;

    @SerializedName("Data")
    @Expose
    private ArrayList<AppVersion> data;


    public AppDetailsResponse(Boolean status, String msg, ArrayList<AppVersion> appdata)
    {
        this.status = status;
        this.msg = msg;
        this.data = appdata;

    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    /*public AppVersion getData() {
        return data;
    }

    public void setData(AppVersion data) {
        this.data = data;
    }*/

    public ArrayList<AppVersion> getData() {
        return data;
    }

    public void setData(ArrayList<AppVersion> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
