package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllotmentListEntity {


    @SerializedName("Id")
    @Expose
    private String allotmentId;

    @SerializedName("Name")
    @Expose
    private String allotmentName;

    public AllotmentListEntity() {
    }

    public AllotmentListEntity(String allotmentId, String allotmentName) {
        this.allotmentId = allotmentId;
        this.allotmentName = allotmentName;
    }

    public String getAllotmentId() {
        return allotmentId;
    }

    public void setAllotmentId(String allotmentId) {
        this.allotmentId = allotmentId;
    }

    public String getAllotmentName() {
        return allotmentName;
    }

    public void setAllotmentName(String allotmentName) {
        this.allotmentName = allotmentName;
    }
}
