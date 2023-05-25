package sopt.org.fourthSixSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSixSeminar.common.dto.ApiResponse;
import sopt.org.fourthSixSeminar.controller.dto.request.UserRequestDto;
import sopt.org.fourthSixSeminar.controller.dto.response.UserResponseDto;
import sopt.org.fourthSixSeminar.exception.Success;
import sopt.org.fourthSixSeminar.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponse.success(Success.SIGNUP_SUCCESS, userService.create(request));
    }
}