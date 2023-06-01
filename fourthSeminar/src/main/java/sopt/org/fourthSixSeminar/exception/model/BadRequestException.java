package sopt.org.fourthSixSeminar.exception.model;

import sopt.org.fourthSixSeminar.exception.Error;

public class BadRequestException extends sopt.org.fourthSeminar.exception.model.SoptException {
    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
