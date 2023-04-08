package sopt.org.SecondSeminar.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.post.dto.request.PostRequestDto;
import sopt.org.SecondSeminar.controller.post.dto.response.PostResponseDto;
import sopt.org.SecondSeminar.domain.Post;
import sopt.org.SecondSeminar.service.PostService;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @PostMapping("/post")
    public String register(@RequestBody final PostRequestDto request){

        postService.Post(request);

        return request.getTitle();
    }
    @GetMapping("/post/{postId}")
    public PostResponseDto getPost(@PathVariable final long postId){
        Post post=postList.get((int) (postId-1));
        PostResponseDto postResponseDto = PostResponseDto.newInstance(post.getTitle(),post.getCreate_user(),post.getContent());
        return postResponseDto;
    }


}
