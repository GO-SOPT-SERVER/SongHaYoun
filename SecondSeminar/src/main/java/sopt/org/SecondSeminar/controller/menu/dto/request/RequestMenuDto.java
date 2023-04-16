package sopt.org.SecondSeminar.controller.menu.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestMenuDto {
    private String name;
    private int price;
}
