package com.myproj.spring.sms.dto;

public class QuizSubmissionDTO {
	
	private Long question_id;
	private String choosen_answer;
	private long course_id;
	public Long getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Long question_id) {
		this.question_id = question_id;
	}
	public String getChoosen_answer() {
		return choosen_answer;
	}
	public void setChoosen_answer(String choosen_answer) {
		this.choosen_answer = choosen_answer;
	}
	public long getCourse_id() {
		return course_id;
	}
	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}
	public QuizSubmissionDTO(Long question_id, String choosen_answer, long course_id) {
		super();
		this.question_id = question_id;
		this.choosen_answer = choosen_answer;
		this.course_id = course_id;
	}
	

}
