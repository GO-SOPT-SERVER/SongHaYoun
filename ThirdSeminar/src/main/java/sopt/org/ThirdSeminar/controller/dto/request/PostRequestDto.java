package sopt.org.ThirdSeminar.controller.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostRequestDto {

    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private Long created_userId;
}
