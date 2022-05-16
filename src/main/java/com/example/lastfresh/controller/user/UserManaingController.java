package com.example.lastfresh.controller.user;



import com.example.lastfresh.domain.vo.UserVO;
import com.example.lastfresh.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
/*유저 아이디찾기, 비밀번호찾기, 비밀번호 재설정, 회원가입, 로그인*/

@Controller
@Slf4j
@RequestMapping("/user/*")
public class UserManaingController {
    // 현진용
    @Autowired
    UserService userService;

    //회원가입
    @PostMapping("/manage/userJoin")
    public String Join(UserVO userVO){
        userService.join(userVO);
        return "user/manage/userLogin";
    }

    //회원유형
    @PostMapping("/manage/userSelect")
    public String userSelect(String selector, Model model){


        String userStatus = this.getUserStatus(selector);
        model.addAttribute("userStatus", userStatus);
        return "user/manage/userJoin";
    };

    private String getUserStatus(String selector) {
        if("일반회원".equals(selector)) {
            return "1";
        }

        if("판매자".equals(selector)) {
            return "2";
        }

        if("라이더".equals(selector)) {
            return "3";
        }

        return "0";

    }

    //단순페이지 이동
    @GetMapping("/manage/userFindId")
    public void useFindId(){};

    @GetMapping("/manage/userSelect")
    public void userSelect(){};

    @GetMapping("/manage/userFindPw")
    public void userFindPw(){};

    @GetMapping("/manage/userNewPw")
    public void userNewPw(){};

    @GetMapping("/manage/userJoin")
    public void userJoin(){};

    @GetMapping("/manage/userLogin")
    public void userLogin(){};


}