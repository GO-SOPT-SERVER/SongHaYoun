package sopt.org.ThirdSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sopt.org.ThirdSeminar.controller.dto.request.PostRequestDto;
import sopt.org.ThirdSeminar.controller.dto.response.PostResponseDto;
import sopt.org.ThirdSeminar.domain.Post;
import sopt.org.ThirdSeminar.domain.User;
import sopt.org.ThirdSeminar.infrastructure.PostRepository;
import sopt.org.ThirdSeminar.infrastructure.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    @Transactional
    public PostResponseDto create(PostRequestDto postRequestDto){

        User user=userRepository.getOne(postRequestDto.getCreated_userId());
        Post post= Post.builder()
                .title(postRequestDto.getTitle())
                .content(postRequestDto.getContent())
                .created_user(user)
                .build();

        return PostResponseDto.of(post.getTitle(),post.getContent(),user.getNickname());
    }

    @Transactional
    public PostResponseDto search(Long postId){

        Post post= postRepository.getOne(postId);
        User user=post.getCreated_user();
        System.out.println(user);
        PostResponseDto postResponseDto=PostResponseDto.of(post.getTitle(),post.getContent(),user.getNickname());

        return postResponseDto;
    }

    @Transactional
    public List<PostResponseDto> searchByTitle(String title){
        List<Post> postList=postRepository.findAllByTitle(title);
        
        List<PostResponseDto> responseList=new ArrayList<PostResponseDto>();

        for (Post post:postList
             ) {
            User user=post.getCreated_user();
            responseList.add(PostResponseDto.of(post.getTitle(),post.getContent(),user.getNickname()));
            
        }

        return responseList;
    }
}
