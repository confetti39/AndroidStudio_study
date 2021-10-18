package com.example.project7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button button1;
    EditText edtName, edtEmail, dlgEdt1, dlgEdt2;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        edtName = (EditText)findViewById(R.id.edtName);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View)View.inflate(MainActivity.this, R.layout.dialog, null);
                dlgEdt1 = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                dlgEdt2 = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                dlgEdt1.setText(edtName.getText().toString());
                dlgEdt2.setText(edtEmail.getText().toString());

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_launcher_foreground);
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edtName.setText(dlgEdt1.getText().toString());
                                edtEmail.setText(dlgEdt2.getText().toString());
                            }
                        });
                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast toast = new Toast(MainActivity.this);
                                toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                                toastText = (TextView)toastView.findViewById(R.id.toastText1);
                                toastText.setText("취소했습니다.");
                                toast.setView(toastView);

                                Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                                int xOffset = (int)(Math.random()*display.getWidth());
                                int yOffset = (int)(Math.random()*display.getHeight());

                                toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                                toast.show();
                            }
                        });
                dlg.show();
            }
        });

    }
}