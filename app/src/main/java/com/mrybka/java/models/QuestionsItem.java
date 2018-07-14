package com.mrybka.java.models;


import com.google.gson.annotations.SerializedName;

import java.util.List;


public class QuestionsItem {

    @SerializedName("right_answers")
    private List<String> rightAnswers;

    @SerializedName("question")
    private String question;

    @SerializedName("wrong_answers")
    private List<String> wrongAnswers;

    public List<String> getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(List<String> rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public String getQestion() {
        return question;
    }

    public void setQestion(String qestion) {
        this.question = qestion;
    }

    public List<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(List<String> wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }
}