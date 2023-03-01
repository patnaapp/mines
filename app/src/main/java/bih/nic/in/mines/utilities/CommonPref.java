package bih.nic.in.mines.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import bih.nic.in.mines.entity.UserLogin;


public class CommonPref {

    public static final String CIPHER_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    public static final String CIPER_KEY ="DGRC@NIC2020";

    // Local Url
   /* public static final String SERVICENAMESPACE = "http://10.133.20.196:8085/";
    public static final String SERVICEURL="http://10.133.20.196:8085/PMSNewWebService.asmx";
    *///Server Url

    public static final String SERVICENAMESPACE = "http://pmsonline.bih.nic.in/";
    public static final String SERVICEURL="http://pmsonline.bih.nic.in/pmsedu/PMSNewwebservice.asmx";

    private SharedPreferences mSharedPreferences;
    AppCompatActivity activity;
    private Context context;

    public CommonPref(Context context) {
        this.context = context;
        activity = (AppCompatActivity) context;
        mSharedPreferences = context.getSharedPreferences(GlobalVariables.SHARED_PREFERENCE_STRING, Context.MODE_PRIVATE);
    }


    public static void setUserDetails(Context context, UserLogin userInfo) {

        String key = "_USER_DETAILS";

        SharedPreferences prefs = context.getSharedPreferences(key,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("ID", userInfo.getId());
        editor.putString("UserID", userInfo.getUserId());
        editor.putString("Password", userInfo.getPassword());
        editor.putString("userName", userInfo.getUserName());
        editor.putString("desigId", userInfo.getDesigId());
        editor.putString("desigName", userInfo.getDesigName());
        editor.putString("deptId", userInfo.getDeptId());
        editor.putString("deptName", userInfo.getDeptName());
        editor.putString("dMO_Id", userInfo.getdMO_Id());
        editor.putString("dMO_Name", userInfo.getdMO_Name());
        editor.putString("contact", userInfo.getContact());
        editor.putString("mail_Id", userInfo.getMail_Id());
        editor.putString("isNewUser", userInfo.getIsNewUser());
        editor.putString("newUserType", userInfo.getNewUserType());
        editor.putString("isAuthenticated", userInfo.getIsAuthenticated());
        editor.putString("Token", userInfo.getToken());
        editor.putString("skey", userInfo.getS_Key());
        editor.putString("cap", userInfo.getCap());

        editor.commit();

    }

    public static UserLogin getUserDetails(Context context) {

        String key = "_USER_DETAILS";
        UserLogin userInfo = new UserLogin();
        SharedPreferences prefs = context.getSharedPreferences(key,
                Context.MODE_PRIVATE);

        userInfo.setId(prefs.getString("ID", ""));
        userInfo.setUserId(prefs.getString("UserID", ""));
        userInfo.setPassword(prefs.getString("Password", ""));
        userInfo.setUserName(prefs.getString("userName", ""));
        userInfo.setDesigId(prefs.getString("desigId", ""));
        userInfo.setDesigName(prefs.getString("desigName", ""));
        userInfo.setDeptId(prefs.getString("deptId", ""));
        userInfo.setDeptName(prefs.getString("deptName", ""));
        userInfo.setdMO_Id(prefs.getString("dMO_Id", ""));
        userInfo.setdMO_Name(prefs.getString("dMO_Name", ""));
        userInfo.setContact(prefs.getString("contact", ""));
        userInfo.setMail_Id(prefs.getString("mail_Id", ""));
        userInfo.setIsNewUser(prefs.getString("isNewUser", ""));
        userInfo.setNewUserType(prefs.getString("newUserType", ""));
        userInfo.setIsAuthenticated(prefs.getString("isAuthenticated", ""));
        userInfo.setToken(prefs.getString("Token", ""));
        userInfo.setS_Key(prefs.getString("skey", ""));
        userInfo.setCap(prefs.getString("cap", ""));

        return userInfo;
    }

    public static void setCheckUpdate(Context context, long dateTime) {
        String key = "_CheckUpdate";
        SharedPreferences prefs = context.getSharedPreferences(key,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        dateTime=dateTime+1*3600000;
        editor.putLong("LastVisitedDate", dateTime);

        editor.commit();

    }

    public static int getCheckUpdate(Context context) {
        String key = "_CheckUpdate";
        SharedPreferences prefs = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        long a = prefs.getLong("LastVisitedDate", 0);
        if(System.currentTimeMillis()>a)
            return 1;
        else
            return 0;
    }

    public static void setAwcId(Activity activity, String awcid){
        String key = "_Awcid";
        SharedPreferences prefs = activity.getSharedPreferences(key,
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("code2", awcid);
        editor.commit();
    }




    //Check for stored object in Shared Preferences
    public <T> T getStoredClass(Class<T> className, final String SHARED_PARAM) {
        String json = mSharedPreferences.getString(SHARED_PARAM, null);
        System.out.println(json == null ? null : new Gson().fromJson(json, className));
        if (!mSharedPreferences.contains(SHARED_PARAM)) return null;
        return json == null ? null : new Gson().fromJson(json, className);
    }

    public void storeUserClass(Object obj, final String SHARED_PARAM) {
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        String json = obj == null ? null : new Gson().toJson(obj);
        edit.putString(SHARED_PARAM, json).apply();
    }
    public void CLearUserDetails() {
        SharedPreferences.Editor edit = mSharedPreferences.edit();
        edit.clear();
        edit.apply();
    }

    public static void setUserRole(Context context, String role) {
        String key = "_USER_ROLE";
        SharedPreferences prefs = context.getSharedPreferences(key,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(GlobalVariables.USER_ROLE, role);
        editor.commit();
    }
    public static void ClearRole(Context context, String role) {
        String key = "_USER_ROLE";
        SharedPreferences prefs = context.getSharedPreferences(key,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(GlobalVariables.USER_ROLE, role);
        editor.clear();
        editor.apply();
    }

    public static String getUserRole(Context context) {

        String key = "_USER_ROLE";
        SharedPreferences prefs = context.getSharedPreferences(key,
                Context.MODE_PRIVATE);
        return prefs.getString(GlobalVariables.USER_ROLE, "");
    }
}
