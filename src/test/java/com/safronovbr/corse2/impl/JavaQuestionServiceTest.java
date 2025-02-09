package com.safronovbr.corse2.impl;

import com.safronovbr.corse2.domain.Question;
import com.safronovbr.corse2.exception.QuestionAddedException;
import com.safronovbr.corse2.exception.QuestionNotFoundException;
import com.safronovbr.corse2.repository.QuestionRepository;
import com.safronovbr.corse2.service.impl.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    private QuestionRepository questionRepository;
    private JavaQuestionService javaQuestionService;
    private Question questionModel;
    private Question questionModel2;


    public List<Question> questions;

    @BeforeEach
    public void setUp() {
        questionModel = new Question("QestionText", "QuestionAnswer");
        questionModel2 = new Question("QestionText2", "QuestionAnswer2");
        questionRepository = new QuestionRepository();
        javaQuestionService = new JavaQuestionService(questionRepository);
        questionRepository.addQuestion(questionModel);
        questionRepository.addQuestion(questionModel2);
        questions = List.of(questionModel, questionModel2);
    }

    @Test
    public void addJavaQuestion() {
        Question questionModel3 = new Question("QustionText3", "QuestionAnswerText3");

        javaQuestionService.add(questionModel3);

        List<Question> resultQuestion = questionRepository.getAllQuestion();
        assertTrue(resultQuestion.contains(questionModel3));
        assertEquals(3, resultQuestion.size());
    }

    @Test
    public void removeJavaQuestion() {
        javaQuestionService.remove(questionModel.getQuestion(), questionModel.getAnswer());

        List<Question> resultQuestion = questionRepository.getAllQuestion();
        assertFalse(resultQuestion.contains(questionModel));
        assertEquals(2, resultQuestion.size());
    }

    @Test
    public void getRandomJavaQuestion() {
        Question question = javaQuestionService.getRandomQuestion();

        List<Question> resultQuestion= questionRepository.getAllQuestion();
        assertTrue(resultQuestion.contains(question));
    }

    @Test
    public void addQuestionWithException() {
        assertThrows(QuestionAddedException.class, () -> javaQuestionService.add(questionModel));
    }
    @Test
    public void removeQuestionWithException() {
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove("random", "Quest"));
    }
}