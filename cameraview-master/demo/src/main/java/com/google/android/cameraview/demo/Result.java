package com.google.android.cameraview.demo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String path = Environment.getExternalStorageDirectory().toString()+"/picture.jpeg";
        String path2 = Environment.getExternalStorageDirectory().toString()+"/picture1.jpeg";
        String ajja = Environment.DIRECTORY_PICTURES+"/picture.jpeg";


        File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                "picture.jpg");
        String aa = file.toString();
        File filea = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                "picture1.jpg");
        String ab = filea.toString();
        Log.d("myTag", ab);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        Bitmap bmp = BitmapFactory.decodeFile(aa);
        imageView2.setImageBitmap(bmp);

        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        Bitmap bmp1 = BitmapFactory.decodeFile(ab);
        imageView3.setImageBitmap(bmp1);




    }


    public void changePic(){
        //ImageView = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        //imageView2.setImageResource(path);


   }


}

