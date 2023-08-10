package com.myproj.spring.sms.service;

/** Implementation class that performs all crud operations for quiz controller**/
/** Implements functionality like Getting quizzes, deleting old quizzes, submit quiz and calculate marks **/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myproj.spring.sms.dto.QuizSubmissionDTO;
import com.myproj.spring.sms.entities.Quiz;
import com.myproj.spring.sms.repositories.QuizRepository;

import jakarta.transaction.Transactional;

@Component
public class QuizImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;

	/** save a new quiz into the system **/

	@Transactional
	@Override
	public List<Quiz> saveNewQuiz(List<Quiz> q) {

		return quizRepository.saveAll(q);
	}

	/** Get a Quiz using the course id **/
	@Override
	public List<Quiz> getQuiz(long id) {

		return quizRepository.getQuizQuestions(id);
	}

	// Teachers will be able to delete the old quiz before adding new quiz

	@Transactional
	@Override
	public void deleteQuiz(long courseid) {

		quizRepository.deleteQuizQuestionsByCourseId(courseid);
	}

	// Once user submits the quiz, calculate their marks and return it
	@Override
	public int calculateMarks(List<QuizSubmissionDTO> quizSubmissions, long courseId) {

		int totalMarks = 0;

		List<Quiz> quizQuestions = quizRepository.getQuizQuestions(courseId);

		for (QuizSubmissionDTO submission : quizSubmissions) {
			Long questionId = submission.getQuestionId();
			String chosenAnswer = submission.getChoosen_answer();

			Quiz quizQuestion = findQuizQuestionById(quizQuestions, questionId);

			if (quizQuestion != null && chosenAnswer.equals(quizQuestion.getRight_answer())) {

				totalMarks++;
			}
		}
		System.out.println("Score = " + totalMarks);
		return totalMarks;

	}

	/** Find the question using its id from the Quiz table **/
	private Quiz findQuizQuestionById(List<Quiz> quizQuestions, Long questionId) {
		for (Quiz quizQuestion : quizQuestions) {
			if (quizQuestion.getQuestionId() == questionId) {
				return quizQuestion;
			}
		}
		return null;
	}

}
