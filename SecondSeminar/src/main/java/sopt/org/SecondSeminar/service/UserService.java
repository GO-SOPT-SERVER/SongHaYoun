package sopt.org.SecondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.user.dto.request.RegisterRequestDto;
import sopt.org.SecondSeminar.domain.User;

import static sopt.org.SecondSeminar.SecondSeminarApplication.userList;

@Service
public class UserService {
    public Long register(RegisterRequestDto request){

        User newUser=new User(request.getGender(),request.getName(),request.getContact(),request.getAge());

        userList.add(newUser);
        newUser.setId((long)userList.size());

        return newUser.getId();
    }
}
