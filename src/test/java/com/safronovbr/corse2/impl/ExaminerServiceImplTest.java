package com.safronovbr.corse2.impl;

import com.safronovbr.corse2.domain.Question;
import com.safronovbr.corse2.service.api.ExaminerService;
import com.safronovbr.corse2.service.api.QuestionService;
import com.safronovbr.corse2.service.impl.ExaminerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;

    private Question questionModel;
    private Question questionModel2;
    private ExaminerService examinerService;

    @BeforeEach
    public void setQuestionService() {
        questionModel = new Question("Question", "Answer");
        questionModel2 = new Question("QuestionText", "AnswerText");
        examinerService = new ExaminerServiceImpl(List.of(questionService, questionService));
        when(questionService.getRandomQuestion()).thenReturn(questionModel).thenReturn(questionModel2);
    }

    @Test
    public void test() {
        List<Question> questionList = List.of(questionModel, questionModel2);

        List<Question> questions = examinerService.getQuestions(2);

        assertEquals(questionList, questions);
    }
}