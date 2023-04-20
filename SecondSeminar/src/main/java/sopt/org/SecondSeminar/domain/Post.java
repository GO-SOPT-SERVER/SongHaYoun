package sopt.org.SecondSeminar.domain;

import lombok.Getter;

@Getter
public class Post {
    public Post(String title,String create_user,String content){
        this.title=title;
        this.create_user=create_user;
        this.content=content;
    }
    public void setId(long id){
        this.id=id;
    }
    private Long id;
    private String title;
    private String create_user;
    private String content;

}
