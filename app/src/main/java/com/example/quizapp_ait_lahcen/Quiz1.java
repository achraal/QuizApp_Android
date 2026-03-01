package com.example.quizapp_ait_lahcen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Quiz1 extends AppCompatActivity {


    RadioButton rb;
    RadioGroup rg;
    Button next;
    int score = 0;
    String reponse = "Non";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz1);
        rg = findViewById(R.id.rg);
//        r1q1 = findViewById(R.id.r1q1);
//        r2q1 = findViewById(R.id.r2q1);
        next = findViewById(R.id.next);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rg.getCheckedRadioButtonId() == -1 ){
                    Toast.makeText(getApplicationContext(), "Merci de choisir une réponse S.V.P !", Toast.LENGTH_SHORT).show();
                } else {
                    rb = findViewById(rg.getCheckedRadioButtonId());
                }
                if(rb.getText().toString().equals(reponse)){
                    score += 1;
                }
                Intent intent = new Intent(Quiz1.this, Quiz2.class);
                overridePendingTransition(R.drawable.exit,R.drawable.entry);
                finish();
            }
        });
    }
}