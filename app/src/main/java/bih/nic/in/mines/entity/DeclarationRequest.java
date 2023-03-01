package bih.nic.in.mines.entity;


public class DeclarationRequest {

    public static Class<DeclarationRequest> User_CLASS = DeclarationRequest.class;



    private String s_Key;
    private String cap;


    public DeclarationRequest(String s_Key, String cap) {
        this.s_Key = s_Key;
        this.cap = cap;
    }

    public DeclarationRequest() {

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

}
