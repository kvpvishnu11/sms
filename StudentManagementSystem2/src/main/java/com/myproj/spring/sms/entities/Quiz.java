package com.myproj.spring.sms.entities;

/** Entity to store the Quiz information in the database table **/

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long question_id;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String right_answer;
	private long course_id;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public long getQuestionId() {
		return question_id;
	}

	public void setQuestionId(long question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getRight_answer() {
		return right_answer;
	}

	public void setRight_answer(String right_answer) {
		this.right_answer = right_answer;
	}

	public long getCourseId() {
		return course_id;
	}

	public void setCourseId(long course_id) {
		this.course_id = course_id;
	}

	public Quiz(long question_id, String question, String option1, String option2, String option3, String option4,
			String right_answer, long course_id) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.right_answer = right_answer;
		this.course_id = course_id;
	}

	public Quiz() {
		super();
	}

}
