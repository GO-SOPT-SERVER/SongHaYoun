package sopt.org.ThirdSeminar.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "created_user")
    private List<Post> posts=new ArrayList<Post>();
    @Builder
    public User(String nickname,String email,String password){
        this.nickname=nickname;
        this.email=email;
        this.password=password;
        this.posts=new ArrayList<Post>();
    }


}
