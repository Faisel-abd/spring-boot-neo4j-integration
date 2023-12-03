package com.trainig.neo4jboot.integration.errorHandler;

import com.trainig.neo4jboot.integration.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleExceptions( RuntimeException throwable){

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        log.error(Constants.ERROR_GLOBAL_MESSAGE,throwable);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .headers(responseHeaders)
                .body(ResponseError.builder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(Constants.ERROR_GLOBAL_MESSAGE).build());
    }
}
