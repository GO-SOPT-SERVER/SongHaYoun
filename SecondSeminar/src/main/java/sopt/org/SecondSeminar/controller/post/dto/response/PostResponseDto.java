package sopt.org.SecondSeminar.controller.post.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {

    private String title;
    private String create_user;
    private String content;

    public static PostResponseDto newInstance(String title,String create_user,String content) {
        return new PostResponseDto(title,create_user,content);
    }
}
