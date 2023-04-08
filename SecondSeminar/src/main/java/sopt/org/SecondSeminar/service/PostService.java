package sopt.org.SecondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.post.dto.request.PostRequestDto;
import sopt.org.SecondSeminar.domain.Post;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@Service
public class PostService {
    public Long Post(PostRequestDto request){

        Post post=new Post(request.getTitle(),request.getCreate_user(), request.getContent());
        post.setId((long)postList.size()+1);
        postList.add(post);

        return post.getId();
    }
}
