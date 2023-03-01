package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MiningDetailsEntity {

    @SerializedName("CircleID")
    @Expose
    private String circleID;

    @SerializedName("DmoID")
    @Expose
    private String dmoID;

    @SerializedName("DmoName")
    @Expose
    private String dmoName;

    @SerializedName("DesigID")
    @Expose
    private String desigID;

    @SerializedName("DesigName")
    @Expose
    private String desigName;

    @SerializedName("DistrictID")
    @Expose
    private String districtID;

    @SerializedName("ContactNo")
    @Expose
    private String contactNo;

    @SerializedName("SourceTypeId")
    @Expose
    private String sourceTypeId;

    @SerializedName("SourceType")
    @Expose
    private String sourceType;

    @SerializedName("LesseeId")
    @Expose
    private String lesseeId;

    @SerializedName("LesseeName")
    @Expose
    private String lesseeName;

    @SerializedName("UserTypeId")
    @Expose
    private String userTypeId;

    @SerializedName("UserType")
    @Expose
    private String userType;

    @SerializedName("DispatchPointUserId")
    @Expose
    private String dispatchPointUserId;

    @SerializedName("DispatchPointUserName")
    @Expose
    private String dispatchPointUserName;

    @SerializedName("MiningValidity")
    @Expose
    private String miningValidity;

    @SerializedName("MobileNoOfSettle")
    @Expose
    private String mobileNoOfSettle;

    @SerializedName("AnnualCapQty")
    @Expose
    private String annualCapQty;

    @SerializedName("AnnualEcapYear")
    @Expose
    private String annualEcapYear;

    @SerializedName("LesseeType")
    @Expose
    private String lesseeType;

    @SerializedName("Sts")
    @Expose
    private String sts;

    @SerializedName("Date")
    @Expose
    private String date;

    @SerializedName("Cordinate")
    @Expose
    private String cordinate;

    @SerializedName("Status")
    @Expose
    private String status;

    public MiningDetailsEntity() {
    }

    public MiningDetailsEntity(String circleID, String dmoID, String dmoName, String desigID, String desigName, String districtID, String contactNo, String sourceTypeId, String sourceType, String lesseeId, String lesseeName, String userTypeId, String userType, String dispatchPointUserId, String dispatchPointUserName, String miningValidity, String mobileNoOfSettle, String annualCapQty, String annualEcapYear, String lesseeType, String sts, String date, String cordinate, String status) {
        this.circleID = circleID;
        this.dmoID = dmoID;
        this.dmoName = dmoName;
        this.desigID = desigID;
        this.desigName = desigName;
        this.districtID = districtID;
        this.contactNo = contactNo;
        this.sourceTypeId = sourceTypeId;
        this.sourceType = sourceType;
        this.lesseeId = lesseeId;
        this.lesseeName = lesseeName;
        this.userTypeId = userTypeId;
        this.userType = userType;
        this.dispatchPointUserId = dispatchPointUserId;
        this.dispatchPointUserName = dispatchPointUserName;
        this.miningValidity = miningValidity;
        this.mobileNoOfSettle = mobileNoOfSettle;
        this.annualCapQty = annualCapQty;
        this.annualEcapYear = annualEcapYear;
        this.lesseeType = lesseeType;
        this.sts = sts;
        this.date = date;
        this.cordinate = cordinate;
        this.status = status;
    }

    public String getCircleID() {
        return circleID;
    }

    public void setCircleID(String circleID) {
        this.circleID = circleID;
    }

    public String getDmoID() {
        return dmoID;
    }

    public void setDmoID(String dmoID) {
        this.dmoID = dmoID;
    }

    public String getDmoName() {
        return dmoName;
    }

    public void setDmoName(String dmoName) {
        this.dmoName = dmoName;
    }

    public String getDesigID() {
        return desigID;
    }

    public void setDesigID(String desigID) {
        this.desigID = desigID;
    }

    public String getDesigName() {
        return desigName;
    }

    public void setDesigName(String desigName) {
        this.desigName = desigName;
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getSourceTypeId() {
        return sourceTypeId;
    }

    public void setSourceTypeId(String sourceTypeId) {
        this.sourceTypeId = sourceTypeId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(String lesseeId) {
        this.lesseeId = lesseeId;
    }

    public String getLesseeName() {
        return lesseeName;
    }

    public void setLesseeName(String lesseeName) {
        this.lesseeName = lesseeName;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDispatchPointUserId() {
        return dispatchPointUserId;
    }

    public void setDispatchPointUserId(String dispatchPointUserId) {
        this.dispatchPointUserId = dispatchPointUserId;
    }

    public String getDispatchPointUserName() {
        return dispatchPointUserName;
    }

    public void setDispatchPointUserName(String dispatchPointUserName) {
        this.dispatchPointUserName = dispatchPointUserName;
    }

    public String getMiningValidity() {
        return miningValidity;
    }

    public void setMiningValidity(String miningValidity) {
        this.miningValidity = miningValidity;
    }

    public String getMobileNoOfSettle() {
        return mobileNoOfSettle;
    }

    public void setMobileNoOfSettle(String mobileNoOfSettle) {
        this.mobileNoOfSettle = mobileNoOfSettle;
    }

    public String getAnnualCapQty() {
        return annualCapQty;
    }

    public void setAnnualCapQty(String annualCapQty) {
        this.annualCapQty = annualCapQty;
    }

    public String getAnnualEcapYear() {
        return annualEcapYear;
    }

    public void setAnnualEcapYear(String annualEcapYear) {
        this.annualEcapYear = annualEcapYear;
    }

    public String getLesseeType() {
        return lesseeType;
    }

    public void setLesseeType(String lesseeType) {
        this.lesseeType = lesseeType;
    }

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCordinate() {
        return cordinate;
    }

    public void setCordinate(String cordinate) {
        this.cordinate = cordinate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
