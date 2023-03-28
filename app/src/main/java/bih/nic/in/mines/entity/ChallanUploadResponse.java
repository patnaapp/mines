package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import bih.nic.in.mines.security.Encriptor;
import bih.nic.in.mines.utilities.CommonPref;

public class ChallanUploadResponse {

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

    @SerializedName("Url")
    @Expose
    private String url;

    @SerializedName("ChallanRefNo")
    @Expose
    private String challanRefNo;

    @SerializedName("ChallanRefNoEncy")
    @Expose
    private String challanRefNoEncy;



    public ChallanUploadResponse(Boolean status, String msg, String cap, String s_Key, String url, String challanRefNo, String challanRefNoEncy ) {
        this.status = status;
        this.msg = msg;
        this.cap = cap;
        this.s_Key = s_Key;
        this.url = url;
        this.challanRefNo = challanRefNo;
        this.challanRefNoEncy = challanRefNoEncy;
    }

    public ChallanUploadResponse(ChallanUploadResponse obj) {
        Encriptor _encrptor = new Encriptor();

        try {
            this.s_Key = _encrptor.Decrypt(obj.getS_Key(), CommonPref.CIPER_KEY);
            this.cap = (_encrptor.Decrypt(obj.getCap(), s_Key));
            this.msg = obj.getMsg();
            this.status = obj.getStatus();
            this.url = obj.getUrl();
            this.challanRefNo = obj.getChallanRefNo();
            this.challanRefNoEncy = obj.getChallanRefNoEncy();

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChallanRefNo() {
        return challanRefNo;
    }

    public void setChallanRefNo(String challanRefNo) {
        this.challanRefNo = challanRefNo;
    }

    public String getChallanRefNoEncy() {
        return challanRefNoEncy;
    }

    public void setChallanRefNoEncy(String challanRefNoEncy) {
        this.challanRefNoEncy = challanRefNoEncy;
    }
}
