package com.google.android.cameraview.demo;

import android.content.Intent;
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
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class Result extends AppCompatActivity {

    Float over;
    String over1;
    String log;
    String log2;
    Float ikg;
    Float ikg1;

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

       // Intent intent = getIntent();
        //Bundle extras = intent.getExtras();
        //Float m1 = extras.getFloat(m1);
        //Float m2 = extras.getFloat(m2);

        Bundle extras = getIntent().getExtras();
        Float username_string = extras.getFloat("m1");
        Float password_string = extras.getFloat("m2");

        float diff = username_string - password_string;
        float perc = diff/username_string;
        float kjk1 = perc*100;
        over = kjk1;
        over1 = over.toString();

        ikg=username_string;
        ikg1=password_string;
        log = ikg.toString();
        log2 = ikg1.toString();


       TextView t=(TextView)findViewById(R.id.textView10);
        t.setText(over1);
        TextView t2=(TextView)findViewById(R.id.textView2);
        TextView t3=(TextView)findViewById(R.id.textView4);
        t2.setText(log);
        t3.setText(log2);


        String goodc = "Not Normal";

        if (kjk1 <= 10) {
            TextView t4 = (TextView) findViewById(R.id.textView9);
            t4.setText(goodc);
        }

String kj = username_string.toString();
        String jk = password_string.toString();
        Log.d("111111111111111", kj);
        Log.d("111111111111111", jk);








        Button orderButton = (Button)findViewById(R.id.button2);

        orderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, MainActivity.class);

                startActivity(intent);
            }

        });




    }



    public void changePic(){
        //ImageView = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        //imageView2.setImageResource(path);


   }


}

