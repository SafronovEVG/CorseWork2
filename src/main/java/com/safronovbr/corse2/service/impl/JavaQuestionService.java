package com.safronovbr.corse2.service.impl;

import com.safronovbr.corse2.domain.Question;
import com.safronovbr.corse2.exception.QuestionAddedException;
import com.safronovbr.corse2.exception.QuestionNotFoundException;
import com.safronovbr.corse2.repository.QuestionRepository;
import com.safronovbr.corse2.service.api.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("JavaQuestionService")
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;

    public JavaQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questionRepository.getAllQuestion().contains(question)) {
            throw new QuestionAddedException();
        }
        return questionRepository.addQuestion(question);
    }

    @Override
    public void remove(String question, String answer) {
        Question questionCurrent = new Question(question, answer);
        if (!questionRepository.removeQuestion(questionCurrent)) {
            throw new QuestionNotFoundException();
        }
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.getAllQuestion();
    }

    @Override
    public Question getRandomQuestion() {
        return questionRepository.getQuestion(new Random().nextInt(questionRepository.getSizeList()));
    }
}
