package bih.nic.in.mines.entity;


public class MiningDetailsRequest {

    public static Class<MiningDetailsRequest> User_CLASS = MiningDetailsRequest.class;



    private String s_Key;
    private String cap;
    private String userAutoId;
    private String desigId;


    public MiningDetailsRequest(String s_Key, String cap, String userAutoId, String desigId) {
        this.s_Key = s_Key;
        this.cap = cap;
        this.userAutoId = userAutoId;
        this.desigId = desigId;
    }

    public MiningDetailsRequest() {

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

    public String getUserAutoId() {
        return userAutoId;
    }

    public void setUserAutoId(String userAutoId) {
        this.userAutoId = userAutoId;
    }

    public String getDesigId() {
        return desigId;
    }

    public void setDesigId(String desigId) {
        this.desigId = desigId;
    }
}
