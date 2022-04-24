package com.cubicfox.handlers;

import com.cubicfox.exceptions.FeignClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({FeignClientException.class})
    public ResponseEntity<Object> handleBinanceApiException(FeignClientException ex) {
        return new ResponseEntity<>(
                new ErrorDto(
                        Collections.singletonList(
                                new ErrorDto.Details(ex.getMessage())
                        )
                ),
                HttpStatus.valueOf(ex.getStatus())
        );
    }

    public static class ErrorDto {
        private final List<Details> errors;

        public ErrorDto(List<Details> errors) {
            this.errors = errors;
        }

        public List<Details> getErrors() {
            return errors;
        }

        public static final class Details {
            private final String description;

            public Details(String description) {
                this.description = description;
            }

            public String getDescription() {
                return description;
            }
        }
    }
}
