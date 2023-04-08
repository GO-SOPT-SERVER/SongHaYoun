package sopt.org.SecondSeminar.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.SecondSeminar.controller.user.dto.request.RegisterRequestDto;

@RestController
public class UserController {

    @PostMapping("/user")
    public String register(@RequestBody final RegisterRequestDto request) {
        System.out.println("성별: " + request.getGender());
        System.out.println("이름: " + request.getName());
        System.out.println("전화번호: " + request.getContact());
        System.out.println("나이: " + request.getAge());

        // 서비스 계층에 유저를 등록하는 메서드를 호출

        return "유저 등록이 완료됐습니다.";
    }
    @GetMapping("/user")
    public String test(){
        return "안녕";
    }
}