package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllotmentDetailsEntity {

    @SerializedName("IsLesseeReturn")
    @Expose
    private boolean isLesseeReturn;

    @SerializedName("Mineral_Id")
    @Expose
    private String mineral_Id;

    @SerializedName("MineralName")
    @Expose
    private String mineralName;

    @SerializedName("PermitValidity")
    @Expose
    private String permitValidity;

    @SerializedName("PermittedQty")
    @Expose
    private String permittedQty;

    @SerializedName("Unit")
    @Expose
    private String unit;

    @SerializedName("Destination")
    @Expose
    private String destination;

    @SerializedName("LandMark")
    @Expose
    private String landMark;

    @SerializedName("ConsingeeName")
    @Expose
    private String consingeeName;

    @SerializedName("ConsigneeMobileNo")
    @Expose
    private String consigneeMobileNo;

    @SerializedName("ConsigneePinCode")
    @Expose
    private String consigneePinCode;

    @SerializedName("RetailorName")
    @Expose
    private String retailorName;

    @SerializedName("RetaiolorMobileNo")
    @Expose
    private String retaiolorMobileNo;

    @SerializedName("RetailorEmail")
    @Expose
    private String retailorEmail;

    @SerializedName("StackNo")
    @Expose
    private String stackNo;

    @SerializedName("MineralTypeId")
    @Expose
    private String mineralTypeId;

    @SerializedName("MineralType")
    @Expose
    private String mineralType;

    @SerializedName("Grade")
    @Expose
    private String grade;

    @SerializedName("MineralSizeId")
    @Expose
    private String mineralSizeId;

    @SerializedName("MineralSizeName")
    @Expose
    private String mineralSizeName;

    @SerializedName("AllowedQty")
    @Expose
    private String allowedQty;

    @SerializedName("AvailableQty")
    @Expose
    private String availableQty;

    @SerializedName("ChallanValidUpTo")
    @Expose
    private String challanValidUpTo;

    @SerializedName("Sale")
    @Expose
    private String sale;

    @SerializedName("GpsCordinate")
    @Expose
    private String gpsCordinate;

    @SerializedName("BsmCStatus")
    @Expose
    private String bsmCStatus;

    @SerializedName("ExportStatus")
    @Expose
    private String exportStatus;

    @SerializedName("StateId")
    @Expose
    private String stateId;

    @SerializedName("ETax")
    @Expose
    private String eTax;

    @SerializedName("BTax")
    @Expose
    private String bTax;

    @SerializedName("DistrictId")
    @Expose
    private String districtId;

    @SerializedName("BlockId")
    @Expose
    private String blockId;

    @SerializedName("PoliceId")
    @Expose
    private String policeId;

    @SerializedName("UniqueId")
    @Expose
    private String uniqueId;

    public AllotmentDetailsEntity() {
    }

    public AllotmentDetailsEntity(boolean isLesseeReturn, String mineral_Id, String mineralName, String permitValidity, String permittedQty, String unit, String destination, String landMark, String consingeeName, String consigneeMobileNo, String consigneePinCode, String retailorName, String retaiolorMobileNo, String retailorEmail, String stackNo, String mineralTypeId, String mineralType, String grade, String mineralSizeId, String mineralSizeName, String allowedQty, String availableQty, String challanValidUpTo, String sale, String gpsCordinate, String bsmCStatus, String exportStatus, String stateId, String eTax, String bTax, String districtId, String blockId, String policeId, String uniqueId) {
        this.isLesseeReturn = isLesseeReturn;
        this.mineral_Id = mineral_Id;
        this.mineralName = mineralName;
        this.permitValidity = permitValidity;
        this.permittedQty = permittedQty;
        this.unit = unit;
        this.destination = destination;
        this.landMark = landMark;
        this.consingeeName = consingeeName;
        this.consigneeMobileNo = consigneeMobileNo;
        this.consigneePinCode = consigneePinCode;
        this.retailorName = retailorName;
        this.retaiolorMobileNo = retaiolorMobileNo;
        this.retailorEmail = retailorEmail;
        this.stackNo = stackNo;
        this.mineralTypeId = mineralTypeId;
        this.mineralType = mineralType;
        this.grade = grade;
        this.mineralSizeId = mineralSizeId;
        this.mineralSizeName = mineralSizeName;
        this.allowedQty = allowedQty;
        this.availableQty = availableQty;
        this.challanValidUpTo = challanValidUpTo;
        this.sale = sale;
        this.gpsCordinate = gpsCordinate;
        this.bsmCStatus = bsmCStatus;
        this.exportStatus = exportStatus;
        this.stateId = stateId;
        this.eTax = eTax;
        this.bTax = bTax;
        this.districtId = districtId;
        this.blockId = blockId;
        this.policeId = policeId;
        this.uniqueId = uniqueId;
    }

    public boolean isLesseeReturn() {
        return isLesseeReturn;
    }

    public void setLesseeReturn(boolean lesseeReturn) {
        isLesseeReturn = lesseeReturn;
    }

    public String getMineral_Id() {
        return mineral_Id;
    }

    public void setMineral_Id(String mineral_Id) {
        this.mineral_Id = mineral_Id;
    }

    public String getMineralName() {
        return mineralName;
    }

    public void setMineralName(String mineralName) {
        this.mineralName = mineralName;
    }

    public String getPermitValidity() {
        return permitValidity;
    }

    public void setPermitValidity(String permitValidity) {
        this.permitValidity = permitValidity;
    }

    public String getPermittedQty() {
        return permittedQty;
    }

    public void setPermittedQty(String permittedQty) {
        this.permittedQty = permittedQty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getConsingeeName() {
        return consingeeName;
    }

    public void setConsingeeName(String consingeeName) {
        this.consingeeName = consingeeName;
    }

    public String getConsigneeMobileNo() {
        return consigneeMobileNo;
    }

    public void setConsigneeMobileNo(String consigneeMobileNo) {
        this.consigneeMobileNo = consigneeMobileNo;
    }

    public String getConsigneePinCode() {
        return consigneePinCode;
    }

    public void setConsigneePinCode(String consigneePinCode) {
        this.consigneePinCode = consigneePinCode;
    }

    public String getRetailorName() {
        return retailorName;
    }

    public void setRetailorName(String retailorName) {
        this.retailorName = retailorName;
    }

    public String getRetaiolorMobileNo() {
        return retaiolorMobileNo;
    }

    public void setRetaiolorMobileNo(String retaiolorMobileNo) {
        this.retaiolorMobileNo = retaiolorMobileNo;
    }

    public String getRetailorEmail() {
        return retailorEmail;
    }

    public void setRetailorEmail(String retailorEmail) {
        this.retailorEmail = retailorEmail;
    }

    public String getStackNo() {
        return stackNo;
    }

    public void setStackNo(String stackNo) {
        this.stackNo = stackNo;
    }

    public String getMineralTypeId() {
        return mineralTypeId;
    }

    public void setMineralTypeId(String mineralTypeId) {
        this.mineralTypeId = mineralTypeId;
    }

    public String getMineralType() {
        return mineralType;
    }

    public void setMineralType(String mineralType) {
        this.mineralType = mineralType;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMineralSizeId() {
        return mineralSizeId;
    }

    public void setMineralSizeId(String mineralSizeId) {
        this.mineralSizeId = mineralSizeId;
    }

    public String getMineralSizeName() {
        return mineralSizeName;
    }

    public void setMineralSizeName(String mineralSizeName) {
        this.mineralSizeName = mineralSizeName;
    }

    public String getAllowedQty() {
        return allowedQty;
    }

    public void setAllowedQty(String allowedQty) {
        this.allowedQty = allowedQty;
    }

    public String getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(String availableQty) {
        this.availableQty = availableQty;
    }

    public String getChallanValidUpTo() {
        return challanValidUpTo;
    }

    public void setChallanValidUpTo(String challanValidUpTo) {
        this.challanValidUpTo = challanValidUpTo;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getGpsCordinate() {
        return gpsCordinate;
    }

    public void setGpsCordinate(String gpsCordinate) {
        this.gpsCordinate = gpsCordinate;
    }

    public String getBsmCStatus() {
        return bsmCStatus;
    }

    public void setBsmCStatus(String bsmCStatus) {
        this.bsmCStatus = bsmCStatus;
    }

    public String getExportStatus() {
        return exportStatus;
    }

    public void setExportStatus(String exportStatus) {
        this.exportStatus = exportStatus;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String geteTax() {
        return eTax;
    }

    public void seteTax(String eTax) {
        this.eTax = eTax;
    }

    public String getbTax() {
        return bTax;
    }

    public void setbTax(String bTax) {
        this.bTax = bTax;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
