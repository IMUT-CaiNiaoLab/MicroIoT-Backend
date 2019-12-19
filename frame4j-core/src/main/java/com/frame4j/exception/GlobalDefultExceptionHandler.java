package com.frame4j.exception;

import com.frame4j.common.utils.Frame4JResult;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一拦截异常
 */
@RestControllerAdvice
public class GlobalDefultExceptionHandler {


    private static Logger logger = LoggerFactory.getLogger(GlobalDefultExceptionHandler.class);


    //拦截未授权页面
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnauthorizedException.class)
    public String handleException(UnauthorizedException e) {
        logger.debug(e.getMessage());
        return "403";
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthorizationException.class)
    public String handleException2(AuthorizationException e) {
        logger.debug(e.getMessage());
        return "403";
    }

    //拦截所有异常
    @ExceptionHandler(Exception.class)
    public Frame4JResult handleValidationBodyException(Exception e) {
        logger.debug(e.getMessage());
        return Frame4JResult.build(500, e.getMessage());
    }

}
