package com.example.senthur_4695.sample_test;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView=(ImageView) findViewById(R.id.image);

        final PracticeLineView pl = new PracticeLineView(this,imageView.getDrawingCache());
//        pl.setBackgroundColor(Color.YELLOW);
        LayoutInflater mInflater = LayoutInflater.from(this);

        RelativeLayout mainView = (RelativeLayout) mInflater.inflate(R.layout.activity_main, null);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


        //params.setMargins((int)imageView.getX(),(int)imageView.getY(),imageView.getRight(),imageView.getBottom());
        int[]a =new int[2];
        imageView.getLocationInWindow(a);
        //params.setMargins(0, 400, 120, 120);
        pl.setLayoutParams(params);
        mainView.addView(pl);
        //imageView.setImageTintMode(PorterDuff.Mode.SRC);
        //imageView.setForeground(pl.getForeground());
        //pl.setBitmap(imageView.getDrawingCache());
        //pl.setForegroundTintMode(PorterDuff.Mode.DST_ATOP);
        setContentView(mainView);
        //imageView.setVisibility(View.INVISIBLE);
        //Toast.makeText(this,imageView.getVisibility()+""+View.INVISIBLE+""+imageView.getWidth()+""+imageView.getHeight(),Toast.LENGTH_LONG).show();

        ValueAnimator sample = ValueAnimator.ofFloat(0.0f,1.0f);
        //sample.setInterpolator(new BounceInterpolator());
        sample.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value =(float) (animation.getAnimatedValue());
                //pl.makeCheckers(value);
                //pl.makeWheel(value);
                pl.makeSplit(value);
            }
        });
        sample.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                //imageView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        sample.setDuration(2000);
        sample.start();
    }
}
