package com.myproj.spring.sms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproj.spring.sms.dto.QuizSubmissionDTO;
import com.myproj.spring.sms.dto.ResultDTO;
import com.myproj.spring.sms.entities.Quiz;
import com.myproj.spring.sms.service.QuizService;

/**
 * This controller handles the requests to save new quizzes, delete old quizzes,
 * fetch quizzes using course id
 **/

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

	/** Saving new quizzes from teacher portal **/
	@PostMapping("/savenewquiz")
	public ResponseEntity<?> saveAllQuestions(@RequestBody List<Quiz> q) {
		if (q == null || q.isEmpty()) {
			return ResponseEntity.badRequest().body("Request body is empty.");
		} else {
			List<Quiz> savedQuizzes = quizService.saveNewQuiz(q);
			return ResponseEntity.ok(savedQuizzes);
		}
	}

	/** Fetch and show the quizzes to students using course id **/
	@GetMapping("/fetchquiz/{cid}")
	public ResponseEntity<?> getQuizQuestions(@PathVariable("cid") Long courseId) {
		// Check if the courseId is null or invalid
		if (courseId == null || courseId <= 0) {
			return ResponseEntity.badRequest().body("Invalid Course ID.");
		}

		List<Quiz> quizzes = quizService.getQuiz(courseId);
		if (quizzes == null || quizzes.isEmpty()) {
			return ResponseEntity.badRequest().body("No such Course ID in the System.");
		}

		return ResponseEntity.ok(quizzes);
	}

	/** Deleting old quizzes in the system **/
	@DeleteMapping("/deletequiz/{cid}")
	public ResponseEntity<String> deleteQuizQuestions(@PathVariable("cid") Long courseId) {
		// Check if the courseId is null or invalid
		if (courseId == null || courseId <= 0) {
			return ResponseEntity.badRequest().body("Invalid course ID.");
		}

		quizService.deleteQuiz(courseId);

		return ResponseEntity.ok("Quiz questions deleted successfully.");
	}

	/** When a quiz is submitted, calculate and return the marks secured **/
	@PostMapping("/submitquiz/")
	public ResponseEntity<?> submitAndCalculateMarks(@RequestBody List<QuizSubmissionDTO> qs) {
		Long courseId = null;

		for (QuizSubmissionDTO submission : qs) {
			courseId = submission.getCourseId();

			break;
		}

		if (courseId == null) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course ID not found in the submission list.");
		}

		int result = quizService.calculateMarks(qs, courseId);

		return ResponseEntity.ok(result);
	}

}
