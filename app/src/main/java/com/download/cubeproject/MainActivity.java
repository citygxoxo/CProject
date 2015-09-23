package com.download.cubeproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends Activity   {

    private ImageView mImageView;
    private ViewGroup mRrootLayout;

    private boolean actionBarTouched = false;
    private boolean droppingActionBar = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.activity_main);

        mRrootLayout = (ViewGroup) findViewById(R.id.root);
        mImageView = (ImageView) mRrootLayout.findViewById(R.id.imageView);

        mImageView.setOnTouchListener(mTouchEvent);






    }
    private OnTouchListener mTouchEvent= new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            TextView mText = (TextView) mRrootLayout.findViewById(R.id.textView);
            if(actionBarTouched) {
                mText.setText("touched" + X + " " + Y);
                if(Y > 60) {
                    mText.setText("drop!");
                    if(!droppingActionBar)
                    {
                        droppingActionBar = true;
                  //      Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump);
                  //      mImageView.startAnimation(hyperspaceJumpAnimation);
                    }


                }
            }


            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    mText.setText("touched" + X +" " + Y);
                    actionBarTouched = true;
                    break;
                case MotionEvent.ACTION_UP:
                    mText.setText("no touch");
                    break;

            }


            return true;
        }
    };


/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
