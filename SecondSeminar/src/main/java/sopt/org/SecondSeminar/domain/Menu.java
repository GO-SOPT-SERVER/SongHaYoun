package sopt.org.SecondSeminar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class Menu {

    private long id;
    private String name;
    private int price;
    public Menu(String name,int price){
        this.name=name;
        this.price=price;
    }
    public void setId(long id){
        this.id=id;
    }

}
