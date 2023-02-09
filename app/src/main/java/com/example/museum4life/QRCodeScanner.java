package com.example.museum4life;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRCodeScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private static final int REQUEST_CAMERA = 1;
    private ZXingScannerView ScannerView;
    private static int cam = Camera.CameraInfo.CAMERA_FACING_BACK;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScannerView = new ZXingScannerView(this);
        setContentView(ScannerView);



        int currentApiVersion = Build.VERSION.SDK_INT;
        if(currentApiVersion >= Build.VERSION_CODES.M){
            if(checkPermission()){
                Toast.makeText(getApplicationContext(),"Permission Granted", Toast.LENGTH_LONG).show();
            }else{
                requestPermission();
            }
        }

    }

    private boolean checkPermission(){
        return (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED);
    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(QRCodeScanner.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
    }


    public void onRequestPermissionResult(int requestCode, String permission[], int[] grantResult){
        switch (requestCode){
            case REQUEST_CAMERA:
                if(grantResult.length > 0){
                    boolean cameraAccept = grantResult[0] == PackageManager.PERMISSION_GRANTED;
                    if(cameraAccept){
                        Toast.makeText(getApplicationContext(), "Permission Granted By User", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Permission Not Granted By User",Toast.LENGTH_LONG).show();
                        if(shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                            showMessageOKCancle("You need to grant the permission",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                                                requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
                                            }
                                        }
                                    });
                            return;
                        }
                    }
                }

                break;
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        int currentApiVersion = Build.VERSION.SDK_INT;
        if(currentApiVersion >= Build.VERSION_CODES.M){
            if(checkPermission()){
                if(ScannerView == null){
                    ScannerView = new ZXingScannerView(this);
                    setContentView(ScannerView);
                }
                ScannerView.setResultHandler(this);
                ScannerView.startCamera();
            }
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        ScannerView.stopCamera();
        ScannerView = null;

    }

    private void showMessageOKCancle(String message, DialogInterface.OnClickListener OKListiner){
        new AlertDialog.Builder(QRCodeScanner.this)
                .setMessage(message)
                .setPositiveButton("OK",OKListiner)
                .setNegativeButton("Cancle",null)
                .create()
                .show();
    }
    @Override
    public void handleResult(Result result) {
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String building = extras.getString("building");
        final String rawResult = result.getText();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);;
        builder.setTitle("Scan Result");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                    Intent intent = new Intent(QRCodeScanner.this, info_with_ar.class);
                    intent.putExtra("name", result.getText());
                    intent.putExtra("building", building);
                    startActivity(intent);


                //ScannerView.resumeCameraPreview(QRCodeScanner.this);
            }
        });
        builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                onDestroy();
            }
        });

        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}