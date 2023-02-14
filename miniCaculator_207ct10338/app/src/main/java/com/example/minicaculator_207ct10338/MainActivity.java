package com.example.minicaculator_207ct10338;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText numA,numB;
    Button cong, tru, nhan, chia;
    TextView kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numA = (EditText) findViewById(R.id.ed_numA);
        numB = (EditText) findViewById(R.id.ed_numB);
        kq = (TextView) findViewById(R.id.tv_kq);
        cong = (Button) findViewById(R.id.btn_cong);
        tru = (Button) findViewById(R.id.btn_tru);
        nhan = (Button) findViewById(R.id.btn_nhan);
        chia = (Button) findViewById(R.id.btn_chia);
        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SnumA = numA.getText().toString().trim();
                double dnumA = Double.parseDouble(SnumA);
                String SnumB = numB.getText().toString().trim();
                double dnumB = Double.parseDouble(SnumB);
                String sresult = "";
                sresult += dnumA+dnumB;
                kq.setText(sresult);
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SnumA = numA.getText().toString().trim();
                double dnumA = Double.parseDouble(SnumA);
                String SnumB = numB.getText().toString().trim();
                double dnumB = Double.parseDouble(SnumB);
                String sresult = "";
                sresult += dnumA-dnumB;
                kq.setText(sresult);
            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SnumA = numA.getText().toString().trim();
                double dnumA = Double.parseDouble(SnumA);
                String SnumB = numB.getText().toString().trim();
                double dnumB = Double.parseDouble(SnumB);
                String sresult = "";
                sresult += dnumA*dnumB;
                kq.setText(sresult);
            }
        });
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SnumA = numA.getText().toString().trim();
                double dnumA = Double.parseDouble(SnumA);
                String SnumB = numB.getText().toString().trim();
                double dnumB = Double.parseDouble(SnumB);
                String sresult = "";
                sresult += dnumA/dnumB;
                kq.setText(sresult);
            }
        });
    }
}