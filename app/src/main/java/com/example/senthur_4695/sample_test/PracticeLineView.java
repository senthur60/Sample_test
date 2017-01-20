package com.example.senthur_4695.sample_test;

/**
 * Created by senthur-4695 on 17/01/17.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Toast;

public class PracticeLineView extends View {
    boolean bitmapDrawn = false;
    private Paint mPaint,imgpaint;
    Bitmap bm;
    float bhei,bwid,midx,midy;
    private  Path p,p2;
    public PracticeLineView(Context context,Bitmap bitmap) {
        super(context);
        this.setLayerType(LAYER_TYPE_HARDWARE,null);

        bm = BitmapFactory.decodeResource(getResources(), R.drawable.sample);
        //makeArrow(140,140);
        bhei=bm.getHeight();
        bwid=bm.getWidth();
        midx=bhei/2.0f;
        midy=bwid/2.0f;
        Toast.makeText(context," "+bhei+ " "+bwid+" "+midy+" "+midx,Toast.LENGTH_LONG).show();

        mPaint = new Paint();
        //mPaint.setColor(Color.RED);
        //mPaint.setStyle(Paint.Style.FILL);
        imgpaint=new Paint();
        //mPaint.setARGB(255,255,255,255);
//        imgpaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
       // mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        mPaint.setShader(new BitmapShader(bm,Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // canvas.translate(getPaddingLeft(), getPaddingTop() - getPaddingBottom());
        /*if(bm!=null *//*&& !bitmapDrawn*//*){
            canvas.drawBitmap(bm,0,0,imgpaint);
            bitmapDrawn = true;
        }*/
       // canvas.drawColor(Color.TRANSPARENT);
        //canvas.drawPath(p, mPaint);

        //canvas.drawPath(p2,mPaint);
        //Paint pa=new Paint(Color.RED);
        //canvas.drawRect(0,0,600,600,pa);
//        canvas.drawRect(300,200,600,400,new Paint(Color.BLUE));
//        Paint pai=new Paint(Color.BLUE);
//        int[] c=new int[3];
//        c[0]=0xE6000000;
//        c[0]=0xE6FF0000;
//        c[1]=0xE600FF00;
//        c[2]=0xE60000FF;
//        pai.setShader(new LinearGradient(0, 0, 0, 600, c, null, Shader.TileMode.REPEAT));
//        pai.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

