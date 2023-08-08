package com.employee.portal.ControllerAdvice;

import com.employee.portal.exception.EmployeeNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@RestControllerAdvice
public class ControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)

    @ExceptionHandler(EmployeeNotFoundException.class)
    public Error employeeNotFoundException(EmployeeNotFoundException ex ,HandlerMethod handlerMethod, HttpServletRequest request){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Error error = Error.builder()
                      .errorCode(HttpStatus.NOT_FOUND.value())
                      .message(ex.getMessage())
                      .servicePath(request.getServletPath())
                      .methodName(handlerMethod.getMethod().getName())
                      .timeStamp(formatter.format(System.currentTimeMillis()))
                      .build();
        return error;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> inputError(MethodArgumentNotValidException ex, HandlerMethod method, HttpServletRequest request){
        Map<String,String> errorMap = new HashMap<>();
         ex.getBindingResult().getFieldErrors().forEach(error -> errorMap.put(error.getField(),error.getDefaultMessage()));
        return errorMap;

    }

}

@Data
@Builder
 class Error
{
String message;
int errorCode;

String servicePath;

String methodName;

String timeStamp;


}