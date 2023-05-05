package sopt.org.ThirdSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.ThirdSeminar.controller.dto.request.UserRequestDto;
import sopt.org.ThirdSeminar.controller.dto.response.UserResponseDto;
import sopt.org.ThirdSeminar.exception.SuccessStatus;
import sopt.org.ThirdSeminar.service.UserService;
import sopt.org.thirdSeminar.common.dto.ApiResponseDto;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request){
        return ApiResponseDto.success(SuccessStatus.SIGNUP_SUCCESS,userService.create(request));
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<UserResponseDto> search(@PathVariable @Valid final Long id){
        return ApiResponseDto.success(SuccessStatus.SEARCH_SUCCESS,userService.search(id));
    }
}
