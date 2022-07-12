package com.es.api.exception;

import com.es.api.config.security.ErrorCode;

public class AuthException extends RestException {
    public AuthException() {
        super();
    }

    public AuthException(ErrorCode errorCode ){
        super(errorCode);
    }
}
