package ru.itis.okno.backend.dto.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.itis.okno.backend.exceptions.ApplicationException;

import java.util.List;

@Data
@Schema(description = "Ответ.")
public class Response<T> {

    @Schema(description = "Данные.")
    public T data;

    public Boolean isSuccess;

    public List<ErrorDto> errors;

    public Response(T data) {
        this.data = data;
        this.isSuccess = true;
    }

    public Response(List<ErrorDto> errors) {
        this.errors = errors;
        this.isSuccess = false;
    }

    public static <T> Response<T> of(T data) {
        return new Response<>(data);
    }

    public static <T> Response<T> of(ApplicationException ex) {
        ErrorDto error = new ErrorDto(ex.getMessage(), ex.getDetails());
        return new Response<>(List.of(error));
    }

    public static <T> Response<T> of(Throwable ex) {
        ErrorDto error = new ErrorDto(ex.getMessage(), "");
        return new Response<>(List.of(error));
    }

    public static <T> Response<T> of(List<ErrorDto> errors) {
        return new Response<>(errors);
    }
}
