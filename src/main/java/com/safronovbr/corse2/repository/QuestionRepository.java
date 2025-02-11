package com.safronovbr.corse2.repository;

import com.safronovbr.corse2.domain.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionRepository {
    private final List<Question> QUESTION_LIST = new ArrayList<>();

    public Question addQuestion(String question, String answer) {
        return addQuestion(new Question(question, answer));
    }

    public Question addQuestion(Question question) {
        QUESTION_LIST.add(question);
        return question;
    }

    public List<Question> getAllQuestion() {
        return QUESTION_LIST;
    }

    public boolean removeQuestion(Question question) {
        return QUESTION_LIST.remove(question);
    }

    public Question getQuestion(Integer index) {
        return QUESTION_LIST.get(index);
    }

    public Integer getSizeList() {
        return QUESTION_LIST.size();
    }
}
