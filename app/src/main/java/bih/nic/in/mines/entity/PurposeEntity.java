package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PurposeEntity {

    @SerializedName("Id")
    @Expose
    private String purposeId;

    @SerializedName("Name")
    @Expose
    private String purposeName;

    public PurposeEntity() {
    }

    public PurposeEntity(String purposeId, String purposeName) {
        this.purposeId = purposeId;
        this.purposeName = purposeName;
    }

    public String getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(String purposeId) {
        this.purposeId = purposeId;
    }

    public String getPurposeName() {
        return purposeName;
    }

    public void setPurposeName(String purposeName) {
        this.purposeName = purposeName;
    }
}
