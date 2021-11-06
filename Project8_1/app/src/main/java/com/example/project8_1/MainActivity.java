package com.example.project8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText edt;
    Button btnWrite;

    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker)findViewById(R.id.datePicker);
        edt = (EditText)findViewById(R.id.edt);
        btnWrite = (Button)findViewById(R.id.btnWrite);

        Calendar now = Calendar.getInstance();
        int cYear = now.get(Calendar.YEAR);
        int cMonth = now.get(Calendar.MONTH);
        int cDay = now.get(Calendar.DAY_OF_MONTH);

        //fileName = cYear + "_" + (cMonth+1) + "_" + cDay + ".txt";
        getReady(cYear, cMonth, cDay); //실행하자마자 내용이 있으면 내용출력, 버튼text 출력하기 위해

        datePicker.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                fileName = year + "_" + (monthOfYear+1) + "_" + dayOfMonth + ".txt";
//                String str = readDiary(fileName);
//                edt.setText(str);
//                btnWrite.setEnabled(true);
                getReady(year, monthOfYear, dayOfMonth);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                    String str = edt.getText().toString();
                    fos.write(str.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(), fileName + "이 저장됨", Toast.LENGTH_SHORT).show();
                } catch(IOException e){
                    Toast.makeText(getApplicationContext(), fileName + "이 저장되지 않음", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void getReady(int year, int monthOfYear, int dayOfMonth){
        fileName = year + "_" + (monthOfYear+1) + "_" + dayOfMonth + ".txt";
        String str = readDiary(fileName);
        edt.setText(str);
        btnWrite.setEnabled(true);
    }

    String readDiary(String fileName){
        String diaryStr = null;
        FileInputStream fis;
        try {
            fis = openFileInput(fileName);
            byte[] txt = new byte[512];
            fis.read(txt);
            fis.close();
            diaryStr = (new String(txt)).trim();
            btnWrite.setText("수정하기");
        } catch(IOException e){
            edt.setHint("일기 없음");
            btnWrite.setText("새로저장");
        }
        return diaryStr;
    }
}