package sopt.org.SecondSeminar.controller.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.SecondSeminar.controller.menu.dto.request.RequestMenuDto;
import sopt.org.SecondSeminar.domain.Menu;
import sopt.org.SecondSeminar.service.MenuService;
import sopt.org.SecondSeminar.service.PostService;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    @PostMapping("/menu")
    public void uploadMenu(@RequestBody RequestMenuDto requestMenuDto){
        menuService.RegisterMenu(requestMenuDto);
    }
    

}
