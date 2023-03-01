package bih.nic.in.mines.entity;


public class AllotmentDetailsRequest {

    public static Class<AllotmentDetailsRequest> User_CLASS = AllotmentDetailsRequest.class;




    private String s_Key;
    private String cap;
    private String permitNo;
    private String userId;
    private String userType;
    private String endUserType;
    private String endUserID;
    private String dMOID;

    public AllotmentDetailsRequest() {

    }

    public AllotmentDetailsRequest(String s_Key, String cap, String permitNo, String userId, String userType, String endUserType, String endUserID, String dMOID) {
        this.s_Key = s_Key;
        this.cap = cap;
        this.permitNo = permitNo;
        this.userId = userId;
        this.userType = userType;
        this.endUserType = endUserType;
        this.endUserID = endUserID;
        this.dMOID = dMOID;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEndUserType() {
        return endUserType;
    }

    public void setEndUserType(String endUserType) {
        this.endUserType = endUserType;
    }

    public String getEndUserID() {
        return endUserID;
    }

    public void setEndUserID(String endUserID) {
        this.endUserID = endUserID;
    }

    public String getdMOID() {
        return dMOID;
    }

    public void setdMOID(String dMOID) {
        this.dMOID = dMOID;
    }
}
