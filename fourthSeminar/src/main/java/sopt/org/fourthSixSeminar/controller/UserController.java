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

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<UserLoginResponseDto> login(@RequestBody @Valid final UserLoginRequestDto request){
        final Long userId=userService.login(request);
        final String token=jwtService.issuedToken(String.valueOf(userId));
        final String refresh=jwtService.generateRefreshToken(request);
        return ApiResponse.success(Success.LOGIN_SUCCESS,UserLoginResponseDto.of(userId,token,refresh));
    }

    @PostMapping("/refresh")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<String> refresh(@RequestHeader final String refreshToken){
        final String access=jwtService.genereateAccessByRefresh(refreshToken);
        return ApiResponse.success(Success.TOKEN_CREATED,access);
    }


}