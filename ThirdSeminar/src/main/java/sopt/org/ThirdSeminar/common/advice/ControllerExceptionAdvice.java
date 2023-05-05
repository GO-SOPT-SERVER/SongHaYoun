package sopt.org.ThirdSeminar.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sopt.org.ThirdSeminar.exception.ErrorStatus;
import sopt.org.thirdSeminar.common.dto.ApiResponseDto;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e){
        return ApiResponseDto.error(ErrorStatus.VALIDATION_REQUEST_MISSING_EXCEPTION);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    protected ApiResponseDto handleEntityNotFoundException(final EntityNotFoundException e){
        return ApiResponseDto.error(ErrorStatus.NOT_FOUND_USER);
    }

}
