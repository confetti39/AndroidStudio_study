package com.example.project6_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    ViewFlipper viewFlipper;
    float initX;
    double initTime;

    //터치제스처로 뷰플리퍼 다음화면, 이전화면
    //이 부분에서 제너레이트 -> Override Methods -> onTouchEvent
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

    //스마트폰 하단 back button 누르고 일정한 시간 내에 한 번 더 취소 누르면 취소 동작
    //제너레이트 -> Override Methods -> onKeyDown
    //keyCode=어떤 키가 눌렸는지 정보, keyEvent=이벤트 정보
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis() - initTime > 3000){
                //처음 취소버튼 누르면 currentTimeMillis에 엄청 큰 값이 저장되어 있고, initTime은 자동으로 0으로 초기화된 상태다.
                Toast.makeText(MainActivity.this, "종료하려면 한 번 더 눌러주세요",
                        Toast.LENGTH_SHORT).show();
                initTime = System.currentTimeMillis();
            } else {
                finish(); //앱 종료
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