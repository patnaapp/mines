package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import bih.nic.in.mines.security.Encriptor;
import bih.nic.in.mines.utilities.CommonPref;

public class AllotmentDetailsResponse {

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
    private ArrayList<AllotmentDetailsEntity> data;

    @SerializedName("District")
    @Expose
    private ArrayList<DistrictEntity> district;

    @SerializedName("Vehicle")
    @Expose
    private ArrayList<VehicleEntity> vehicle;


    public AllotmentDetailsResponse(Boolean status, String msg, String cap, String s_Key, ArrayList<AllotmentDetailsEntity> data, ArrayList<DistrictEntity> district, ArrayList<VehicleEntity> vehicle) {
        this.status = status;
        this.msg = msg;
        this.cap = cap;
        this.s_Key = s_Key;
        this.data = data;
        this.district = district;
        this.vehicle = vehicle;
    }

    public AllotmentDetailsResponse(AllotmentDetailsResponse obj) {
        Encriptor _encrptor = new Encriptor();

        try {
            this.s_Key = _encrptor.Decrypt(obj.getS_Key(), CommonPref.CIPER_KEY);
            this.cap = (_encrptor.Decrypt(obj.getCap(), s_Key));
            this.msg = obj.getMsg();
            this.status = obj.getStatus();
            this.data = obj.getData();
            this.district = obj.getDistrict();
            this.vehicle = obj.getVehicle();

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

    public ArrayList<AllotmentDetailsEntity> getData() {
        return data;
    }

    public void setData(ArrayList<AllotmentDetailsEntity> data) {
        this.data = data;
    }

    public ArrayList<DistrictEntity> getDistrict() {
        return district;
    }

    public void setDistrict(ArrayList<DistrictEntity> district) {
        this.district = district;
    }

    public ArrayList<VehicleEntity> getVehicle() {
        return vehicle;
    }

    public void setVehicle(ArrayList<VehicleEntity> vehicle) {
        this.vehicle = vehicle;
    }
}
