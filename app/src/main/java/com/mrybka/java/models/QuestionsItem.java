package com.mrybka.java.models;


import com.google.gson.annotations.SerializedName;


public class QuestionsItem{

	@SerializedName("right_answer")
	private String rightAnswer;

	@SerializedName("qestion")
	private String qestion;

	@SerializedName("wrong_answer_1")
	private String wrongAnswer1;

	@SerializedName("wrong_answer_2")
	private String wrongAnswer2;

	@SerializedName("wrong_answer_3")
	private String wrongAnswer3;

	public void setRightAnswer(String rightAnswer){
		this.rightAnswer = rightAnswer;
	}

	public String getRightAnswer(){
		return rightAnswer;
	}

	public void setQestion(String qestion){
		this.qestion = qestion;
	}

	public String getQestion(){
		return qestion;
	}

	public void setWrongAnswer1(String wrongAnswer1){
		this.wrongAnswer1 = wrongAnswer1;
	}

	public String getWrongAnswer1(){
		return wrongAnswer1;
	}

	public void setWrongAnswer2(String wrongAnswer2){
		this.wrongAnswer2 = wrongAnswer2;
	}

	public String getWrongAnswer2(){
		return wrongAnswer2;
	}

	public void setWrongAnswer3(String wrongAnswer3){
		this.wrongAnswer3 = wrongAnswer3;
	}

	public String getWrongAnswer3(){
		return wrongAnswer3;
	}

	@Override
 	public String toString(){
		return 
			"QuestionsItem{" + 
			"right_answer = '" + rightAnswer + '\'' + 
			",qestion = '" + qestion + '\'' + 
			",wrong_answer_1 = '" + wrongAnswer1 + '\'' + 
			",wrong_answer_2 = '" + wrongAnswer2 + '\'' + 
			",wrong_answer_3 = '" + wrongAnswer3 + '\'' + 
			"}";
		}
}