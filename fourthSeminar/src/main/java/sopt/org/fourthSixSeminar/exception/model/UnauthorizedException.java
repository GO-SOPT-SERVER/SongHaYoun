package sopt.org.fourthSixSeminar.exception.model;

import lombok.Getter;
import sopt.org.fourthSixSeminar.exception.Error;

@Getter
public class UnauthorizedException extends sopt.org.fourthSeminar.exception.model.SoptException {
    public UnauthorizedException(Error error, String message) {
        super(error, message);
    }
}
