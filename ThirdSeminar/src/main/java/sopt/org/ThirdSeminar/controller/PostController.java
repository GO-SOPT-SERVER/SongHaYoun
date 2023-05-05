package sopt.org.ThirdSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.ThirdSeminar.controller.dto.request.PostRequestDto;
import sopt.org.ThirdSeminar.controller.dto.response.PostResponseDto;
import sopt.org.ThirdSeminar.exception.SuccessStatus;
import sopt.org.ThirdSeminar.service.PostService;
import sopt.org.thirdSeminar.common.dto.ApiResponseDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post/create")
    public ApiResponseDto<PostResponseDto> crate(@RequestBody @Valid final PostRequestDto postRequestDto){
        return ApiResponseDto.success(SuccessStatus.CREATE_SUCCESS, postService.create(postRequestDto));
    }
    @GetMapping("/post/{id}")
    public ApiResponseDto<PostResponseDto> search(@PathVariable final Long id){
        return ApiResponseDto.success(SuccessStatus.SEARCH_SUCCESS,postService.search(id));
    }
    @GetMapping("/post/search")
    public ApiResponseDto<List<PostResponseDto>> searchByTitle(@RequestParam final String title){
        return ApiResponseDto.success(SuccessStatus.SEARCH_SUCCESS,postService.searchByTitle(title));
    }

}
