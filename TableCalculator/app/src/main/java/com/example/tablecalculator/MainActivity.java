package com.example.tablecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Edit1, Edit2;
    Button BtnAdd, BtnSub, BtnMul, BtnDiv, BtnMod;
    TextView TextResult;
    String num1, num2;
    Double result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("테이블레이아웃 계산기");

        Edit1 = (EditText)findViewById(R.id.Edit1);
        Edit2 = (EditText)findViewById(R.id.Edit2);
        BtnAdd = (Button)findViewById(R.id.BtnAdd);
        BtnSub = (Button)findViewById(R.id.BtnSub);
        BtnMul = (Button)findViewById(R.id.BtnMul);
        BtnDiv = (Button)findViewById(R.id.BtnDiv);
        BtnMod = (Button)findViewById(R.id.BtnMod);
        TextResult = (TextView)findViewById(R.id.TextResult);

        for(i = 0; i < numBtnIDs.length; i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for(i = 0; i < numBtnIDs.length; i++){
            final int index; //index 상수를 만든다.
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Edit1.isFocused() == true){
                        num1 = Edit1.getText().toString() + numButtons[index].getText().toString();
                        //numButtons[index]의 index가 상수가 아니면 에러가 발생한다.
                        Edit1.setText(num1);
                    } else if (Edit2.isFocused() == true){
                        num2 = Edit2.getText().toString() + numButtons[index].getText().toString();
                        Edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "먼저 EditText를 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        BtnAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                TextResult.setText("계산 결과: "+result.toString());
                return;
            }
        });
        BtnSub.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                TextResult.setText("계산 결과: "+result.toString());
                return;
            }
        });
        BtnMul.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                TextResult.setText("계산 결과: "+result.toString());
                return;
            }
        });
        BtnDiv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (num2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = Double.parseDouble(num1) / Double.parseDouble(num2);
                TextResult.setText("계산 결과: "+result.toString());
                return;
            }
        });
        BtnMod.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (num2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = Double.parseDouble(num1) % Double.parseDouble(num2);
                TextResult.setText("계산 결과: "+result.toString());
                return;
            }
        });
    }
}