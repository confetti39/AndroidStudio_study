package com.example.project5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout, params);

        EditText editText = new EditText(this);
        Button btn = new Button(this);
        TextView textView = new TextView(this);
        baseLayout.addView(editText);
        baseLayout.addView(btn);
        baseLayout.addView(textView);

        btn.setBackgroundColor(Color.YELLOW);
        btn.setText("버튼입니다");
        textView.setTextColor(Color.MAGENTA);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                textView.setText(editText.getText());
                //editText에 있는 문자열 가져오려면 getText 사용해야함 !!!
            }
        });
    }
}