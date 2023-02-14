package com.example.checkvehicle_207ct10338;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button check;
    EditText sign;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign = (EditText) findViewById(R.id.etSign);
        check = (Button) findViewById(R.id.btnCheck);
        result = (TextView) findViewById(R.id.tvResult);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1. input string
                String ssign = sign.getText().toString().trim();
                //2. Tao mot khuon mau
                String mau = "5[0-9]-[A-Z][0-9]-[0-9]{3}\\.[0-9]{2}";
                Pattern pattern = Pattern.compile(mau);
                //3. ap vao input
                Matcher matcher = pattern.matcher(ssign);
                //hien thi ket qua
                String sresult = "";
                if (matcher.matches()==true){
                    sresult = ssign + "\nBiển số hợp lệ TPHCM";
                }
                else{
                    sresult = ssign + "\nBiển số không hợp lệ TPHCM";
                }
                result.setText(sresult);
            }
        });
    }
}