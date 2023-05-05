package sopt.org.ThirdSeminar.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessStatus {


    SIGNUP_SUCCESS(HttpStatus.CREATED,"회원가입이 완료되었습니다"),
    SEARCH_SUCCESS(HttpStatus.OK,"유저 검색에 성공했습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
