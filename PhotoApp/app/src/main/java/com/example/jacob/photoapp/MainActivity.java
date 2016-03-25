package com.example.jacob.photoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView jacobsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button jacobButton = (Button) findViewById(R.id.jacobsButton);
        jacobsImageView = (ImageView) findViewById(R.id.jacobsImageView);

        //Disable the button if the user has no camera

        if(!hasCamera()){
            jacobButton.setEnabled(false);
        }

    }

    //Check if the user has a camera

    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    //Launching the camera
    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Take a picture and pass results to onActivityResult
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }
    //If you want to returnn the image taken
//press alt+insert to be able to overide methods
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            //Get the photot
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            jacobsImageView.setImageBitmap(photo);
        }


        //super.onActivityResult(requestCode, resultCode, data);
    }
}
