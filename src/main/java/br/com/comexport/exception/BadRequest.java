package br.com.comexport.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class BadRequest extends QATestException {

    private static final long serialVersionUID = 1L;
    
    public BadRequest(final String message) {
        super(BAD_REQUEST, message);
    }
}
