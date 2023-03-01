package bih.nic.in.mines.utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.text.Html;

import bih.nic.in.mines.R;
import bih.nic.in.mines.ui.interfaces.CommonFunction;


public class UtilitiesAlertMessasge {

    public UtilitiesAlertMessasge() {
        // TODO Auto-generated constructor stub
    }
    public static void showInternetAlert(final Context context){

        AlertDialog.Builder ab = new AlertDialog.Builder(context);
        ab.setCancelable(false);
        ab.setTitle(Html.fromHtml("<font color = '#FF4B4B' ><b>" + "Alert!!" + "</b></font>"));
        ab.setMessage("Your Internet is not working, Kindly check your internet connection");
        ab.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                        GlobalVariables.isOffline = false;
                        Intent I = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                        context.startActivity(I);
                    }
                });
        ab.create().getWindow().getAttributes().windowAnimations = R.style.AppTheme;
        ab.show();
    }

    public static void showAlertMessage(final Context context, String message){

        AlertDialog.Builder ab = new AlertDialog.Builder(context);
        ab.setCancelable(false);
        ab.setTitle(Html.fromHtml("<font color = '#FF4B4B' ><b>" + "Alert!!" + "</b></font>"));
        ab.setMessage(message);
        ab.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int whichButton) {
                    }
                });
        ab.create().getWindow().getAttributes().windowAnimations = R.style.AppTheme;
        ab.show();
    }

    public static void showErrorAlet(final Context context, String title, String message) {

        AlertDialog.Builder ab = new AlertDialog.Builder(context);
        ab.setCancelable(false);
        ab.setTitle(title);
        ab.setMessage(message);
        ab.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog,int whichButton)
            {
                dialog.dismiss();
                // context.finish();
            }
        });

        ab.create().getWindow().getAttributes().windowAnimations = R.style.AppTheme;

        ab.show();
    }

    public static void ShowMessage(Context context, String Title, String Message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(Title);
        alertDialog.setMessage(Message);
        alertDialog.show();
    }

    public static void checkAndshowIntenetAlert(final Context context, CommonFunction commonFunction){
        if (!Utilities.isOnline(context)) {
            AlertDialog.Builder ab = new AlertDialog.Builder(context);
            ab.setCancelable(false);
            ab.setTitle(Html.fromHtml("<font color = '#FF4B4B' ><b>" + "!! Alert !!" + "</b></font>"));
            ab.setMessage(Html.fromHtml("<font color=#000000> Internet connection not available... \n Kindly enable network connection </font>"));
            ab.setPositiveButton("Enable network connection", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int whichButton) {
                    Intent I = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                    context.startActivity(I);
                }
            });
            ab.setNegativeButton("Stay offline", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int whichButton) {
                    commonFunction.doOffline();
                }
            });
            ab.show();
        }else{
            commonFunction.doOnLine();
        }
    }
}


