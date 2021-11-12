package com.ammar.assignment.quizapp.khel;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.ammar.assignment.quizapp.R;
import com.ammar.assignment.quizapp.ToastClass;
import com.ammar.assignment.quizapp.Utility;
import com.kaopiz.kprogresshud.KProgressHUD;


public class AsadQuiz extends AppCompatActivity {

    TextView Display_Quest_Ans;
    Button Choice_One_Question;
    Button Choice_Two_Question;
    Button Choice_Three_Question;
    Button Choice_Four_Question;
    public static int Count_Question_Quiz = 1;
    public static int CurrentQuestion = 0;

    Animation Anim_Bounce;
    Animation Daba_Thi_Jamnu;
    Animation Jamna_thi_Dabu;

    public static int Start_Ques_Clicks = 0;
    public static int End_Ques_Int = 0;


    public static int True_Ans_Que = 0;
    public static int False_Ans_Que = 0;

    private KProgressHUD hud;
    TextView nameRollNumber;
    String[] True_Ans_List;
    String[] List_OF_ALL_Question;
    String[] Question_One_Strng;
    String[] Question_Two_Strng;
    String[] Question_Three_Strng;
    String[] Question_Four_Strng;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_quiz_play_view);
        this.Display_Quest_Ans = (TextView) findViewById(R.id.user_display_ques_box);
        this.Choice_One_Question = (Button) findViewById(R.id.choice_one_ques_btn);
        this.Choice_Two_Question = (Button) findViewById(R.id.choice_two_ques_btn);
        this.Choice_Three_Question = (Button) findViewById(R.id.choice_three_ques_btn);
        this.Choice_Four_Question = (Button) findViewById(R.id.choice_four_ques_btn);
        nameRollNumber=findViewById(R.id.nameRollNumber);
        this.Daba_Thi_Jamnu = AnimationUtils.loadAnimation(this, R.anim.question_dabe_thi_jamnu_anima);
        this.Jamna_thi_Dabu = AnimationUtils.loadAnimation(this, R.anim.question_jamne_thi_dabu_anima);
        this.Anim_Bounce = AnimationUtils.loadAnimation(this, R.anim.animation_bounce_gk);

        this.Choice_One_Question.startAnimation(this.Daba_Thi_Jamnu);
        this.Choice_Two_Question.startAnimation(this.Jamna_thi_Dabu);
        this.Choice_Three_Question.startAnimation(this.Daba_Thi_Jamnu);
        this.Choice_Four_Question.startAnimation(this.Jamna_thi_Dabu);
        this.Display_Quest_Ans.startAnimation(this.Anim_Bounce);
        Typeface Custom_Font_Text = Typeface.createFromAsset(getAssets(), "font/kreon.ttf");
        ((TextView) findViewById(R.id.question_count_title)).setTypeface(Custom_Font_Text);
        nameRollNumber.setText(Utility.name+"("+Utility.rollNumber+")");
        this.Display_Quest_Ans.setTypeface(Custom_Font_Text);
        this.Choice_One_Question.setTypeface(Custom_Font_Text);
        this.Choice_Three_Question.setTypeface(Custom_Font_Text);
        this.Choice_Four_Question.setTypeface(Custom_Font_Text);
        this.Choice_Two_Question.setTypeface(Custom_Font_Text);


