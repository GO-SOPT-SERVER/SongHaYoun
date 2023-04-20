package sopt.org.SecondSeminar.controller.menu.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMenuDto {
    private String name;
    private int price;

    public static ResponseMenuDto newInstance(String name,int price){
        return new ResponseMenuDto(name,price);
    }
}
