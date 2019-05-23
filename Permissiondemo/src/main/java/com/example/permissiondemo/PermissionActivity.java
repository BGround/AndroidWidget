package com.example.permissiondemo;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PermissionActivity extends AppCompatActivity {

    private Button mCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        mCall = findViewById(R.id.call_bt);
        mCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });
    }

    public void call() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},1);
        }else {
            callPhone();
        }
    }

    public void callPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + "10086");
        intent.setData(uri);
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
        if (1 == requestCode) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhone();
            }else {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                    AlertDialog dialog = new AlertDialog.Builder(this)
                            .setMessage("该功能需要访问电话的权限，不开启将无法正常工作！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            }).create();
                    dialog.show();
                }
            }
            return ;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
