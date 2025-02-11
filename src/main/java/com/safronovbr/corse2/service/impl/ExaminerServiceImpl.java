package com.safronovbr.corse2.service.impl;

import com.safronovbr.corse2.domain.Question;
import com.safronovbr.corse2.service.api.ExaminerService;
import com.safronovbr.corse2.service.api.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final List<QuestionService> questionServices;


    public ExaminerServiceImpl(List<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }


    @Override
    public List<Question> getQuestions(Integer amount) {
        List<Question> randomQuestions = new ArrayList<>();
        for (int i = 0; i < amount; ) {
            QuestionService questionService = questionServices.get(new Random().nextInt(2));
            Question randomQuestion = questionService.getRandomQuestion();
            if (!randomQuestions.contains(randomQuestion)) {
                randomQuestions.add(randomQuestion);
                i++;
            }
        }
        return randomQuestions;
    }
}
