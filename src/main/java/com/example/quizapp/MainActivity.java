package com.example.quizapp;

import static com.example.quizapp.R.id.idTVQuestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTV,questionNumberTV;
    private Button option1Btn,option2Btn,option3Btn,option4Btn;
    private ArrayList<QuizModel> quizModelArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizModelArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModelArrayList);
        currentPos = random.nextInt(quizModelArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizModelArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is \n"+currentScore + "/15");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizModelArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
    private void setDataToViews(int currentPos) {
        questionNumberTV.setText("Questions Attempted : "+questionAttempted + "/15");
        if(questionAttempted == 15){
            showBottomSheet();
        }else {
            questionTV.setText(quizModelArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModelArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModelArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModelArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModelArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModel> quizModelArrayList) {
        quizModelArrayList.add(new QuizModel("Giddha is the folk dance of ?","Ahemdabad","Deharadun","Punjab","Agra","Punjab"));
        quizModelArrayList.add(new QuizModel("Highest dam of India is ?","Tehri Dam","Hirakud Dam","Koyna Dam","Mettur Dam","Tehri Dam"));
        quizModelArrayList.add(new QuizModel("Sun is a ?","Planet","Mettaloid","Star","Constellations","Star"));
        quizModelArrayList.add(new QuizModel("How many seconds make an hour ?","1234","2400","4590","3600","3600"));
        quizModelArrayList.add(new QuizModel("Which color symbolies peace ?","Lemon color","Green color","White color","Red color","White color"));
        quizModelArrayList.add(new QuizModel("How many years are there in one Millenium ?","10 years","100 years","1,000 years","10,000 years","1,000 years"));
        quizModelArrayList.add(new QuizModel("Festival of colors know as ?","Diwali","Rangoli","Holi","Christmas","Holi"));
        quizModelArrayList.add(new QuizModel("What is the gas absorbed by plants ?","Oxygen","Nitrogen","Carbon Dioxide","Monoxide","Carbon Dioxide"));
        quizModelArrayList.add(new QuizModel("Which is the smallest continent ?","Asia","Australia","Africa","Antartica","Australia"));
        quizModelArrayList.add(new QuizModel("National Heritage animal of India ?","Rabbit","Elephant","Lion","Tiger","Elephant"));
        quizModelArrayList.add(new QuizModel("Which city is also know as Pink City ?","Hyderabad","Jaipur","Banglore","Kolkata","Jaipur"));
        quizModelArrayList.add(new QuizModel("Which bird is known for it's Intelligence ?","Parrot","Owl","Sparrow","Peacock","Owl"));
        quizModelArrayList.add(new QuizModel("How many players are in a cricket team ?","9","10","11","12","11"));
        quizModelArrayList.add(new QuizModel("Rainbow is in which color format ?","VIBORGY","YGVIBOR","VIBGYOR","VIBGYRO","VIBGYOR"));
        quizModelArrayList.add(new QuizModel("World cup is held after every ?","1 year","2 years","3 years","4 years","3 years"));
    }
}
