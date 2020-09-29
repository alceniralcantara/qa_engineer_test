package br.com.comexport.enums;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import br.com.comexport.exception.BadRequest;
import br.com.comexport.exception.QATestException;
import br.com.comexport.exception.NotFound;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum ExceptionsMessagesEnum {

    CPF_ALREADY_REGISTERED(BAD_REQUEST.value(),"Cpf already registered!", BadRequest.class),
    CPF_NOT_FOUND(NOT_FOUND.value(),"Cpf not found!", BadRequest.class);

    private Integer code;

    @Setter
    private String message;

    private Class<? extends QATestException> klass;

    ExceptionsMessagesEnum(int code, String message, Class<? extends QATestException> klass) {

         this.message = message;
         this.klass = klass;
         this.code = code;
    }
    
    public void raise() throws QATestException {

        if (BAD_REQUEST.value() == this.code) 
            throw new BadRequest(this.message);
        else
            throw new NotFound(this.message);
            
    }
    
}
