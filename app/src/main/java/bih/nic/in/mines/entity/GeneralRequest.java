package bih.nic.in.mines.entity;


public class GeneralRequest {

    public static Class<GeneralRequest> User_CLASS = GeneralRequest.class;



    private String s_Key;
    private String cap;
    private String id;


    public GeneralRequest(String s_Key, String cap, String id) {
        this.s_Key = s_Key;
        this.cap = cap;
        this.id = id;
    }

    public GeneralRequest() {

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
