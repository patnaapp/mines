package bih.nic.in.mines.entity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import bih.nic.in.mines.security.Encriptor;
import bih.nic.in.mines.utilities.CommonPref;


public class UserLogin {

    public static Class<UserLogin> User_CLASS = UserLogin.class;
    @SerializedName("Id")
    @Expose
    private String id;

    @SerializedName("UserId")
    @Expose
    private  String userId;

    @SerializedName("UserName")
    @Expose
    private String userName;

    @SerializedName("DesigId")
    @Expose
    private String desigId;

    @SerializedName("DesigName")
    @Expose
    private String desigName;

    @SerializedName("DeptId")
    @Expose
    private String deptId;


    @SerializedName("DeptName")
    @Expose
    private String deptName;

    @SerializedName("DMO_Id")
    @Expose
    private String dMO_Id;

    @SerializedName("DMO_Name")
    @Expose
    private String dMO_Name;

    @SerializedName("Contact")
    @Expose
    private String contact;

    @SerializedName("Mail_Id")
    @Expose
    private String mail_Id;


    @SerializedName("IsNewUser")
    @Expose
    private String isNewUser;

    @SerializedName("NewUserType")
    @Expose
    private String newUserType;

    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("IsAuthenticated")
    @Expose
    private String isAuthenticated;

    @SerializedName("Token")
    @Expose
    private String token;

    @SerializedName("S_Key")
    @Expose
    private String s_Key;

    @SerializedName("Cap")
    @Expose
    private String cap;


    private String password;
    Encriptor _encrptor;


    public UserLogin() {

    }

    public UserLogin(String _skey, String _cap, String _UserID, String _Password) {
        s_Key = _skey;
        cap = _cap;
        userId = _UserID;
        password = _Password;
    }

    public UserLogin(String id, String userId, String userName, String desigId, String desigName, String deptId, String deptName, String dMO_Id, String dMO_Name, String contact, String mail_Id, String isNewUser, String newUserType, String message, String isAuthenticated, String token, String s_Key, String cap, String password) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.desigId = desigId;
        this.desigName = desigName;
        this.deptId = deptId;
        this.deptName = deptName;
        this.dMO_Id = dMO_Id;
        this.dMO_Name = dMO_Name;
        this.contact = contact;
        this.mail_Id = mail_Id;
        this.isNewUser = isNewUser;
        this.newUserType = newUserType;
        this.message = message;
        this.isAuthenticated = isAuthenticated;
        this.token = token;
        this.s_Key = s_Key;
        this.cap = cap;
        this.password = password;
    }

    /*public UserLogin(UserLogin obj) {
        _encrptor = new Encriptor();

        try {
            this.s_Key = _encrptor.Decrypt(obj.getS_Key(), CommonPref.CIPER_KEY);
            this.IsAuthenticated = _encrptor.Decrypt(obj.getIsAuthenticated(), skey);
            this.setUserID(_encrptor.Decrypt(obj.getUserID(), skey));
            this.setPassword(_encrptor.Decrypt(obj.getPassword(), skey));
            this.setRole_Id(_encrptor.Decrypt(obj.getRole_Id(), skey));
            this.setUser_Name(_encrptor.Decrypt(obj.getUser_Name(), skey));
            this.setDist_Code(_encrptor.Decrypt(obj.getDist_Code(), skey));
            this.setDist_Name(_encrptor.Decrypt(obj.getDist_Name(), skey));
            this.setMobileNo(_encrptor.Decrypt(obj.getMobileNo(), skey));
            this.setMail_Id(_encrptor.Decrypt(obj.getMail_Id(), skey));
            this.setDesignation(_encrptor.Decrypt(obj.getDesignation(), skey));
            this.setIsNewUser(_encrptor.Decrypt(obj.getIsNewUser(), skey));
            this.setIsLocked(_encrptor.Decrypt(obj.getIsLocked(), skey));
            this.setSkey(_encrptor.Decrypt(obj.getSkey(), skey));
            this.setCap(_encrptor.Decrypt(obj.getCap(), skey));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public UserLogin(UserLogin obj) {
        _encrptor = new Encriptor();

        try {
            this.s_Key = _encrptor.Decrypt(obj.getS_Key(), CommonPref.CIPER_KEY);
            this.cap = (_encrptor.Decrypt(obj.getCap(), s_Key));
            this.id = obj.getId();
            this.userId = obj.getUserId();
            this.userName = obj.getUserName();
            this.desigId = obj.getDesigId();
            this.desigName = obj.getDesigName();
            this.deptId = obj.getDeptId();
            this.deptName = obj.getDeptName();
            this.dMO_Id = obj.getdMO_Id();
            this.dMO_Name = obj.getdMO_Name();
            this.contact = obj.getContact();
            this.mail_Id = obj.getMail_Id();
            this.isNewUser = obj.getIsNewUser();
            this.newUserType = obj.getNewUserType();
            this.message = obj.getMessage();
            this.isAuthenticated = obj.getIsAuthenticated();
            this.token = obj.getToken();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesigId() {
        return desigId;
    }

    public void setDesigId(String desigId) {
        this.desigId = desigId;
    }

    public String getDesigName() {
        return desigName;
    }

    public void setDesigName(String desigName) {
        this.desigName = desigName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getdMO_Id() {
        return dMO_Id;
    }

    public void setdMO_Id(String dMO_Id) {
        this.dMO_Id = dMO_Id;
    }

    public String getdMO_Name() {
        return dMO_Name;
    }

    public void setdMO_Name(String dMO_Name) {
        this.dMO_Name = dMO_Name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMail_Id() {
        return mail_Id;
    }

    public void setMail_Id(String mail_Id) {
        this.mail_Id = mail_Id;
    }

    public String getIsNewUser() {
        return isNewUser;
    }

    public void setIsNewUser(String isNewUser) {
        this.isNewUser = isNewUser;
    }

    public String getNewUserType() {
        return newUserType;
    }

    public void setNewUserType(String newUserType) {
        this.newUserType = newUserType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(String isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
