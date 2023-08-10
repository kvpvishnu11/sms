 package com.myproj.spring.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproj.spring.sms.controllers.QuizController;
import com.myproj.spring.sms.dto.QuizSubmissionDTO;
import com.myproj.spring.sms.entities.Quiz;
import com.myproj.spring.sms.repositories.QuizRepository;
import com.myproj.spring.sms.service.QuizService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(QuizController.class)
public class QuizControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    
    

    @MockBean
    private QuizService quizService;
    
    // We are Following 3 steps in every test case here
    // Preparing the test data for my service method 
    // Mocking my service method
    // Comparing the result 

    
    /** Testing if all the questions can be saved **/
    @Test
    public void testSaveAllQuestions() throws Exception {
        List<Quiz> quizList = new ArrayList<>();
        quizList.add(new Quiz(1L, "What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris", 1L));
        quizList.add(new Quiz(2L, "What is 2 + 2?", "3", "4", "5", "6", "4", 1L));
 
        Mockito.when(quizService.saveNewQuiz(Mockito.anyList())).thenReturn(quizList);

        mockMvc.perform(MockMvcRequestBuilders.post("/quiz/savenewquiz")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(quizList)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(quizList.size()));
    }
    
    /** Testing if all the questions in a quiz can be fetched **/
    @Test
    public void testGetQuizQuestions() throws Exception {
        long courseId = 1L;

        List<Quiz> quizList = new ArrayList<>();
        quizList.add(new Quiz(1L, "What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris", 1L));
        quizList.add(new Quiz(2L, "What is 2 + 2?", "3", "4", "5", "6", "4", 1L));
 
        Mockito.when(quizService.getQuiz(courseId)).thenReturn(quizList);

        mockMvc.perform(MockMvcRequestBuilders.get("/quiz/fetchquiz/{cid}", courseId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(quizList.size()));
    }
    
    /** Testing if all the questions in a course for its quiz can be deleted **/
    @Test
    public void testDeleteQuizQuestions() throws Exception {
        long courseId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/quiz/deletequiz/{cid}", courseId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(quizService, Mockito.times(1)).deleteQuiz(courseId);
    }
    
    /** Testing when the quiz is submitted, marks can be calcualated and sent back **/
    @Test
    public void testSubmitAndCalculateMarksWithValidCourseId() throws Exception {
        List<QuizSubmissionDTO> quizSubmissions = new ArrayList<>();
        quizSubmissions.add(new QuizSubmissionDTO(1L, "Paris", 1L));
        quizSubmissions.add(new QuizSubmissionDTO(2L, "4", 1L));

        // Create mock quiz questions list
        List<Quiz> mockQuizQuestions = new ArrayList<>();
        mockQuizQuestions.add(new Quiz(1L, "What is the capital of France?", "Paris", "London", "Berlin", "Madrid", "Paris", 1L));
        mockQuizQuestions.add(new Quiz(2L, "What is 2 + 2?", "3", "4", "5", "6", "4", 1L));

        int calculatedMarks = 0;

        for (QuizSubmissionDTO submission : quizSubmissions) {
            Long questionId = submission.getQuestionId();
            String chosenAnswer = submission.getChoosen_answer();

            Quiz quizQuestion = getQuizQuestionById(mockQuizQuestions, questionId);

            if (quizQuestion != null && chosenAnswer.equals(quizQuestion.getRight_answer())) {
                calculatedMarks++;
            }
        }

        Mockito.when(quizService.calculateMarks(Mockito.anyList(), Mockito.eq(1L)))
                .thenReturn(calculatedMarks);

        mockMvc.perform(MockMvcRequestBuilders.post("/quiz/submitquiz")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(quizSubmissions)))
                .andExpect(MockMvcResultMatchers.status().isOk()) // Expecting an OK status
                .andExpect(MockMvcResultMatchers.content().string(String.valueOf(calculatedMarks))); // Expected marks as response content
    }

    private Quiz getQuizQuestionById(List<Quiz> quizQuestions, Long questionId) {
        for (Quiz quizQuestion : quizQuestions) {
            if (quizQuestion.getQuestionId() == questionId) {
                return quizQuestion;
            }
        }
        return null;
    }

  


}
