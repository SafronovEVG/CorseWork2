package com.safronovbr.corse2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceededNumberQuestionException extends RuntimeException {
    public ExceededNumberQuestionException(String message) {
        super(message);
    }

    public ExceededNumberQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceededNumberQuestionException() {
    }
}
