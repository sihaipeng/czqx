package com.czqx.ordinary.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
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
        System.out.println("==========================>");
        log.error(e.getMessage());
        return new BaseResult(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }
}
