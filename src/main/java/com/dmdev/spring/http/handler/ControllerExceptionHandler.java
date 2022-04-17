package com.dmdev.spring.http.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice(basePackages = "com.dmdev.spring.http.controller")
public class ControllerExceptionHandler /*extends ResponseEntityExceptionHandler*/ {

//    @ExceptionHandler(Exception.class)
//    public String handleExceptions(Exception exception, HttpServletRequest request) {
//        log.error("Failed to return response", exception);
//        return "error/error500";
//    }
}
