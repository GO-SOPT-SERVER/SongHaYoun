package sopt.org.fourthSixSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSixSeminar.common.dto.ApiResponse;
import sopt.org.fourthSixSeminar.config.jwt.JwtService;
import sopt.org.fourthSixSeminar.controller.dto.request.UserLoginRequestDto;
import sopt.org.fourthSixSeminar.controller.dto.request.UserRequestDto;
import sopt.org.fourthSixSeminar.controller.dto.response.UserLoginResponseDto;
import sopt.org.fourthSixSeminar.controller.dto.response.UserResponseDto;
import sopt.org.fourthSixSeminar.exception.Success;
import sopt.org.fourthSixSeminar.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "유저 생성 API", description = "유저를 서버에 등록합니다.")
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary="유저 로그인",description = "로그인입니다.")
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request){
        final Long userId=userService.login(request);
        final String token=jwtService.issuedToken(String.valueOf(userId));
        return ApiResponse.success(Success.LOGIN_SUCCESS,UserLoginResponseDto.of(userId,token));
    }
}