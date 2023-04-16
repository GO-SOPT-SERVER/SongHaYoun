package sopt.org.SecondSeminar.controller.menu.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMenuDto {
    private String name;
    private int price;
}
