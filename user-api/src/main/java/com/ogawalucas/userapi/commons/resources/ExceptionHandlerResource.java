package com.ogawalucas.userapi.commons.resources;

import com.ogawalucas.userapi.commons.entities.ExceptionMessage;
import com.ogawalucas.userapi.commons.expections.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerResource {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ExceptionMessage handlerNotFound(NotFoundException ex) {
        return new ExceptionMessage(ex.getMessage());
    }
}
