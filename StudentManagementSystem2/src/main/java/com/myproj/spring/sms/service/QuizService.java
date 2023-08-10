package com.myproj.spring.sms.service;

/** Service interface that contains methods for Getting quizzes, deleting old quizzes, submit quiz and calculate marks **/

import java.util.List;

import com.myproj.spring.sms.dto.QuizSubmissionDTO;
import com.myproj.spring.sms.entities.Quiz;

public interface QuizService {
	
	public List<Quiz> saveNewQuiz(List<Quiz> q); 
	
	public List<Quiz> getQuiz(long id);
	
	public void deleteQuiz(long courseid);

	public int calculateMarks(List<QuizSubmissionDTO> quizSubmissions,long courseId);
}