//        this.List_OF_ALL_Question = new String[]{"Q_1. When did the 6-ball over in test cricket start?", "Q_2. भारत विश्व कप क्रिकेट का चैम्पियन कब बना", "Q_3. निम्नलिखित में कौन सा देश अंतराष्ट्रीय क्रिकेट नही खेलता है", "Q_4. निम्नलिखित में से कौन सा देश अंतराष्ट्रीय क्रिकेट नही खेलता है", "Q_5. डीकथलॉन क्या है", "Q_6. निम्नलिखित T-20 क्रिकेट नियमों में कौन सा सही नही बताया गया है", "Q_7. निम्नलिखित में से क्या किसी खेल का नाम नही है", "Q_8. 1975 के स्वर्ण पदक विजेता विश्वकप हॉकी के भारतीय टीम के कप्तान कौन थे", "Q_9. राष्ट्रीय खेल दिवस 29 अगस्त को मनाया जाता है यह किस से सम्बन्धित है", "Q_10. निम्नलिखित में से किस गेंदबाज़ ने टेस्ट क्रिकेट में 500 से अधिक विकेट लिए है"};
//        this.Question_One_Strng = new String[]{"1896", "1979 ई०", "रूस", "जापान", "10 किमी०रेस", "हर पारी की समय सीमा 75 मिनट होती है उसके बाद बॉल किये जाने पर हर ओवर के लिए बैटिंग कर रही टीम को 6 अतिरिक्त रन मिलते है", "बिलियर्ड्स", "अमन सिंह", "ध्यानचंद", "वसीम अकरम"};
//        this.Question_Two_Strng = new String[]{"1900", "1983 ई०", "इंग्लैंड", "न्यूजीलैंड", "10 आइटम की प्रतियोगिता", "यदि विकेट गिरने के बाद 90 सेकंड के भीतर बैट्समैन क्रीज़ पर न पहुंचे तो बालिंग कर रही टीम को दंड के 5 अतिरिक्त रन मिलते है", "पोलो", "अजित पाल सिंह", "मिल्खा सिंह", "कपिल देव"};
//        this.Question_Three_Strng = new String[]{"1904", "1987 ई०", "द.अफ्रीका", "ऑस्ट्रेलिया", "मैराथन दौड़ का एक अंग", "एक बालर एक पारी में अधिकतम 6 ओवर बॉल कर सकता है", "ब्रिज", "रूप सिंह", "दिलीप सिंह", "ग्लेन मैक्ग्राथ"};
//        this.Question_Four_Strng = new String[]{"1928", "1992 ई०", "पकिस्तान", "बंगलादेश", "लेक्रॉस", "पारी के पहले 6 ओवर के लिए फील्डिंग प्रतिबंध लागु होता है", "ओलम्पिक", "संदीप सिंह", "सी.के.नायडू", "मैल्कोम मार्शल"};
//        this.True_Ans_List = new String[]{"1900", "1983 ई०", "रूस", "जापान", "10 आइटम की प्रतियोगिता", "एक बालर एक पारी में अधिकतम 6 ओवर बॉल कर सकता है", "ओलम्पिक", "अजित पाल सिंह", "ध्यानचंद", "ग्लेन मैक्ग्राथ"};

        this.List_OF_ALL_Question = new String[]{"Q_1. When did the 6-ball over in test cricket start?", "Q_2. When did India become the champion of world cup cricket?", "Q_3. Which of the following country does not play international cricket", "Q_4. Which of the following country does not play international cricket", "Q_5. what is decathlon", "Q_6. Which one of the following T-20 cricket rules is not correct?", "Q_7. Which of the following is not the name of a game", "Q_8. Who was the captain of the Indian team of 1975 gold medal winning world cup hockey", "Q_9. National Sports Day is celebrated on 29 August, it is related to", "Q_10. Which of the following bowler has taken more than 500 wickets in Test cricket?"};
        this.Question_One_Strng = new String[]{"1896 ", "1979", "Russia", "Japan", "km race", "Each innings has a time limit of 75 minutes, after which the batting team gets 6 extra runs for every over that is bowled.", "billiards", "Aman Singh", "Dhyan Chand", "Wasim Akram"};
        this.Question_Two_Strng = new String[]{"1900", "1983", "England", "New Zealand", "10 item contest", "If the batsman does not reach the crease within 90 seconds after the fall of the wicket, then the team bowling gets 5 extra runs of penalty.", "polo", "Ajit Pal Singh", "Milkha Singh", "Kapil Dev"};
        this.Question_Three_Strng = new String[]{"1904 ", "1987 ", "africa", "Australia", "part of a marathon", "A bowler can bowl a maximum of 6 overs in an innings.", "bridge", "Roop Singh", "Dilip Singh", "Glenn McGrath"};
        this.Question_Four_Strng = new String[]{"1928 ", "1992 ", "Pakistan", "Bangladesh", "Lacrosse", "Fielding restrictions apply for the first 6 overs of an innings", "olympics", "Sandeep Singh", "CK Naidu", "Malcolm Marshall"};
        this.True_Ans_List = new String[]{"1900", "1983", "Russia", "Japan", "10 item contest", "A bowler can bowl a maximum of 6 overs in an innings.", "olympics", "Ajit Pal Singh", "Dhyan Chand", "Glenn McGrath"};
        this.Display_Quest_Ans = (TextView) findViewById(R.id.user_display_ques_box);
        this.Display_Quest_Ans.setText(this.List_OF_ALL_Question[CurrentQuestion]);
        this.Choice_One_Question = (Button) findViewById(R.id.choice_one_ques_btn);
        this.Choice_Two_Question = (Button) findViewById(R.id.choice_two_ques_btn);
        this.Choice_Three_Question = (Button) findViewById(R.id.choice_three_ques_btn);
        this.Choice_Four_Question = (Button) findViewById(R.id.choice_four_ques_btn);
        this.Choice_One_Question.setText(this.Question_One_Strng[CurrentQuestion]);
        this.Choice_Two_Question.setText(this.Question_Two_Strng[CurrentQuestion]);
        this.Choice_Three_Question.setText(this.Question_Three_Strng[CurrentQuestion]);
        this.Choice_Four_Question.setText(this.Question_Four_Strng[CurrentQuestion]);
        End_Ques_Int = CurrentQuestion + 9;
    }



    public void Question_Next_Click(View view) {
        if (CurrentQuestion >= End_Ques_Int) {
            startActivity(new Intent(getApplicationContext(), MarksActivity.class));
            finish();
        } else if (Start_Ques_Clicks == 0) {
            ToastClass.info(getApplicationContext(), "Choose Your Answer", DEFAULT_KEYS_DISABLE, true).show();
        } else {
            CurrentQuestion++;
            Count_Question_Quiz++;
            ((TextView) findViewById(R.id.question_count_title)).setText(Count_Question_Quiz + "/10");
            this.Choice_One_Question.setEnabled(true);
            this.Choice_Two_Question.setEnabled(true);
            this.Choice_Three_Question.setEnabled(true);
            this.Choice_Four_Question.setEnabled(true);
            this.Display_Quest_Ans = (TextView) findViewById(R.id.user_display_ques_box);
            this.Choice_One_Question = (Button) findViewById(R.id.choice_one_ques_btn);
            this.Choice_Two_Question = (Button) findViewById(R.id.choice_two_ques_btn);
            this.Choice_Three_Question = (Button) findViewById(R.id.choice_three_ques_btn);
            this.Choice_Four_Question = (Button) findViewById(R.id.choice_four_ques_btn);
            this.Display_Quest_Ans.setText(this.List_OF_ALL_Question[CurrentQuestion]);
            this.Choice_One_Question.setText(this.Question_One_Strng[CurrentQuestion]);
            this.Choice_Two_Question.setText(this.Question_Two_Strng[CurrentQuestion]);
            this.Choice_Three_Question.setText(this.Question_Three_Strng[CurrentQuestion]);
            this.Choice_Four_Question.setText(this.Question_Four_Strng[CurrentQuestion]);
            this.Choice_One_Question.setBackgroundResource(R.drawable.drawable_select_question_border);
            this.Choice_Two_Question.setBackgroundResource(R.drawable.drawable_select_question_border);
            this.Choice_Three_Question.setBackgroundResource(R.drawable.drawable_select_question_border);
            this.Choice_Four_Question.setBackgroundResource(R.drawable.drawable_select_question_border);
            Start_Ques_Clicks = 0;
            this.Daba_Thi_Jamnu = AnimationUtils.loadAnimation(this, R.anim.question_dabe_thi_jamnu_anima);
            this.Jamna_thi_Dabu = AnimationUtils.loadAnimation(this, R.anim.question_jamne_thi_dabu_anima);
            this.Anim_Bounce = AnimationUtils.loadAnimation(this, R.anim.animation_bounce_gk);
            this.Choice_One_Question.startAnimation(this.Daba_Thi_Jamnu);
            this.Choice_Two_Question.startAnimation(this.Jamna_thi_Dabu);
            this.Choice_Three_Question.startAnimation(this.Daba_Thi_Jamnu);
            this.Choice_Four_Question.startAnimation(this.Jamna_thi_Dabu);
            this.Display_Quest_Ans.startAnimation(this.Anim_Bounce);
        }
    }

    public void choice_One_question_Click(View v) {
        String ans = this.True_Ans_List[CurrentQuestion];
        if (this.Choice_One_Question.getText().toString().equals(ans)) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                True_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.success(getApplicationContext(), "Correct Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_One_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
        } else if (this.Choice_Two_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_One_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
            this.Choice_Two_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
        } else if (this.Choice_Three_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_One_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
            this.Choice_Three_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
        } else if (this.Choice_Four_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_One_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
            this.Choice_Four_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
        }
    }

    public void choice_Two_question_Click(View v) {
        String ans = this.True_Ans_List[CurrentQuestion];
        if (this.Choice_One_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_Two_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
            this.Choice_One_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
        } else if (this.Choice_Two_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                True_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.success(getApplicationContext(), "Correct Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_Two_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
        } else if (this.Choice_Three_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_Two_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
            this.Choice_Three_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
        } else if (this.Choice_Four_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_Two_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
            this.Choice_Four_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
        }
    }

    public void choice_three_question_Click(View v) {
        String ans = this.True_Ans_List[CurrentQuestion];
        if (this.Choice_One_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_One_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
            this.Choice_Three_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
        } else if (this.Choice_Two_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_Two_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
            this.Choice_Three_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
        } else if (this.Choice_Three_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                True_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.success(getApplicationContext(), "Correct Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_Three_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
        } else if (this.Choice_Four_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_Three_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
            this.Choice_Four_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
        }
    }

    public void choice_Four_question_Click(View v) {
        String ans = this.True_Ans_List[CurrentQuestion];
        if (this.Choice_One_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_One_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
            this.Choice_Four_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
        } else if (this.Choice_Two_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_Two_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
            this.Choice_Four_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
        } else if (this.Choice_Three_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                False_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.error(getApplicationContext(), "Incorrect Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_Three_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
            this.Choice_Four_Question.setBackgroundResource(R.drawable.drawable_select_false_border);
        } else if (this.Choice_Four_Question.getText().toString().equals(ans.toString())) {
            if (Start_Ques_Clicks == 0) {
                Start_Ques_Clicks = 1;
                True_Ans_Que++;
                this.Choice_One_Question.setEnabled(false);
                this.Choice_Two_Question.setEnabled(false);
                this.Choice_Three_Question.setEnabled(false);
                this.Choice_Four_Question.setEnabled(false);
            }
            ToastClass.success(getApplicationContext(), "Correct Ans:", DEFAULT_KEYS_DISABLE, true).show();
            this.Choice_Four_Question.setBackgroundResource(R.drawable.drawable_select_true_border);
        }
    }

    @Override
    public void onBackPressed() {
        CurrentQuestion = 0;
        True_Ans_Que = 0;
        False_Ans_Que = 0;
        Start_Ques_Clicks = 0;
        Count_Question_Quiz = 1;
        super.onBackPressed();
    }
}
