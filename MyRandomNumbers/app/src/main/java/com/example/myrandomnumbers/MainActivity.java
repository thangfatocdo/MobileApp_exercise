package com.example.myrandomnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button tao;
    TextView ketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tao = (Button) findViewById(R.id.btnHien);
        ketqua = (TextView) findViewById(R.id.tvKetQua);

        tao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<Integer> hs = new HashSet<>();
                Random rd = new Random();
                while (hs.size()<13){
                    hs.add(rd.nextInt(52)+1);
                }
                String kq = "Kết quả 13 số ngẫu nhiên:\n ";
                Iterator iterator;
                iterator = hs.iterator();
                while (iterator.hasNext()){
                    kq += iterator.next().toString() + " ";
                }
                ketqua.setText(kq);
            }
        });
    }
}