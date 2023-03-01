package bih.nic.in.mines.ui.activity;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.SQLException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import bih.nic.in.mines.R;
import bih.nic.in.mines.api.ApiCall;
import bih.nic.in.mines.databasehelper.DataBaseHelper;
import bih.nic.in.mines.entity.AppDetailsResponse;
import bih.nic.in.mines.entity.AppVersion;
import bih.nic.in.mines.ui.interfaces.CommonFunction;
import bih.nic.in.mines.utilities.CommonPref;
import bih.nic.in.mines.utilities.Utilities;
import bih.nic.in.mines.utilities.UtilitiesAlertMessasge;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity implements CommonFunction {
    private static final int PERMISSION_ALL = 0;
    DataBaseHelper databaseHelper;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ctx = this;
        //openOrCreateDatabase();
    }

    private void openOrCreateDatabase() {
        //Database Opening
        databaseHelper = new DataBaseHelper(SplashActivity.this);
        try {
            databaseHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            databaseHelper.openDataBase();
        } catch (SQLException sqle) {
            throw new Error("Unable to open database :" + sqle);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        int SPLASH_TIME_OUT = 1500;
        new Handler().postDelayed(this::requestRequiredPermission, SPLASH_TIME_OUT);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        int index = 0;
        Map<String, Integer> PermissionsMap = new HashMap<>();
        for (String permission : permissions) {
            PermissionsMap.put(permission, grantResults[index]);
            index++;
        }

        if (PermissionsMap.get(ACCESS_FINE_LOCATION) != null && PermissionsMap.get(CAMERA) != null && PermissionsMap.get(WRITE_EXTERNAL_STORAGE) != null) {
            if ((PermissionsMap.get(ACCESS_FINE_LOCATION) != 0) || PermissionsMap.get(ACCESS_COARSE_LOCATION) != 0 || PermissionsMap.get(CAMERA) != 0 || PermissionsMap.get(WRITE_EXTERNAL_STORAGE) != 0) {
                Toast.makeText(SplashActivity.this, "Location and Camera permissions are required", Toast.LENGTH_SHORT).show();
                requestRequiredPermission();
            } else {
                checkOnline();
            }
        } else {
            finish();
        }

    }


    private void requestRequiredPermission() {
        String[] PERMISSIONS = {ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION, CAMERA, WRITE_EXTERNAL_STORAGE,};

        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(SplashActivity.this, PERMISSIONS, PERMISSION_ALL);
        } else {
            checkOnline();
        }
    }

    public boolean hasPermissions(Context context, String... allPermissionNeeded) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && context != null && allPermissionNeeded != null)
            for (String permission : allPermissionNeeded)
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
                    return false;
        return true;
    }

    protected void checkOnline() {
        super.onResume();
        //Checking Internet and Showing Alert Message
        UtilitiesAlertMessasge.checkAndshowIntenetAlert(this,this);
    }

    public void validateAppVersion(final AppVersion versioninfo) {
        if (versioninfo != null) {
            String currentVersion = Utilities.getAppVersion(this);
            if (Double.parseDouble(versioninfo.getVersion().trim()) > Double.parseDouble(currentVersion.trim())) {
                AlertDialog.Builder ab = new AlertDialog.Builder(SplashActivity.this);
                if (versioninfo.getPriority() == 0) {
                    dothis();
                } else if (versioninfo.getPriority() == 1) {
                    ab.setTitle(versioninfo.getUpdateTitle());
                    ab.setMessage(versioninfo.getUpdateMsg());
                    ab.setPositiveButton("Update", (dialog, whichButton) -> {

                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
                        ComponentName comp = new ComponentName("com.android.vending", "com.google.android.finsky.activities.LaunchUrlHandlerActivity"); // package

                        launchIntent.setComponent(comp);
                        launchIntent.setData(Uri.parse("market://details?id=" + SplashActivity.this.getPackageName()));

                        try {
                            startActivity(launchIntent);
                            finish();
                        } catch (android.content.ActivityNotFoundException anfe) {

                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(versioninfo.getAapUrl())));
                            finish();
                        }
                        dialog.dismiss();
                    });
                    ab.setNegativeButton("Ignore", (dialog, whichButton) -> {
                        dialog.dismiss();
                        dothis();
                    });
                    ab.show();


                } else if (versioninfo.getPriority() == 2) {

                    ab.setTitle(versioninfo.getUpdateTitle());
                    ab.setMessage(versioninfo.getUpdateMsg());

                    ab.setPositiveButton("Update", (dialog, whichButton) -> {
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.vending");
                        ComponentName comp = new ComponentName("com.android.vending", "com.google.android.finsky.activities.LaunchUrlHandlerActivity"); // package

                        launchIntent.setComponent(comp);
                        launchIntent.setData(Uri.parse("market://details?id=" + SplashActivity.this.getPackageName()));

                        try {
                            startActivity(launchIntent);
                            finish();
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(versioninfo.getAapUrl())));
                            finish();
                        }

                        dialog.dismiss();
                        // finish();
                    });
                    ab.show();

                }
            } else {
                dothis();
            }
        } else {
            dothis();
        }
    }

    private void dothis() {
        if (!Utilities.isOnline(SplashActivity.this)) {
            AlertDialog.Builder ab = new AlertDialog.Builder(SplashActivity.this);
            ab.setMessage(Html.fromHtml("<font color=#000000>Internet Connection is not avaliable..Please Turn ON Network Connection </font>"));
            ab.setPositiveButton("Turn On Network Connection", (dialog, whichButton) -> {
                Intent I = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                startActivity(I);
            });

            ab.create();
            ab.show();
        } else {
            start();
        }
    }

    private void start() {
        final Handler handler = new Handler();
        handler.postDelayed(() -> {

            String userid = CommonPref.getUserDetails(SplashActivity.this).getUserId();
            String isAuthenticate = CommonPref.getUserDetails(SplashActivity.this).getIsAuthenticated();
            String password = CommonPref.getUserDetails(SplashActivity.this).getPassword();
            if(!isAuthenticate.equalsIgnoreCase("Y") || userid.equals("") || password.equals("")) {
                Intent i;
                i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
                //test
            }else {
                Intent i;
                i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }

    public void checkAppVersion() {
        Call<AppDetailsResponse> call = ApiCall.getSeervice().getAppDetails();

        call.enqueue(new Callback<AppDetailsResponse>() {
            @Override
            public void onResponse(@NonNull Call<AppDetailsResponse> call, @NonNull Response<AppDetailsResponse> response) {
                //AppVersion version = response.version
                assert response.body() != null;
                if (response.body().getStatus()) {
                    validateAppVersion(response.body().getData().get(0));
                } else {
                    Toast.makeText(SplashActivity.this, "response null...", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(@NonNull Call<AppDetailsResponse> call, @NonNull Throwable t) {
                Log.e("error", t.getMessage());
                Toast.makeText(SplashActivity.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
                start();
            }
        });
    }

    @Override
    public void doOffline() {
        start();
    }

    @Override
    public void doOnLine() {
        checkAppVersion();
    }
}