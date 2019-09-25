package com.github.tulliocba.money.api.exceptionhandler;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * All classes that extends ResponseEntityExceptionHandler are be able to handler all
 * exception throw outed by RequestMapping methods
 */
@ControllerAdvice /* <-- This one annotation, makes MoneyApiExceptionHandler an interceptor */
public class MoneyApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String userMessage = messageSource.getMessage("invalid.message", null, LocaleContextHolder.getLocale());
        String developerMessage = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
        return handleExceptionInternal(ex, Arrays.asList(new ApiError(userMessage, developerMessage)), headers,status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, buildErrorsList(ex.getBindingResult()), headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class})
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request){
        String userMessage = messageSource.getMessage("resource.not.found", null, LocaleContextHolder.getLocale());
        String developerMessage = ex.toString();
        return handleExceptionInternal(ex, Arrays.asList(new ApiError(userMessage, developerMessage)), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request){
        String userMessage = messageSource.getMessage("resource.operation.not.allowed", null, LocaleContextHolder.getLocale());
        String developerMessage = ExceptionUtils.getRootCauseMessage(ex);
        return handleExceptionInternal(ex, Arrays.asList(new ApiError(userMessage, developerMessage)), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private List<ApiError> buildErrorsList(BindingResult bindingResult) {
      return bindingResult.getFieldErrors()
              .stream()
              .map(fieldError -> new ApiError(messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()), fieldError.toString()))
              .collect(Collectors.toList());
    }

    public static class ApiError {
        private String userMessage;
        private String developerMessage;

        public ApiError(String userMessage, String developerMessage) {
            this.userMessage = userMessage;
            this.developerMessage = developerMessage;
        }

        public String getUserMessage() {
            return userMessage;
        }

        public String getDeveloperMessage() {
            return developerMessage;
        }
    }
}
