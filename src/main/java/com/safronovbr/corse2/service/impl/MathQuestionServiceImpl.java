package com.safronovbr.corse2.service.impl;

import com.safronovbr.corse2.domain.Question;
import com.safronovbr.corse2.exception.QuestionAddedException;
import com.safronovbr.corse2.exception.QuestionNotFoundException;
import com.safronovbr.corse2.repository.QuestionRepository;
import com.safronovbr.corse2.service.api.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service("MathQuestionServiceImpl")
public class MathQuestionServiceImpl implements QuestionService {
    private static final String[] OPERATORS = {"+", "-", "/", "*"};

    private final QuestionRepository mathQuestionRepository;

    public MathQuestionServiceImpl(QuestionRepository questionRepository) {
        this.mathQuestionRepository = questionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (mathQuestionRepository.getAllQuestion().contains(question)) {
            throw new QuestionAddedException();
        }
        return mathQuestionRepository.addQuestion(question);
    }

    @Override
    public void remove(String question, String answer) {
        Question questionModel = new Question(question, answer);
        if (!mathQuestionRepository.removeQuestion(questionModel)) {
            throw new QuestionNotFoundException();
        }
    }

    @Override
    public List<Question> getAll() {
        return mathQuestionRepository.getAllQuestion();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int first = random.nextInt(10);
        int last = random.nextInt(10);
        int generateOperators = random.nextInt(4);
        int result = getResult(generateOperators, first, last);
        String question = first + OPERATORS[generateOperators] + last;
        String answer = String.valueOf(result);
        return new Question(question, answer);
    }

    private int getResult(Integer generateOperators, Integer first, Integer last) {
        int result;
        switch (OPERATORS[generateOperators]) {
            case "+" -> result = first + last;
            case "-" -> result = first - last;
            case "/" -> result = last != 0 ? first / last : -1;
            case "*" -> result = first * last;
            default -> result = -1;
        }
        return result;
    }

}
