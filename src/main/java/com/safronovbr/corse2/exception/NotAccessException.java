package com.safronovbr.corse2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
public class NotAccessException extends RuntimeException {
    public NotAccessException(String message) {
        super(message);
    }

  public NotAccessException(String message, Throwable cause) {
    super(message, cause);
  }

  public NotAccessException() {
  }
}
