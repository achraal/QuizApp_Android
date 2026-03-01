package com.example.quizapp_ait_lahcen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Quiz2 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    int score;
    String reponse = "À droite";
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz2);

        rg = findViewById(R.id.rg);
        next = findViewById(R.id.next);
        Intent intent=getIntent();
        score=intent.getIntExtra("score",0) ;

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb = findViewById(rg.getCheckedRadioButtonId());
                if(rg.getCheckedRadioButtonId() == -1){
                    Toast.makeText(getApplicationContext(), "Merci de choisir une réponse S.V.P !", Toast.LENGTH_SHORT).show();
                }else{
                    if(rb.getText().toString().equals(reponse)){
                        score += 1;
                    }
                    Intent intent = new Intent(Quiz2.this, Quiz3.class);
                    startActivity(intent);
                    overridePendingTransition(R.drawable.exit,R.drawable.entry);
                    finish();
                }
            }
        });
    }
}