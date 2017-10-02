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

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
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
    private float orig = 100f;
    int windowwidth;
    int windowheight;
    private LayoutParams layoutParams;

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
        ImageView imageView12 = (ImageView) findViewById(R.id.imageView12);
        Bitmap bmp = BitmapFactory.decodeFile(aa);
        imageView12.setImageBitmap(bmp);










/*

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
                            x_cord = windowwidth;
                        }
                        if (y_cord > windowheight) {
                            y_cord = windowheight;
                        }

                        layoutParams.leftMargin = x_cord - 25;
                        layoutParams.topMargin = y_cord - 75;

                        img.setLayoutParams(layoutParams);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


*/








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
            //Toast.makeText(getApplicationContext(), "Scale Begin", Toast.LENGTH_SHORT).show();
            onScaleBegin = scale;
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {

            onScaleEnd = scale;

            if (onScaleEnd > onScaleBegin) {
                //Toast.makeText(getApplicationContext(), "Scaled Up By " + String.valueOf(onScaleEnd/onScaleBegin), Toast.LENGTH_SHORT).show();
                orig = orig + onScaleEnd/onScaleBegin;
                Toast.makeText(getApplicationContext(), "Orig=  " + String.valueOf(orig), Toast.LENGTH_SHORT).show();
            } else if (onScaleEnd < onScaleBegin) {
                //Toast.makeText(getApplicationContext(), "Scaled Down By " + String.valueOf(onScaleBegin/onScaleEnd), Toast.LENGTH_SHORT).show();
                orig = orig - onScaleEnd/onScaleBegin;
                Toast.makeText(getApplicationContext(), "Orig=  " + String.valueOf(orig), Toast.LENGTH_SHORT).show();
            }

        }
    }
}
