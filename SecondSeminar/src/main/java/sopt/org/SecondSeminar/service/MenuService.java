package sopt.org.SecondSeminar.service;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.menu.dto.request.RequestMenuDto;
import sopt.org.SecondSeminar.domain.Menu;

import static sopt.org.SecondSeminar.SecondSeminarApplication.menuList;

@Service
public class MenuService {

    public String RegisterMenu(RequestMenuDto request){
        Menu menu=new Menu(request.getName(),request.getPrice());

        menuList.add(menu);
        return menu.getName()+"메뉴가 등록되었습니다!";

    }
}
