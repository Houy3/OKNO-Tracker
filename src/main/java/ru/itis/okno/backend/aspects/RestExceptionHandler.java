package ru.itis.okno.backend.aspects;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.itis.okno.backend.dto.base.Response;
import ru.itis.okno.backend.exceptions.ApplicationException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public Response<Object> handleApplicationException(ApplicationException ex) {
        return Response.of(ex);
    }

    @ExceptionHandler(Throwable.class)
    public Response<Object> handleThrowable(Throwable ex) {
        return Response.of(ex);
    }
}
