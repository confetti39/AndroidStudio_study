package com.example.project6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    ViewFlipper viewFlipper;
    float initX;

    //이 부분에서 제너레이트 -> Override methods -> onTouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) { //touch를 했다
            initX = event.getRawX();
        } else if(event.getAction() == MotionEvent.ACTION_UP) {
            float diffX = initX - event.getRawX();

            if(diffX > 30){
                viewFlipper.showNext();
            } else if(diffX < -30){
                viewFlipper.showPrevious();
            }
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPrev = (Button)findViewById(R.id.btnPrev);
        btnNext = (Button)findViewById(R.id.btnNext);
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });


    }
}