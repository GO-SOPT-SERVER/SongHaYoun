package sopt.org.ThirdSeminar.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.ThirdSeminar.controller.dto.request.PostRequestDto;
import sopt.org.ThirdSeminar.controller.dto.response.PostResponseDto;
import sopt.org.ThirdSeminar.exception.SuccessStatus;
import sopt.org.ThirdSeminar.service.PostService;
import sopt.org.thirdSeminar.common.dto.ApiResponseDto;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post/create")
       public ApiResponseDto<PostResponseDto> crate(@RequestBody @Valid final PostRequestDto postRequestDto){
            return ApiResponseDto.success(SuccessStatus.CREATE_SUCCESS, postService.create(postRequestDto));
        }

}
