package sopt.org.SecondSeminar.controller.menu;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sopt.org.SecondSeminar.controller.menu.dto.request.RequestMenuDto;
import sopt.org.SecondSeminar.controller.menu.dto.response.ResponseMenuDto;
import sopt.org.SecondSeminar.domain.Menu;
import sopt.org.SecondSeminar.service.MenuService;
import sopt.org.SecondSeminar.service.PostService;

import static sopt.org.SecondSeminar.SecondSeminarApplication.menuList;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;
    @PostMapping("/menu")
    public String uploadMenu(@RequestBody RequestMenuDto requestMenuDto){
        menuService.RegisterMenu(requestMenuDto);
        return requestMenuDto.getName()+"을 등록했습니다!";
    }
    @GetMapping("/menu/{menuId}")
    public ResponseEntity getMenu(@PathVariable final int menuId){
        if(menuList.size()<menuId){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        Menu menu=menuList.get(menuId-1);
        if(menu==null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        ResponseMenuDto responseMenuDto=ResponseMenuDto.newInstance(menu.getName(),menu.getPrice());
        HttpHeaders httpHeaders=new HttpHeaders();

        return new ResponseEntity(responseMenuDto,httpHeaders,HttpStatus.OK);
    }


}
