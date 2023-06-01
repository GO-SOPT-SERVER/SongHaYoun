package sopt.org.fourthSixSeminar.exception.model;

import sopt.org.fourthSixSeminar.exception.Error;

public class ConflictException extends sopt.org.fourthSeminar.exception.model.SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}