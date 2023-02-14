package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText et_day;
    TextView tv_kq;
    Button taomoi, xuatxuoi, xuatnguoc,minmax, xaptangdan, xapgiamdan, tongmang;
    int mang[]=new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_day=(EditText)findViewById(R.id.ed_dayngaunhien);
        tv_kq=(TextView)findViewById(R.id.tv_ketqua);
        taomoi=(Button)findViewById(R.id.btn_xcnn);
        xuatxuoi=(Button)findViewById(R.id.btn_xuatchuoi);
        xuatnguoc=(Button)findViewById(R.id.btn_xuatnguoc);
        minmax=(Button)findViewById(R.id.btn_maxmin);
        xaptangdan=(Button)findViewById(R.id.btn_xxtd);
        xapgiamdan=(Button)findViewById(R.id.btn_xxgd);
        tongmang=(Button)findViewById(R.id.btn_tongmang);
        //onclick listener
        taomoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Random rd = new Random();
                String chuoi="";
                for(int i = 0; i<10;i++){
                    mang[i] = rd.nextInt(10);
                }
                DocmangRaEditText();
            }
        });
        xuatxuoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DocmangRaEditText();
            }
        });
        xapgiamdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // TODO Auto-generated method stub
                int temp = mang[0];
                for (int i = 0 ; i < mang.length - 1; i++) {
                    for (int j = i + 1; j < mang.length; j++) {
                        if (mang[i] < mang[j]) {
                            temp = mang[j];
                            mang[j] = mang[i];
                            mang[i] = temp;
                        }
                    }
                }
                String chuoi = "";
                for (int i = 0; i<mang.length;i++){
                    chuoi += mang[i]+" ";
                    et_day.setText(chuoi);
                }

            }

        });
        xaptangdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // TODO Auto-generated method stub
                int temp = mang[0];
                for (int i = 0 ; i < mang.length - 1; i++) {
                    for (int j = i + 1; j < mang.length; j++) {
                        if (mang[i] > mang[j]) {
                            temp = mang[j];
                            mang[j] = mang[i];
                            mang[i] = temp;
                        }
                    }
                }
                String chuoi = "";
                for (int i = 0; i<mang.length;i++){
                    chuoi += mang[i]+" ";
                    et_day.setText(chuoi);
                }

            }

        });
        xuatnguoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String chuoi="";
                for(int i =9;i>=0;i--){
                    chuoi+=mang[i]+ " ";
                    et_day.setText(chuoi);
                }

            }

        });
        minmax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String chuoi="";
                int min = mang[0];
                int max = mang[0];
                for (int i = 0 ; i < mang.length; i++) {
                    if(mang[i]<min){
                        min = mang[i];
                    }
                    if(mang[i]>max){
                        max = mang[i];
                    }
            }

                    et_day.setText("Max: "+max +" Min: "+min);
                }

        });
        tongmang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int tong =0;
                for(int i: mang){
                    tong= tong+i;
                }
                et_day.setText("Tổng= "+tong);
            }

        });
    }


    public void DocmangRaEditText(){
        String chuoi="";
        for (int i = 0;i<10;i++){
            chuoi += mang[i]+ " ";
        }
        et_day.setText(chuoi);
    }

}