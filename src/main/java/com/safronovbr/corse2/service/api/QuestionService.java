package com.safronovbr.corse2.service.api;

import com.safronovbr.corse2.domain.Question;

import java.util.List;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    void remove(String question, String answer);

    List<Question> getAll();

    Question getRandomQuestion();
}
