package sopt.org.ThirdSeminar.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String created_user;

    public static PostResponseDto of(Long id,String title,String content,String created_user){
        return new PostResponseDto(id,title,content,created_user);
    }
}
