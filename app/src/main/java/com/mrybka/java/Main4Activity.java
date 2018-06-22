package com.mrybka.java;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mrybka.java.models.Questions;
import com.mrybka.java.models.QuestionsItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.question)
    TextView question;
    @BindViews({R.id.answer_1,R.id.answer_2,R.id.answer_3,R.id.answer_4})
    List<CheckBox> answersButtons;
    private Questions questions;
    private int number = 0;
    private QuestionsItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);
        for (CheckBox checkBox: answersButtons){
            checkBox.setOnClickListener(this);
        }
        initQestions();
    }

    private void initQestions() {
        RawJsonGenerator rawJsonGenerator = new RawJsonGenerator();
        questions = rawJsonGenerator.getJsonFileAsClass(this, R.raw.questions, Questions.class);
        nextQuestion();
    }

    private void nextQuestion() {
        if(number<questions.getQuestions().size()) {
            item = questions.getQuestions().get(number);
            question.setText(item.getQestion());
            ArrayList answers = new ArrayList<String>();
            answers.add(item.getRightAnswer());
            answers.add(item.getWrongAnswer1());
            answers.add(item.getWrongAnswer2());
            answers.add(item.getWrongAnswer3());
            Collections.shuffle(answers);
            for (int i=0;i<4;i++){
                answersButtons.get(i).setChecked(false);
                answersButtons.get(i).setText(((String) answers.get(i)));
            }
            number++;
        }else {
            Toast.makeText(this, "Noż pan żeś pan zajebisty", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        for (CheckBox checkBox: answersButtons){
            if(checkBox.getId() != v.getId()) {
                checkBox.setChecked(false);
            }
        }
    }

    @OnClick(R.id.button)
    public void clcikOnButton(){
        for (CheckBox checkBox: answersButtons){
            if(checkBox.isChecked()) {
                if(checkBox.getText().equals(item.getRightAnswer())){
                    Toast.makeText(this, "Dobre", Toast.LENGTH_SHORT).show();
                    nextQuestion();
                }else {
                    Toast.makeText(this, "Zjebałeś", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            }
        }
    }
}
