package com.es.api.exception;

import com.es.api.config.security.ErrorCode;
import lombok.Getter;

@Getter
public class RestException extends RuntimeException{
    private ErrorCode errorCode;

    public RestException(){
        super();
    }

    public RestException(final String message) {
        super(message);
    }

    public RestException(ErrorCode errorCode ){
        super(errorCode.getDetail());
        this.errorCode = errorCode;
    }

}
