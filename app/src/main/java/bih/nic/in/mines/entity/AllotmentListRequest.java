package bih.nic.in.mines.entity;


public class AllotmentListRequest {

    public static Class<AllotmentListRequest> User_CLASS = AllotmentListRequest.class;


    public String s_Key;
    public String cap;
    public String userId;
    public String userType;
    public String dMO_Id;
    public String endUser_Id;
    public String endUserType;

    public AllotmentListRequest() {

    }

    public AllotmentListRequest(String s_Key, String cap, String userId, String userType, String dMO_Id, String endUser_Id, String endUserType) {
        this.s_Key = s_Key;
        this.cap = cap;
        this.userId = userId;
        this.userType = userType;
        this.dMO_Id = dMO_Id;
        this.endUser_Id = endUser_Id;
        this.endUserType = endUserType;
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

    public String getdMO_Id() {
        return dMO_Id;
    }

    public void setdMO_Id(String dMO_Id) {
        this.dMO_Id = dMO_Id;
    }

    public String getEndUser_Id() {
        return endUser_Id;
    }

    public void setEndUser_Id(String endUser_Id) {
        this.endUser_Id = endUser_Id;
    }

    public String getEndUserType() {
        return endUserType;
    }

    public void setEndUserType(String endUserType) {
        this.endUserType = endUserType;
    }
}
