package com.myproj.spring.sms.dto;

/**
 * This DTO is used to process the request for a Post Request in Quiz Controller
 **/

public class QuizSubmissionDTO {

	private Long question_id;
	private String choosen_answer;
	private long course_id;

	/** Getters and Setters Methods for all the elements present **/
	/** This is how we implemented data encapsulation - OOPS **/

	public Long getQuestionId() {
		return question_id;
	}

	public void setQuestionId(Long question_id) {
		this.question_id = question_id;
	}

	public String getChoosen_answer() {
		return choosen_answer;
	}

	public void setChoosenAnswer(String choosen_answer) {
		this.choosen_answer = choosen_answer;
	}

	public long getCourseId() {
		return course_id;
	}

	public void setCourseId(long course_id) {
		this.course_id = course_id;
	}

	public QuizSubmissionDTO(Long question_id, String choosen_answer, long course_id) {
		super();
		this.question_id = question_id;
		this.choosen_answer = choosen_answer;
		this.course_id = course_id;
	}

}
