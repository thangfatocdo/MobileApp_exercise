package com.example.belamtoan;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    Button lammoi,check;
    EditText numA,numB;
    EditText ketqua;
    TextView thongbao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lammoi = (Button) findViewById(R.id.btn_baimoi);
        check = (Button) findViewById(R.id.btn_kiemtra);
        numA = (EditText)  findViewById(R.id.ed_num1);
        numB = (EditText)  findViewById(R.id.ed_num2);
        ketqua = (EditText)  findViewById(R.id.ed_kq);
        thongbao = (TextView) findViewById(R.id.tv_thongbao);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String snumA = numA.getText().toString().trim();
                int dnumA = Integer.parseInt(snumA);
                String snumB = numB.getText().toString().trim();
                int dnumB = Integer.parseInt(snumB);
                String sKetqua = ketqua.getText().toString().trim();
                int dKetqua = Integer.parseInt(sKetqua);
                String sResult ="";
                if ((dnumA+ dnumB) == dKetqua){
                    sResult = "bé giỏi quá";
                }
                else{
                    sResult = "bé sai rồi kết quả là "+ (dnumA+dnumB);
                }
                thongbao.setText(valueOf(sResult));
            }
        });
        lammoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rd = new Random();
                int number1 = rd.nextInt(11);
                int number2 = rd.nextInt(11);
                numA.setText(valueOf(number1));
                numB.setText(valueOf(number2));
            }
        });
    }

}