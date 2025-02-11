package com.safronovbr.corse2.сontroller;

import com.safronovbr.corse2.domain.Question;
import com.safronovbr.corse2.service.api.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }


    @GetMapping("/get/{amount}")
    public List<Question> getRandomQuestion(@PathVariable Integer amount) {
        return examinerService.getQuestions(amount);
    }
}

