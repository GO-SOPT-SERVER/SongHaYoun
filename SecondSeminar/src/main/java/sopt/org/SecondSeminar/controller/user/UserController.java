package sopt.org.SecondSeminar.controller.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sopt.org.SecondSeminar.controller.user.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.service.UserService;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/user")
    public String register(@RequestBody final RegisterRequestDto request) {
//        System.out.println("성별: " + request.getGender());
//        System.out.println("이름: " + request.getName());
//        System.out.println("전화번호: " + request.getContact());
//        System.out.println("나이: " + request.getAge());

        Long userId=userService.register(request);
        System.out.println(userList.get(userId.intValue()-1).toString());

        // 서비스 계층에 유저를 등록하는 메서드를 호출

        return "유저 등록이 완료됐습니다.";
    }
    @GetMapping("/user/{userId}")
    public String getOne(@PathVariable final Long userId){
        System.out.println("요청 유저 아이디: "+userId);
        return "안녕"+userId+"야";
    }

    @GetMapping("/user/search")
    public String search(@RequestParam final String name){
        System.out.println("유저 이름 검색 인자: "+name);
        return name+"을 검색해했어요";
    }
}