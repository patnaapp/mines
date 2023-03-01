package bih.nic.in.mines.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VeichleNoDetailsEntity {

    @SerializedName("IsChallanDoc")
    @Expose
    private String isChallanDoc;

    @SerializedName("StautsMessage")
    @Expose
    private String stautsMessage;

    @SerializedName("Rc_regn_no")
    @Expose
    private String rc_regn_no;

    @SerializedName("Rc_regn_no_enc")
    @Expose
    private String rc_regn_no_enc;

    @SerializedName("Rc_regn_dt")
    @Expose
    private String rc_regn_dt;

    @SerializedName("Rc_owner_name")
    @Expose
    private String rc_owner_name;

    @SerializedName("Rc_f_name")
    @Expose
    private String rc_f_name;

    @SerializedName("Rc_present_address")
    @Expose
    private String rc_present_address;

    @SerializedName("Rc_permanent_address")
    @Expose
    private String rc_permanent_address;

    @SerializedName("Rc_vch_catg")
    @Expose
    private String rc_vch_catg;

    @SerializedName("Rc_vh_class_desc")
    @Expose
    private String rc_vh_class_desc;

    @SerializedName("Rc_chasi_no")
    @Expose
    private String rc_chasi_no;

    @SerializedName("Rc_eng_no")
    @Expose
    private String rc_eng_no;

    @SerializedName("Rc_maker_desc")
    @Expose
    private String rc_maker_desc;

    @SerializedName("Rc_maker_model")
    @Expose
    private String rc_maker_model;

    @SerializedName("Rc_fuel_desc")
    @Expose
    private String rc_fuel_desc;

    @SerializedName("Rc_fit_upto")
    @Expose
    private String rc_fit_upto;

    @SerializedName("Rc_tax_upto")
    @Expose
    private String rc_tax_upto;

    @SerializedName("Rc_unld_wt")
    @Expose
    private String rc_unld_wt;

    @SerializedName("Rc_gvw")
    @Expose
    private String rc_gvw;

    @SerializedName("Rc_registered_at")
    @Expose
    private String rc_registered_at;

    @SerializedName("Rc_status_as_on")
    @Expose
    private String rc_status_as_on;

    @SerializedName("Rc_status")
    @Expose
    private String rc_status;

    @SerializedName("Rc_vh_class")
    @Expose
    private String rc_vh_class;

    @SerializedName("Rc_insurance_upto")
    @Expose
    private String rc_insurance_upto;

    @SerializedName("Rc_permit_no")
    @Expose
    private String rc_permit_no;

    @SerializedName("Rc_permit_issue_dt")
    @Expose
    private String rc_permit_issue_dt;

    @SerializedName("Rc_permit_valid_from")
    @Expose
    private String rc_permit_valid_from;

    @SerializedName("Rc_permit_valid_upto")
    @Expose
    private String rc_permit_valid_upto;

    @SerializedName("Rc_permit_type")
    @Expose
    private String rc_permit_type;

    public VeichleNoDetailsEntity() {
    }

    public VeichleNoDetailsEntity(String isChallanDoc, String stautsMessage, String rc_regn_no, String rc_regn_no_enc, String rc_regn_dt, String rc_owner_name, String rc_f_name, String rc_present_address, String rc_permanent_address, String rc_vch_catg, String rc_vh_class_desc, String rc_chasi_no, String rc_eng_no, String rc_maker_desc, String rc_maker_model, String rc_fuel_desc, String rc_fit_upto, String rc_tax_upto, String rc_unld_wt, String rc_gvw, String rc_registered_at, String rc_status_as_on, String rc_status, String rc_vh_class, String rc_insurance_upto, String rc_permit_no, String rc_permit_issue_dt, String rc_permit_valid_from, String rc_permit_valid_upto, String rc_permit_type) {
        this.isChallanDoc = isChallanDoc;
        this.stautsMessage = stautsMessage;
        this.rc_regn_no = rc_regn_no;
        this.rc_regn_no_enc = rc_regn_no_enc;
        this.rc_regn_dt = rc_regn_dt;
        this.rc_owner_name = rc_owner_name;
        this.rc_f_name = rc_f_name;
        this.rc_present_address = rc_present_address;
        this.rc_permanent_address = rc_permanent_address;
        this.rc_vch_catg = rc_vch_catg;
        this.rc_vh_class_desc = rc_vh_class_desc;
        this.rc_chasi_no = rc_chasi_no;
        this.rc_eng_no = rc_eng_no;
        this.rc_maker_desc = rc_maker_desc;
        this.rc_maker_model = rc_maker_model;
        this.rc_fuel_desc = rc_fuel_desc;
        this.rc_fit_upto = rc_fit_upto;
        this.rc_tax_upto = rc_tax_upto;
        this.rc_unld_wt = rc_unld_wt;
        this.rc_gvw = rc_gvw;
        this.rc_registered_at = rc_registered_at;
        this.rc_status_as_on = rc_status_as_on;
        this.rc_status = rc_status;
        this.rc_vh_class = rc_vh_class;
        this.rc_insurance_upto = rc_insurance_upto;
        this.rc_permit_no = rc_permit_no;
        this.rc_permit_issue_dt = rc_permit_issue_dt;
        this.rc_permit_valid_from = rc_permit_valid_from;
        this.rc_permit_valid_upto = rc_permit_valid_upto;
        this.rc_permit_type = rc_permit_type;
    }

    public String getIsChallanDoc() {
        return isChallanDoc;
    }

    public void setIsChallanDoc(String isChallanDoc) {
        this.isChallanDoc = isChallanDoc;
    }

    public String getStautsMessage() {
        return stautsMessage;
    }

    public void setStautsMessage(String stautsMessage) {
        this.stautsMessage = stautsMessage;
    }

    public String getRc_regn_no() {
        return rc_regn_no;
    }

    public void setRc_regn_no(String rc_regn_no) {
        this.rc_regn_no = rc_regn_no;
    }

    public String getRc_regn_no_enc() {
        return rc_regn_no_enc;
    }

    public void setRc_regn_no_enc(String rc_regn_no_enc) {
        this.rc_regn_no_enc = rc_regn_no_enc;
    }

    public String getRc_regn_dt() {
        return rc_regn_dt;
    }

    public void setRc_regn_dt(String rc_regn_dt) {
        this.rc_regn_dt = rc_regn_dt;
    }

    public String getRc_owner_name() {
        return rc_owner_name;
    }

    public void setRc_owner_name(String rc_owner_name) {
        this.rc_owner_name = rc_owner_name;
    }

    public String getRc_f_name() {
        return rc_f_name;
    }

    public void setRc_f_name(String rc_f_name) {
        this.rc_f_name = rc_f_name;
    }

    public String getRc_present_address() {
        return rc_present_address;
    }

    public void setRc_present_address(String rc_present_address) {
        this.rc_present_address = rc_present_address;
    }

    public String getRc_permanent_address() {
        return rc_permanent_address;
    }

    public void setRc_permanent_address(String rc_permanent_address) {
        this.rc_permanent_address = rc_permanent_address;
    }

    public String getRc_vch_catg() {
        return rc_vch_catg;
    }

    public void setRc_vch_catg(String rc_vch_catg) {
        this.rc_vch_catg = rc_vch_catg;
    }

    public String getRc_vh_class_desc() {
        return rc_vh_class_desc;
    }

    public void setRc_vh_class_desc(String rc_vh_class_desc) {
        this.rc_vh_class_desc = rc_vh_class_desc;
    }

    public String getRc_chasi_no() {
        return rc_chasi_no;
    }

    public void setRc_chasi_no(String rc_chasi_no) {
        this.rc_chasi_no = rc_chasi_no;
    }

    public String getRc_eng_no() {
        return rc_eng_no;
    }

    public void setRc_eng_no(String rc_eng_no) {
        this.rc_eng_no = rc_eng_no;
    }

    public String getRc_maker_desc() {
        return rc_maker_desc;
    }

    public void setRc_maker_desc(String rc_maker_desc) {
        this.rc_maker_desc = rc_maker_desc;
    }

    public String getRc_maker_model() {
        return rc_maker_model;
    }

    public void setRc_maker_model(String rc_maker_model) {
        this.rc_maker_model = rc_maker_model;
    }

    public String getRc_fuel_desc() {
        return rc_fuel_desc;
    }

    public void setRc_fuel_desc(String rc_fuel_desc) {
        this.rc_fuel_desc = rc_fuel_desc;
    }

    public String getRc_fit_upto() {
        return rc_fit_upto;
    }

    public void setRc_fit_upto(String rc_fit_upto) {
        this.rc_fit_upto = rc_fit_upto;
    }

    public String getRc_tax_upto() {
        return rc_tax_upto;
    }

    public void setRc_tax_upto(String rc_tax_upto) {
        this.rc_tax_upto = rc_tax_upto;
    }

    public String getRc_unld_wt() {
        return rc_unld_wt;
    }

    public void setRc_unld_wt(String rc_unld_wt) {
        this.rc_unld_wt = rc_unld_wt;
    }

    public String getRc_gvw() {
        return rc_gvw;
    }

    public void setRc_gvw(String rc_gvw) {
        this.rc_gvw = rc_gvw;
    }

    public String getRc_registered_at() {
        return rc_registered_at;
    }

    public void setRc_registered_at(String rc_registered_at) {
        this.rc_registered_at = rc_registered_at;
    }

    public String getRc_status_as_on() {
        return rc_status_as_on;
    }

    public void setRc_status_as_on(String rc_status_as_on) {
        this.rc_status_as_on = rc_status_as_on;
    }

    public String getRc_status() {
        return rc_status;
    }

    public void setRc_status(String rc_status) {
        this.rc_status = rc_status;
    }

    public String getRc_vh_class() {
        return rc_vh_class;
    }

    public void setRc_vh_class(String rc_vh_class) {
        this.rc_vh_class = rc_vh_class;
    }

    public String getRc_insurance_upto() {
        return rc_insurance_upto;
    }

    public void setRc_insurance_upto(String rc_insurance_upto) {
        this.rc_insurance_upto = rc_insurance_upto;
    }

    public String getRc_permit_no() {
        return rc_permit_no;
    }

    public void setRc_permit_no(String rc_permit_no) {
        this.rc_permit_no = rc_permit_no;
    }

    public String getRc_permit_issue_dt() {
        return rc_permit_issue_dt;
    }

    public void setRc_permit_issue_dt(String rc_permit_issue_dt) {
        this.rc_permit_issue_dt = rc_permit_issue_dt;
    }

    public String getRc_permit_valid_from() {
        return rc_permit_valid_from;
    }

    public void setRc_permit_valid_from(String rc_permit_valid_from) {
        this.rc_permit_valid_from = rc_permit_valid_from;
    }

    public String getRc_permit_valid_upto() {
        return rc_permit_valid_upto;
    }

    public void setRc_permit_valid_upto(String rc_permit_valid_upto) {
        this.rc_permit_valid_upto = rc_permit_valid_upto;
    }

    public String getRc_permit_type() {
        return rc_permit_type;
    }

    public void setRc_permit_type(String rc_permit_type) {
        this.rc_permit_type = rc_permit_type;
    }
}