//        canvas.drawRect(0,0,600,600,pai);
//        Paint fr=new Paint();
//        fr.setShader(new LinearGradient(0, 0, 0, 600, Color.BLACK, Color.TRANSPARENT, Shader.TileMode.CLAMP));
//        fr.setStyle(Paint.Style.FILL);
//        fr.setXfermode( new PorterDuffXfermode(PorterDuff.Mode.DST_IN) );
//        canvas.drawRect(0,0,600,600,fr);
       // canvas.drawRect(300,400,600,600,fr);


        Paint paint = new Paint();
        paint.setColor(0x33000000);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(100,600,600,1000,45,90,true,paint);

        canvas.drawRect(100,100,600,600,paint);


        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
        //paint.setAlpha(255);
        //paint.setColor(Color.WHITE);
        //paint.setXfermode( new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP) );
        //canvas.drawRect(100,100,600,600,paint);
        //paint.setColor(Color.BLACK);
        //paint.setAlpha(60);
        canvas.drawRect(100,100,600,600,paint);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawRect(200,200,700,700,paint);
        //Paint ps=new Paint();ps.setColor(Color.RED);
        //canvas.drawArc(100,600,600,1000,45,90,true,paint);


    }

    void makeWedge(float val) {
        p = new Path();
        //p2=new Path();
        val=1-val;
        p.moveTo(midy, midx);
        p.lineTo(midy, bhei);
        if((midy-(midy*val*4.0f)>0) )
        p.lineTo(midy-(midy*val*4), bhei);
        else if ((bhei-(bhei*((val-.25)*2.0f)))>0 ){
            p.lineTo(0.0f, bhei);
            p.lineTo(0.0f,(float) (bhei-(bhei*((val-.25)*2.0f))));
        }
        else
        {
            p.lineTo(0.0f, bhei);
            p.lineTo(0.0f,0.0f);
            p.lineTo((float) (midy*((val-.75)*4)),0.0f);
        }

        p.lineTo(midy, midx);
        //p.close();
        p.moveTo(midy, midx);
        p.lineTo(midy, bhei);
        if((midy+(midy*val*4)<=bwid) )
            p.lineTo(midy+(midy*val*4.0f), bhei);
        else if ((bhei-(bhei*((val-.25)*2.0f)))>0 ){
            p.lineTo(bwid, bhei);
            p.lineTo(bwid,(float) (bhei-(bhei*((val-.25)*2.0f))));
        }
        else
        {
            p.lineTo(bwid,bhei);
            p.lineTo(bwid,0.0f);
            p.lineTo((float) (bwid-(midy*((val-.75)*4))),0.0f);
        }
        p.lineTo(midy,midx);
        this.invalidate();

    }
    void makeWheel(float val)

    {
        p=new Path();
        p.moveTo(midy, midx);
        p.lineTo(midy, bhei);
        if((midy-(midy*val*4)>0) )
            p.lineTo(midy-(midy*val*4), bhei);
        else if ((bhei-(bhei*((val-.25)*2.0f)))>0 ){
            p.lineTo(0.0f, bhei);
            p.lineTo(0.0f,(float) (bhei-(bhei*((val-.25)*2.0f))));
        }
        else
        {
            p.lineTo(0.0f, bhei);
            p.lineTo(0.0f,0.0f);
            p.lineTo((float) (midy*((val-.75)*4)),0.0f);
        }

        p.lineTo(midy, midx);
        p.lineTo(midy, midx);
        //p.close();
        p.moveTo(midy, midx);
        p.lineTo(midy, 0.0f);
        if((midy+(midy*val*4)<=bwid) )
            p.lineTo(midy+(midy*val*4), 0.0f);
        else if (((bhei*((val-.25)*2.0f)))<=bhei ){
            p.lineTo(bwid, 0.0f);
            p.lineTo(bwid,(float) ((bhei*((val-.25)*2.0f))));
        }
        else
        {
            p.lineTo(bwid,0.0f);
            p.lineTo(bwid,bhei);
            p.lineTo((float) (bwid-(midy*((val-.75)*4))),bhei);
        }
        p.lineTo(midy,midx);
        this.invalidate();

    }
    void makeCheckers(float val)
    {
        //val=1-val;
        p=new Path();
        float wsize =bwid/6;
        float hwid=wsize/2;
        float hsize=bhei/6;
        int i,j;
        for(j=0;j<6;j++) {
            for (i = 0; i < 6; i++) {
                p.moveTo(wsize * i, hsize * j);
                p.lineTo(wsize * i, hsize + (hsize * j));
                p.lineTo((wsize * val) + (wsize * i), hsize + (hsize * j));
                p.lineTo((wsize * val) + (wsize * i), hsize * j);
                p.lineTo(wsize * i, hsize * j);
            }
                j++;
            for (i = 0; i < 7; i++) {
                p.moveTo((wsize * i)-hwid, hsize * j);
                p.lineTo((wsize * i)-hwid, hsize + (hsize * j));
                p.lineTo(((wsize * val) + (wsize * i))-hwid, hsize + (hsize * j));
                p.lineTo(((wsize * val) + (wsize * i))-hwid, hsize * j);
                p.lineTo((wsize * i)-hwid, hsize * j);
            }


        }
        this.invalidate();


    }
    void makeSplit(float val)
    {
        p=new Path();
        p.moveTo(0.0f,0.0f);
        p.lineTo(0.0f,bhei);
        p.lineTo(midy*val,bhei);
        p.lineTo(midy*val,0.0f);
        p.lineTo(0.0f,0.0f);
        p.moveTo(bwid,0.0f);
        p.lineTo(bwid,bhei);
        p.lineTo(bwid-(midy*val),bhei);
        p.lineTo(bwid-(midy*val),0.0f);
        p.lineTo(bwid,0.0f);
        this.invalidate();
    }


}