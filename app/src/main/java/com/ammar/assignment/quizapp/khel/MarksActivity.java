package com.ammar.assignment.quizapp.khel;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.ammar.assignment.quizapp.R;
import com.ammar.assignment.quizapp.ToastClass;
import com.kaopiz.kprogresshud.KProgressHUD;

public class MarksActivity extends AppCompatActivity {
    TextView False_Ans_TV;
    TextView Ans_Total_TV;
    private KProgressHUD hud;
    TextView True_Ans_TV;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_marks);



        ((Button) findViewById(R.id.marks_title_bar_btn)).setTypeface(Typeface.createFromAsset(getAssets(), "font/kreon.ttf"));
        this.True_Ans_TV = (TextView) findViewById(R.id.True_Ans_Que);
        this.Ans_Total_TV = (TextView) findViewById(R.id.plus_ques_marks);
        this.False_Ans_TV = (TextView) findViewById(R.id.false_marks_textview);
        this.True_Ans_TV.setText("" + AsadQuiz.True_Ans_Que);
        this.Ans_Total_TV.setText("" + AsadQuiz.Count_Question_Quiz);
        this.False_Ans_TV.setText("" + AsadQuiz.False_Ans_Que);
        if (AsadQuiz.True_Ans_Que >= 8) {
            ((ImageView) findViewById(R.id.result)).setBackgroundResource(R.drawable.marks_welldone_image);
        } else if (AsadQuiz.True_Ans_Que >= 6) {
            ((ImageView) findViewById(R.id.result)).setBackgroundResource(R.drawable.marks_avrage_image);
        } else {
            ((ImageView) findViewById(R.id.result)).setBackgroundResource(R.drawable.marks_five_belove_image);
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AsadQuiz.CurrentQuestion = 0;
        AsadQuiz.False_Ans_Que = 0;
        AsadQuiz.Count_Question_Quiz = 1;
        AsadQuiz.True_Ans_Que = 0;
        AsadQuiz.Start_Ques_Clicks = 0;
    }
}
