package com.antonov.keystorage.rest.advice;

import com.antonov.keystorage.rest.dto.ErrorDTO;
import com.antonov.keystorage.rest.dto.ErrorResponseDTO;
import com.antonov.keystorage.rest.dto.ValidationErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO<ErrorDTO>> handleException(Exception exception) {
        var body = new ErrorResponseDTO<>(List.of(new ErrorDTO(exception.getMessage())));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO<ErrorDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorDTO> errors = getErrors(exception);

        var body = new ErrorResponseDTO<>(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    private List<ErrorDTO> getErrors(MethodArgumentNotValidException exception) {
        return exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(this::createError)
                .collect(Collectors.toList());
    }

    private ErrorDTO createError(ObjectError error) {
        if (error instanceof FieldError) {
            FieldError fieldError = (FieldError) error;
            return new ValidationErrorDTO(
                    fieldError.getDefaultMessage(),
                    fieldError.getField(),
                    fieldError.getRejectedValue()
            );
        }
        return new ErrorDTO(error.getDefaultMessage());
    }
}
