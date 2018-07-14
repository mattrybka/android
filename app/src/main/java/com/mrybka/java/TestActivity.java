package com.mrybka.java;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.TextView;

import com.mrybka.java.models.Questions;
import com.mrybka.java.models.QuestionsItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.question)
    TextView question;
    @BindViews({R.id.answer_1, R.id.answer_2, R.id.answer_3, R.id.answer_4})
    List<CheckBox> answersButtons;
    private List<Integer> answers = new ArrayList<>();
    private Questions questions;
    private int number = 0;
    private QuestionsItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        initQestions();
    }

    private void initQestions() {
        RawJsonGenerator rawJsonGenerator = new RawJsonGenerator();
        questions = rawJsonGenerator.getJsonFileAsClass(this, R.raw.questions, Questions.class);
        nextQuestion();
    }

    private void nextQuestion() {
        if (number < questions.getQuestions().size()) {
            item = questions.getQuestions().get(number);
            question.setText(item.getQestion());
            ArrayList answers = new ArrayList<String>();
            answers.addAll(item.getRightAnswers());
            answers.addAll(item.getWrongAnswers());
            Collections.shuffle(answers);
            for (int i = 0; i < 4; i++) {
                answersButtons.get(i).setChecked(false);
                answersButtons.get(i).setText(((String) answers.get(i)));
            }
            number++;
        } else {//End questions
            int goodQuestions = 0;
            for (Integer in : answers) {
                if (in.equals(1)) {
                    goodQuestions++;
                }
            }
            new AlertDialog.Builder(this)
                    .setTitle("Koniec testu!")
                    .setMessage("Wynik: " + goodQuestions + "/" + answers.size())
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .show();
        }
    }

    @OnClick(R.id.button)
    public void clcikOnButton() {
        algorithmForEachQuestions();
        nextQuestion();
    }

    private void algorithmForEachQuestions() {
        for (CheckBox checkBox : answersButtons) {
            boolean isGoodAnswer = item.getRightAnswers().contains(checkBox.getText().toString());
            if ((checkBox.isChecked() && !isGoodAnswer) || (!checkBox.isChecked() && isGoodAnswer)) {
                answers.add(0);
                return;
            }
        }
        answers.add(1);
    }
}
