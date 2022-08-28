package com.unitech.exception;

import com.unitech.codeEnum.ErrorCodeEnum;
import jdk.dynalink.linker.LinkerServices;
import org.apache.logging.log4j.EventLogger;
import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class,
            HttpMediaTypeNotAcceptableException.class, UnsatisfiedServletRequestParameterException.class,
            MissingServletRequestParameterException.class,
            MethodNotAllowedException.class
    })
    public ResponseEntity<?> employeeNotNull (Exception ex){
        List<String> detail = new ArrayList<>();
        detail.add(ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Employee not null",detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UniTechException.class)
    public ResponseEntity<?> employeeNotFound(UniTechException employeeNotFoundException){
        List<String> detail = new ArrayList<>();
        detail.add(employeeNotFoundException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse("Employee not found",detail);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + "-" + fieldError.getDefaultMessage())
                .distinct()
                .collect(Collectors.toList());
        ErrorResponse errorResponse = new ErrorResponse(ErrorCodeEnum.VALIDATION_ERRORS.name(),errorMessages);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        String message = NestedExceptionUtils.getMostSpecificCause(e).getMessage();
        ErrorResponse errorResponse = new ErrorResponse(ErrorCodeEnum.VALIDATION_ERRORS.name(),List.of(message));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleAllOthers(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCodeEnum.VALIDATION_ERRORS.name(),List.of(e.getMessage()));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorResponse);
    }
}
