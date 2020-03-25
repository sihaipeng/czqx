package com.czqx.coupon.exception;

import com.czqx.ordinary.exception.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class CouponExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CouponException.class)
    public BaseResult handlerCouponExceprion(HttpServletRequest request, Throwable ex){
       log.error(ex.getMessage());
        return new BaseResult(getStatus(request).value(), ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
