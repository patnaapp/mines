package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VehicleEntity {


    @SerializedName("Id")
    @Expose
    private String vehicleTypeId;

    @SerializedName("Name")
    @Expose
    private String vehicleTypeName;

    public VehicleEntity() {
    }

    public VehicleEntity(String vehicleTypeId, String vehicleTypeName) {
        this.vehicleTypeId = vehicleTypeId;
        this.vehicleTypeName = vehicleTypeName;
    }

    public String getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(String vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }
}
