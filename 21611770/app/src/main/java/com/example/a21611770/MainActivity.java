package com.example.a21611770;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnUser, btnManager, btnUserResv, btnManagerResv;
    ViewFlipper viewFlipper;
    DatePicker userDatePicker, dlgDatePicker;
    NumberPicker pickerYear, pickerMonth;
    TextView tvUserResv, tvManagerResv, toastText1;
    View dialog1View, dialog2View, toastView;
    TimePicker dlgTimePicker;
    EditText dlgEdt;

    float initX;

    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
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

        btnUser = (Button)findViewById(R.id.btnUser);
        btnManager = (Button)findViewById(R.id.btnManager);
        btnUserResv = (Button)findViewById(R.id.btnUserResv);
        btnManagerResv = (Button)findViewById(R.id.btnManagerResv);
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        userDatePicker = (DatePicker)findViewById(R.id.userDatePicker);
        pickerYear = (NumberPicker) findViewById(R.id.pickerYear);
        pickerMonth = (NumberPicker) findViewById(R.id.pickerMonth);
        tvUserResv = (TextView)findViewById(R.id.tvUserResv);
        tvManagerResv = (TextView)findViewById(R.id.tvManagerResv);

        pickerYear.setMinValue(2018);
        pickerYear.setMaxValue(2022);
        pickerMonth.setMinValue(1);
        pickerMonth.setMaxValue(12);


        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showPrevious();
            }
        });
        btnManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlipper.showNext();
            }
        });

        btnUserResv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1View = (View)View.inflate(MainActivity.this, R.layout.dialog1, null);
                dlgTimePicker = (TimePicker) dialog1View.findViewById(R.id.dlgTimePicker);
                dlgEdt = (EditText) dialog1View.findViewById(R.id.dlgEdt);

                if (!tvUserResv.getText().equals("없음")){
                    Toast toast = new Toast(MainActivity.this);
                    toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                    toastText1 = (TextView)toastView.findViewById(R.id.toastText1);
                    toastText1.setText("추가 예약을 할 수 없습니다.");
                    toast.setView(toastView);
                    toast.show();
                }
                if(tvUserResv.getText().equals("없음")){
                    AlertDialog.Builder dlgUser = new AlertDialog.Builder(MainActivity.this);
                    dlgUser.setView(dialog1View);
                    dlgUser.setPositiveButton("예약",
                            new DialogInterface.OnClickListener() {
                                @Override

                                public void onClick(DialogInterface dialog, int which){
                                    dlgTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                                        @Override
                                        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                                            String strtime = hourOfDay + "시 " + minute + "분 ";
                                            tvUserResv.setText(strtime + dlgEdt.getText());
                                        }
                                    });
                                    //tvUserResv.setText(dlgEdt.getText());
                                }

                            });
                    dlgUser.setNegativeButton("취소", null);
                    dlgUser.show();
                }

            }
        });

        btnManagerResv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1View = (View)View.inflate(MainActivity.this, R.layout.dialog2, null);
                dlgDatePicker = (DatePicker)findViewById(R.id.dlgDatePicker);
                AlertDialog.Builder dlgManager = new AlertDialog.Builder(MainActivity.this);
                dlgManager.setView(dialog2View);

                if (!tvManagerResv.getText().equals("예약없음")){
                    dlgManager.setPositiveButton("제거",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which){
                                    dlgDatePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
                                        @Override
                                        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                            tvManagerResv.setText("예약없음");
                                            tvUserResv.setText("없음");
                                        }
                                    });
                                }
                            });
                    dlgManager.setNegativeButton("취소", null);
                    dlgManager.show();
                }

                dlgManager.setNegativeButton("취소", null);
                dlgManager.show();
            }
        });
    }
}