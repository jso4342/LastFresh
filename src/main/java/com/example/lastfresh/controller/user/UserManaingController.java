package com.example.lastfresh.controller.user;



import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*유저 아이디찾기, 비밀번호찾기, 비밀번호 재설정, 회원가입, 로그인*/

@Controller
@Slf4j
@RequestMapping("/user/*")
//void는 똑같은 경로로 리턴
public class UserManaingController {

    @GetMapping("/manage/userJoin")
    public void userJoin(){};

    @GetMapping("/manage/userLogin")
    public void userLogin(){};

    @GetMapping("/manage/userSelect")
    public void userSelect(){};

    @GetMapping("/manage/useFindId")
    public void useFindId(){};

    @GetMapping("/manage/userFindPw")
    public void userFindPw(){};

    @GetMapping("/manage/userNewPw")
    public void userNewPw(){};
}
