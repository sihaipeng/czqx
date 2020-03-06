package com.czqx.ordinary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseException extends RuntimeException {

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }


    @ResponseBody
    @ExceptionHandler(BaseException.class)
    public BaseResult handleBaseException(Exception e){
        return new BaseResult(HttpStatus.BAD_REQUEST.value(),e.getMessage());
    }
}
