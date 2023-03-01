package bih.nic.in.mines.ui.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.io.IOException;

import bih.nic.in.mines.R;
import bih.nic.in.mines.api.ApiCall;
import bih.nic.in.mines.databasehelper.DataBaseHelper;
import bih.nic.in.mines.entity.UserLogin;
import bih.nic.in.mines.security.Encriptor;
import bih.nic.in.mines.security.RandomString;
import bih.nic.in.mines.ui.dialog.CustomDialogForgotPasswordClass;
import bih.nic.in.mines.utilities.CommonPref;
import bih.nic.in.mines.utilities.GlobalVariables;
import bih.nic.in.mines.utilities.Utilities;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends Activity {
    DataBaseHelper databaseHelper;
    EditText et_username, et_password;
    TextView tv_app_ver,tv_forgot_Password;
    Button btn_Log_In;

    Encriptor encriptor;
    String _capId = "";
    String _skey = "";
    String username = "", password = "", _encUserId = "", _encPassword = "";
    ProgressDialog progressBar;
    ProgressDialog dialog;
    ProgressDialog dialogNew;
    CustomDialogForgotPasswordClass customDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dialog = new ProgressDialog(LoginActivity.this);
        this.dialog.setCanceledOnTouchOutside(false);
        this.dialog.setMessage(getResources().getString(R.string.authenticating));

        dialogNew = new ProgressDialog(LoginActivity.this);
        this.dialogNew.setCanceledOnTouchOutside(false);

        initialization();


        progressBar = new ProgressDialog(LoginActivity.this);
        progressBar.setMessage("Please wait :) ");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setIndeterminate(true);

        databaseHelper = new DataBaseHelper(getApplicationContext());

        encriptor = new Encriptor();
        try {
            databaseHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        try {
            databaseHelper.openDataBase();
        } catch (SQLException sqle) {
            //throw sqle;
            throw new Error("Unable to open database :" + sqle);


        }

        btn_Log_In.setOnClickListener(view -> {
            username = et_username.getText().toString();
            password = et_password.getText().toString();
            if (username.length() == 0) {
                Toast.makeText(getApplicationContext(), "Please Enter User Id", Toast.LENGTH_LONG).show();

            } else if (password.length() == 0) {
                Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
            } else {
                getLogin(username, password);
                //start();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void initialization() {
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_Log_In = findViewById(R.id.btn_login);
        tv_app_ver = findViewById(R.id.tv_app_ver);
        tv_forgot_Password = findViewById(R.id.tv_forgot_Password);

        tv_app_ver.setText("App Version : " + Utilities.getAppVersion(getApplicationContext()));
        setOnclicklistner(tv_forgot_Password);
    }

    private void getLogin(String username, String password) {
        dialog.show();
        encriptor = new Encriptor();
        try {
            String randomNo = Utilities.getTimeStamp();
            String capId = RandomString.randomAlphaNumeric(8);
            _encUserId = encriptor.Encrypt(username, randomNo);
            _encPassword = encriptor.Encrypt(password, randomNo);

            _capId = encriptor.Encrypt(capId, randomNo);
            _skey = encriptor.Encrypt(randomNo, CommonPref.CIPER_KEY);


        } catch (Exception e) {
            e.printStackTrace();
        }

        UserLogin userLogin = new UserLogin(_skey, _capId, _encUserId, _encPassword);

        Call<UserLogin> call = ApiCall.getSeervice().getUserLogin(userLogin);
        call.enqueue(new Callback<UserLogin>() {
            @Override
            public void onResponse(@NonNull Call<UserLogin> call, @NonNull Response<UserLogin> response) {
                Log.d("RESPONSE: ", "" + response);
                UserLogin user = new UserLogin(response.body());
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (response.code() == 200) {

                    try {
                        assert response.body() != null;
                        //String skey = encriptor.Decrypt(response.body().getSkey(), CommonPref.CIPER_KEY);

                        if (user.getIsAuthenticated().equalsIgnoreCase("Y")) {

                            GlobalVariables.LoggedUser = user;
                            GlobalVariables.LoggedUser.setUserId(et_username.getText().toString().trim().toLowerCase());
                            GlobalVariables.LoggedUser.setPassword(et_password.getText().toString().trim());
                            CommonPref.setUserDetails(getApplicationContext(), GlobalVariables.LoggedUser);
                            //GetControl_details();
                            start();

                        } else {
                            Toast.makeText(LoginActivity.this, getResources().getString(R.string.authentication_failed), Toast.LENGTH_SHORT).show();


                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserLogin> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void start() {
        Intent iUserHome = new Intent(getApplicationContext(), MainActivity.class);
        iUserHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(iUserHome);
        finish();
    }

    private void setOnclicklistner(TextView onclicklistner) {
        onclicklistner.setOnClickListener(view -> {
            customDialog = new CustomDialogForgotPasswordClass(this);
            customDialog.setCanceledOnTouchOutside(false);
            customDialog.show();
        });
    }
}