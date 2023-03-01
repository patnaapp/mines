package bih.nic.in.mines.ui.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import bih.nic.in.mines.R;
import bih.nic.in.mines.databasehelper.DataBaseHelper;

public class CustomDialogForgotPasswordClass extends Dialog implements
        View.OnClickListener {

    public Activity c;
    public Dialog d;
    DataBaseHelper dataBaseHelper;
    ProgressDialog progressDialog;

    public CustomDialogForgotPasswordClass(Activity a) {
        super(a);
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_forgot_password);


        dataBaseHelper = new DataBaseHelper(getContext());

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {

            default:
                break;
        }
        dismiss();
    }


}
