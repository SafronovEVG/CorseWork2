package com.safronovbr.corse2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QuestionAddedException extends RuntimeException {
    public QuestionAddedException() {
    }

    public QuestionAddedException(String message) {
        super(message);
    }

    public QuestionAddedException(String message, Throwable cause) {
        super(message, cause);
    }
}
