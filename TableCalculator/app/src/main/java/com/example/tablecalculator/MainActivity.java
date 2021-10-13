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

    class CalcListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            num1 = Edit1.getText().toString();
            num2 = Edit2.getText().toString();
            double n1, n2;
            try{
            n1 = Double.parseDouble(num1);
            n2 = Double.parseDouble(num2);
            } catch (NumberFormatException e){
                Toast.makeText(MainActivity.this, "숫자를 먼저 입력하세요!", Toast.LENGTH_SHORT).show();
                return;
            }
            if(v == BtnAdd)
                result = n1 + n2;
            else if(v == BtnDiv)
                result = n1 / n2;
            else if(v == BtnMul)
                result = n1 * n2;
            else if(v == BtnSub)
                result = n1 - n2;
            else if(v == BtnMod)
                result = n1 % n2;
            else
                result = 0.0;
            TextResult.setText("계산 결과: " + result);
        }
    }

    class NumBtnListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String num = "";
            for(int i = 0 ; i < numButtons.length; i++){
                if(v == numButtons[i]){
                    num = String.valueOf(i);
                    break;
                }
            }
            if(Edit1.isFocused() == true){
                num1 = Edit1.getText().toString() + num;
                //numButtons[index]의 index가 상수가 아니면 에러가 발생한다.
                Edit1.setText(num1);
            } else if (Edit2.isFocused() == true){
                num2 = Edit2.getText().toString() + num;
                Edit2.setText(num2);
            } else {
                Toast.makeText(getApplicationContext(),
                        "먼저 EditText를 선택하세요.", Toast.LENGTH_SHORT).show();
            }
        }
    } //inner Class
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

        NumBtnListener nl = new NumBtnListener();
        for(i = 0; i < numBtnIDs.length; i++){
            numButtons[i] = (Button)findViewById(numBtnIDs[i]);
            numButtons[i].setOnClickListener(nl);
        }

        CalcListener cl = new CalcListener();
        BtnAdd.setOnClickListener(cl);
        BtnSub.setOnClickListener(cl);
        BtnMul.setOnClickListener(cl);
        BtnDiv.setOnClickListener(cl);
        BtnMod.setOnClickListener(cl);

    }
}