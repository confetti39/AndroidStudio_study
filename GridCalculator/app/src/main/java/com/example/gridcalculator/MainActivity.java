package com.example.gridcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnMod;
    TextView textResult;
    String num1, num2;
    Double result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = { R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9 };
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("그리드레이아웃 계산기");

        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnMod = (Button)findViewById(R.id.btnMod);
        textResult = (TextView)findViewById(R.id.textResult);

        for(i = 0; i < numBtnIDs.length; i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
        }

        for(i = 0; i < numBtnIDs.length; i++){
            final int index; //index 상수를 만든다.
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edit1.isFocused() == true){
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        //numButtons[index]의 index가 상수가 아니면 에러가 발생한다.
                        edit1.setText(num1);
                    } else if (edit2.isFocused() == true){
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "먼저 EditText를 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        btnAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = Double.parseDouble(num1) + Double.parseDouble(num2);
                textResult.setText("계산 결과: "+result.toString());
                return;
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = Double.parseDouble(num1) - Double.parseDouble(num2);
                textResult.setText("계산 결과: "+result.toString());
                return;
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = Double.parseDouble(num1) * Double.parseDouble(num2);
                textResult.setText("계산 결과: "+result.toString());
                return;
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (num2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = Double.parseDouble(num1) / Double.parseDouble(num2);
                textResult.setText("계산 결과: "+result.toString());
                return;
            }
        });
        btnMod.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                if (num1.equals("") || num2.equals("")) {
                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (num2.equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = Double.parseDouble(num1) % Double.parseDouble(num2);
                textResult.setText("계산 결과: "+result.toString());
                return;
            }
        });
    }
}