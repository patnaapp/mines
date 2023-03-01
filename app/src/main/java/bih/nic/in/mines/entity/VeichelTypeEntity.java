package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VeichelTypeEntity {

    @SerializedName("VehicleCapacity")
    @Expose
    private String vehicleCapacity;

    @SerializedName("MineralWeight")
    @Expose
    private String mineralWeight;

    @SerializedName("VehicleMaxWt")
    @Expose
    private String vehicleMaxWt;

    public VeichelTypeEntity() {
    }

    public VeichelTypeEntity(String vehicleCapacity, String mineralWeight, String vehicleMaxWt) {
        this.vehicleCapacity = vehicleCapacity;
        this.mineralWeight = mineralWeight;
        this.vehicleMaxWt = vehicleMaxWt;
    }

    public String getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(String vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public String getMineralWeight() {
        return mineralWeight;
    }

    public void setMineralWeight(String mineralWeight) {
        this.mineralWeight = mineralWeight;
    }

    public String getVehicleMaxWt() {
        return vehicleMaxWt;
    }

    public void setVehicleMaxWt(String vehicleMaxWt) {
        this.vehicleMaxWt = vehicleMaxWt;
    }
}
