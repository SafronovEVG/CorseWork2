package com.safronovbr.corse2.service.api;

import com.safronovbr.corse2.domain.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(Integer amount);
}
