package bih.nic.in.mines.entity;


public class VeichleNoDetailsRequest {

    public static Class<VeichleNoDetailsRequest> User_CLASS = VeichleNoDetailsRequest.class;




    private String s_Key;
    private String cap;
    private String vehicleTypeId;
    private String vehicleNo;
    private String sourceTypeId;
    private String lesseeId;
    private String miniralId;

    public VeichleNoDetailsRequest() {

    }

    public VeichleNoDetailsRequest(String s_Key, String cap, String vehicleTypeId, String vehicleNo, String sourceTypeId, String lesseeId, String miniralId) {
        this.s_Key = s_Key;
        this.cap = cap;
        this.vehicleTypeId = vehicleTypeId;
        this.vehicleNo = vehicleNo;
        this.sourceTypeId = sourceTypeId;
        this.lesseeId = lesseeId;
        this.miniralId = miniralId;
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

    public String getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(String vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getSourceTypeId() {
        return sourceTypeId;
    }

    public void setSourceTypeId(String sourceTypeId) {
        this.sourceTypeId = sourceTypeId;
    }

    public String getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(String lesseeId) {
        this.lesseeId = lesseeId;
    }

    public String getMiniralId() {
        return miniralId;
    }

    public void setMiniralId(String miniralId) {
        this.miniralId = miniralId;
    }
}
