package com.safronovbr.corse2.сontroller;

import com.safronovbr.corse2.exception.NotAccessException;
import com.safronovbr.corse2.service.api.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/math")
public class MathExamController {
    @Autowired
    @Qualifier("MathQuestionServiceImpl")
    private QuestionService questionService;

    @GetMapping("/add")
    public String addMathQuestion(@RequestParam String question, @RequestParam String answer) {
        throw new NotAccessException();
    }

    @GetMapping("/remove")
    public String removeMathQuestion(@RequestParam String question, @RequestParam String answer) {
        throw new NotAccessException();
    }
}
