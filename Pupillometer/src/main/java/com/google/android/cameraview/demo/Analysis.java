/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.cameraview.demo;

import static android.R.attr.name;

import static com.google.android.cameraview.demo.R.drawable.lol1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;

import java.io.File;


public class Analysis extends AppCompatActivity {

    ScaleGestureDetector scaleGestureDetector;
    private ImageView imageView;
    private float scale = 1f;
    private float orig = 10f;
    int windowwidth;
    int windowheight;
    private LayoutParams layoutParams;
    float how;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        imageView = (ImageView)findViewById(R.id.imageView11);
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());
        String path = Environment.getExternalStorageDirectory().toString()+"/picture.jpeg";
        String ajja = Environment.DIRECTORY_PICTURES+"/picture.jpeg";
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                "picture.jpg");
        String aa = file.toString();
        final ImageView imageView12 = (ImageView) findViewById(R.id.imageView12);
        Bitmap bmp = BitmapFactory.decodeFile(aa);
        imageView12.setImageBitmap(bmp);




        Button orderButton = (Button)findViewById(R.id.buttonhey);

        orderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Analysis.this, Analysis2.class);
                intent.putExtra("m1", orig);
                startActivity(intent);
            }

        });









        windowwidth = getWindowManager().getDefaultDisplay().getWidth();
        windowheight = getWindowManager().getDefaultDisplay().getHeight();
        final ImageView img = (ImageView) findViewById(R.id.imageView12);

        img.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                LayoutParams layoutParams = (LayoutParams) img
                        .getLayoutParams();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int x_cord = (int) event.getRawX();
                        int y_cord = (int) event.getRawY();

                        if (x_cord > windowwidth) {

                        }
                        if (y_cord > windowheight) {

                        }

                        layoutParams.leftMargin = x_cord - 300;
                        layoutParams.topMargin = y_cord - 300;

                        img.setLayoutParams(layoutParams);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });












    }


    public void gotoAnalysis2(View view){
        Intent intent = new Intent(this, Analysis2.class);
        intent.putExtra("m1", orig);
        startActivity(intent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private class ScaleListener implements ScaleGestureDetector.OnScaleGestureListener {

        float onScaleBegin = 0;
        float onScaleEnd = 0;

        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            scale *= detector.getScaleFactor();
            imageView.setScaleX(scale);
            imageView.setScaleY(scale);
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {

            onScaleBegin = scale;
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {

            onScaleEnd = scale;

            if (onScaleEnd > onScaleBegin) {

                orig = orig + onScaleEnd/onScaleBegin;

            } else if (onScaleEnd < onScaleBegin) {

                orig = orig - onScaleEnd/onScaleBegin;

            }

        }
    }



}
