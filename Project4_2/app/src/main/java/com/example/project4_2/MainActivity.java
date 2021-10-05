package com.example.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView Text1, Text2;
    CheckBox ChkAgree;
    RadioGroup RBgroup1;
    RadioButton RBdog, RBcat, RBrabbit;
    Button BtnOk;
    ImageView ImgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("반려동물 사진 보기");

        Text1 = (TextView)findViewById(R.id.Text1);
        Text2 = (TextView)findViewById(R.id.Text2);
        ChkAgree = (CheckBox)findViewById(R.id.ChkAgree);

        RBgroup1 = (RadioGroup)findViewById(R.id.RBgroup1);
        RBdog = (RadioButton)findViewById(R.id.RBdog);
        RBcat = (RadioButton)findViewById(R.id.RBcat);
        RBrabbit = (RadioButton)findViewById(R.id.RBrabbit);

        BtnOk = (Button)findViewById(R.id.BtnOk);
        ImgPet = (ImageView)findViewById(R.id.ImgPet);

        ChkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ChkAgree.isChecked() == true){
                    Text2.setVisibility(View.VISIBLE);
                    RBgroup1.setVisibility(View.VISIBLE);
                    BtnOk.setVisibility(View.VISIBLE);
                    ImgPet.setVisibility(View.VISIBLE);
                }
                else{
                    Text2.setVisibility(View.INVISIBLE);
                    RBgroup1.setVisibility(View.INVISIBLE);
                    BtnOk.setVisibility(View.INVISIBLE);
                    ImgPet.setVisibility(View.INVISIBLE);
                }
            }
        });

        BtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(RBgroup1.getCheckedRadioButtonId()) {
                    case R.id.RBdog:
                    ImgPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.RBcat:
                        ImgPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.RBrabbit:
                        ImgPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}