package com.trainig.neo4jboot.integration.errorHandler;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseError {

    private int code;
    private String message;
}
