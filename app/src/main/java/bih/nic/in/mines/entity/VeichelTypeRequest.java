package bih.nic.in.mines.entity;


public class VeichelTypeRequest {

    public static Class<VeichelTypeRequest> User_CLASS = VeichelTypeRequest.class;




    private String s_Key;
    private String cap;
    private String permitNo;
    public String miniralTypeId;
    public String miniralId;
    public String vehicleTypeId;

    public VeichelTypeRequest() {

    }

    public VeichelTypeRequest(String s_Key, String cap, String permitNo, String miniralTypeId, String miniralId, String vehicleTypeId) {
        this.s_Key = s_Key;
        this.cap = cap;
        this.permitNo = permitNo;
        this.miniralTypeId = miniralTypeId;
        this.miniralId = miniralId;
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getS_Key() {
        return s_Key;
    }

    public void setS_Key(String s_Key) {
        this.s_Key = s_Key;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getPermitNo() {
        return permitNo;
    }

    public void setPermitNo(String permitNo) {
        this.permitNo = permitNo;
    }

    public String getMiniralTypeId() {
        return miniralTypeId;
    }

    public void setMiniralTypeId(String miniralTypeId) {
        this.miniralTypeId = miniralTypeId;
    }

    public String getMiniralId() {
        return miniralId;
    }

    public void setMiniralId(String miniralId) {
        this.miniralId = miniralId;
    }

    public String getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(String vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }
}
