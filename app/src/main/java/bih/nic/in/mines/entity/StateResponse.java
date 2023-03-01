package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import bih.nic.in.mines.security.Encriptor;
import bih.nic.in.mines.utilities.CommonPref;

public class StateResponse {

    @SerializedName("Status")
    @Expose
    private Boolean status;

    @SerializedName("Message")
    @Expose
    private String msg;

    @SerializedName("Cap")
    @Expose
    private String cap;

    @SerializedName("S_Key")
    @Expose
    private String s_Key;

    @SerializedName("Data")
    @Expose
    private ArrayList<StateEntity> data;


    public StateResponse(Boolean status, String msg, String cap, String s_Key, ArrayList<StateEntity> data) {
        this.status = status;
        this.msg = msg;
        this.cap = cap;
        this.s_Key = s_Key;
        this.data = data;
    }

    public StateResponse(StateResponse obj) {
        Encriptor _encrptor = new Encriptor();

        try {
            this.s_Key = _encrptor.Decrypt(obj.getS_Key(), CommonPref.CIPER_KEY);
            this.cap = (_encrptor.Decrypt(obj.getCap(), s_Key));
            this.msg = obj.getMsg();
            this.status = obj.getStatus();
            this.data = obj.getData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getS_Key() {
        return s_Key;
    }

    public void setS_Key(String s_Key) {
        this.s_Key = s_Key;
    }

    public ArrayList<StateEntity> getData() {
        return data;
    }

    public void setData(ArrayList<StateEntity> data) {
        this.data = data;
    }
}
