package sopt.org.SecondSeminar.domain;

import lombok.Getter;


@Getter
public class User {

    public User(Long id,String gender,String name,String contact,int age){
        this.id=id;
        this.gender=gender;
        this.name=name;
        this.contact=contact;
        this.age=age;
    }

    private Long id;
    private String gender;
    private String name;
    private String contact;
    private int age;


}
