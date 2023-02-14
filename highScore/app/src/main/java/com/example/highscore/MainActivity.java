package com.example.highscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    EditText playername, playerscore;
    Button add;
    TextView top;
    Set<String> infinite = new HashSet<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playername = (EditText) findViewById(R.id.edPlayerName);
        playerscore = (EditText) findViewById(R.id.edPlayerScore);
        add = (Button) findViewById(R.id.btnAdd);
        top = (TextView) findViewById(R.id.tv_TopPlayer);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream write = openFileOutput("top.txt", MODE_APPEND);
                    String player_name_text = playername.getText().toString().trim();
                    String player_score_text = playerscore.getText().toString().trim();
                    String format_name = player_name_text + '-' + player_score_text + '\n';
                    write.write(format_name.getBytes());
                } catch (FileNotFoundException e){
                    top.setText("File not found!");

                } catch (IOException e){
                    e.printStackTrace();
                }
                try {
                    FileInputStream read = openFileInput("top.txt");
                    DataInputStream data = new DataInputStream(read);
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(data));
                    String line = "";
                    String temp = "";

                    while ((line = buffer.readLine()) != null){
                        temp = line;
                        infinite.add(temp);
                    }
                    String top_1 = getMax();
                    String top_2 = getMax();
                    String top_3 = getMax();

                    String format_top = "#1" +top_1+"\n"+"#2"+top_2+"\n"+"#3"+top_3;

                    top.setText(format_top);
                    read.close();
                } catch (FileNotFoundException e) {
                    top.setText("File not found!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public String getMax(){
        int max_temp = 0;
        String name_score;
        String name_score_out = "";
        int stray_score;
        Iterator infinite_array = infinite.iterator();
        while (infinite_array.hasNext()){
            name_score = infinite_array.next().toString();
            String[] spl = name_score.split("-");
            stray_score = Integer.parseInt(spl[1]);
            if (stray_score > max_temp){
                max_temp = stray_score;
                name_score_out = name_score;
            }
        }
        infinite.remove(name_score_out);
        return name_score_out;
    }
}