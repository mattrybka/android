package com.mrybka.java.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Questions {

    @SerializedName("questions")
    private List<QuestionsItem> questions;

    public List<QuestionsItem> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsItem> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return
                "Questions{" +
                        "questions = '" + questions + '\'' +
                        "}";
    }
}