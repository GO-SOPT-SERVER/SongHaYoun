package sopt.org.fourthSixSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSixSeminar.common.dto.ApiResponse;
import sopt.org.fourthSixSeminar.config.jwt.JwtService;
import sopt.org.fourthSixSeminar.config.resolver.UserId;
import sopt.org.fourthSixSeminar.controller.dto.request.BoardRequestDto;
import sopt.org.fourthSixSeminar.exception.Success;
import sopt.org.fourthSixSeminar.service.BoardService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final JwtService jwtService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(@UserId Long userId, @RequestBody @Valid final BoardRequestDto request) {

        boardService.create(userId,request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}