package sopt.org.fourthSixSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sopt.org.fourthSixSeminar.common.dto.ApiResponse;
import sopt.org.fourthSixSeminar.config.resolver.UserId;
import sopt.org.fourthSixSeminar.controller.dto.request.BoardImageListRequestDto;
import sopt.org.fourthSixSeminar.exception.Success;
import sopt.org.fourthSixSeminar.external.client.aws.S3Service;
import sopt.org.fourthSixSeminar.service.BoardService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final S3Service s3Service;
    private final BoardService boardService;

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse create(
            @UserId Long userId,
            @ModelAttribute @Valid final BoardImageListRequestDto request) {
        List<String> boardThumbnailImageUrlList = s3Service.uploadImages(request.getBoardImages(), "board");
        boardService.create(userId, boardThumbnailImageUrlList, request);
        return ApiResponse.success(Success.CREATE_BOARD_SUCCESS);
    }
}