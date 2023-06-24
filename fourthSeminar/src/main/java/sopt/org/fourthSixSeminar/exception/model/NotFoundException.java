package sopt.org.fourthSixSeminar.exception.model;

import sopt.org.fourthSixSeminar.exception.Error;

public class NotFoundException extends sopt.org.fourthSeminar.exception.model.SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}