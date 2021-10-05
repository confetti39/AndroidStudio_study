package com.example.androidpicview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Text1, Text2;
    Switch Switch;
    RadioGroup RBgroup;
    RadioButton RbPi, RbQ, RbR;
    ImageView Img;
    Button BtnFin, BtnRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        Text1 = (TextView)findViewById(R.id.Text1);
        Text2 = (TextView)findViewById(R.id.Text2);
        Switch = (Switch)findViewById(R.id.Switch);
        RBgroup = (RadioGroup)findViewById(R.id.RBgroub);
        RbPi = (RadioButton)findViewById(R.id.RbPi);
        RbQ = (RadioButton)findViewById(R.id.RbQ);
        RbR = (RadioButton)findViewById(R.id.RbR);
        Img = (ImageView)findViewById(R.id.Img);
        BtnFin = (Button)findViewById(R.id.BtnFin);
        BtnRe = (Button)findViewById(R.id.BtnRe);

        Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Switch.isChecked() == true) {
                    Text2.setVisibility(View.VISIBLE);
                    RBgroup.setVisibility(View.VISIBLE);
                    Img.setVisibility(View.VISIBLE);
                    BtnFin.setVisibility(View.VISIBLE);
                    BtnRe.setVisibility(View.VISIBLE);
                }
                else {
                    Text2.setVisibility(View.INVISIBLE);
                    RBgroup.setVisibility(View.INVISIBLE);
                    Img.setVisibility(View.INVISIBLE);
                    BtnFin.setVisibility(View.INVISIBLE);
                    BtnRe.setVisibility(View.INVISIBLE);
                }
            }
        });

        RBgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.RbPi)
                    Img.setImageResource(R.drawable.pi);
                else if(checkedId == R.id.RbQ)
                    Img.setImageResource(R.drawable.q);
                else if(checkedId == R.id.RbR)
                    Img.setImageResource(R.drawable.r);
            }
        });

        BtnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        BtnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}