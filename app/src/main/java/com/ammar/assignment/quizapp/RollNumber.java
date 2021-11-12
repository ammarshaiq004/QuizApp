package com.ammar.assignment.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ammar.assignment.quizapp.khel.AsadQuiz;


public class RollNumber extends AppCompatActivity {
   Button startQuiz;
   EditText namee,rollNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_number);
        startQuiz=findViewById(R.id.startQuiz);
        namee=findViewById(R.id.namee);
        rollNumber=findViewById(R.id.rollNumber);
        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utility.name=namee.getText().toString();
                Utility.rollNumber=rollNumber.getText().toString();
                RollNumber.this.startActivity(new Intent(RollNumber.this, AsadQuiz.class));
                RollNumber.this.finish();
            }
        });
    }
}