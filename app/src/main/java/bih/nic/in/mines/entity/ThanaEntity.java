package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThanaEntity {


    @SerializedName("Id")
    @Expose
    private String thanaId;

    @SerializedName("Name")
    @Expose
    private String thanaName;

    public ThanaEntity() {
    }

    public ThanaEntity(String thanaId, String thanaName) {
        this.thanaId = thanaId;
        this.thanaName = thanaName;
    }

    public String getThanaId() {
        return thanaId;
    }

    public void setThanaId(String thanaId) {
        this.thanaId = thanaId;
    }

    public String getThanaName() {
        return thanaName;
    }

    public void setThanaName(String thanaName) {
        this.thanaName = thanaName;
    }
}
