package com.myproj.spring.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.spring.sms.entities.Quiz;
import com.myproj.spring.sms.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("/savenewquiz")
	public List<Quiz> saveAllQuestions(@RequestBody List<Quiz> q){
		
		List<Quiz> q1 = quizService.saveNewQuiz(q);
		return q1;
	}
	
	@GetMapping("/fetchquiz/{cid}")
	public List<Quiz> getQuizQuestions(@PathVariable("cid") long courseid){
		
		return quizService.getQuiz(courseid);
		
	}
	
	@DeleteMapping("/deletequiz/{cid}")
	public void deleteQuizQuestions(@PathVariable("cid") long courseid){
		
		 quizService.deleteQuiz(courseid);		
	}
	
}
