package com.myproj.spring.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.entities.Quiz;
import com.myproj.spring.sms.repositories.QuizRepository;

@Component
public class QuizImpl implements QuizService {
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public List<Quiz> saveNewQuiz(List<Quiz> q) {
		
		return quizRepository.saveAll(q);
	}

	@Override
	public List<Quiz> getQuiz(long id) {
		 
		return quizRepository.getQuizQuestions(id);
	}

}
