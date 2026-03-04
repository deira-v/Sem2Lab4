package ie.atu.sem2lab4.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String HandleValidationException(MethodArgumentNotValidException ex){
        return "Error Occurred" + ex.getBindingResult().getFieldError().getDefaultMessage();

    }
}
