package sopt.org.SecondSeminar.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Menu {


    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int price;
}
