package com.example.lastfresh.controller.user;


import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.UserVO;
import com.example.lastfresh.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/*유저 아이디찾기, 비밀번호찾기, 비밀번호 재설정, 회원가입, 로그인*/

@Controller
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserManaingController {
    // 현진용
    private final UserService userService;
    private final UserRepository userRepository;

    //회원가입
    @PostMapping("/manage/userJoin")
    public String Join(UserVO userVO) {
        userService.join(userVO);
        return "user/manage/userLogin";
    }

    //로그인
    // @RequestMapping(value="/index", method= {{RequestMethod.GET, RequestMethod.POST})
    @PostMapping("manage/userLogin")
    public String login(@RequestParam String userId, String userPw, HttpServletRequest request, RedirectAttributes rttr, Model model) throws Exception {
        Long userNumber = 0L;
        userNumber = userService.login(userId, userPw);
        HttpSession session = request.getSession();


        if (userNumber == null) {//로그인실패
            model.addAttribute("msg", "로그인실패");
            return "user/manage/userLogin"; //로그인으로 이동
        } else {
            session.setAttribute("userNumber", userNumber);
            return "main/main";

            //return "user/manage/userLogin";
        }
    }


    //회원유형
    @PostMapping("/manage/userSelect")
    public String userSelect(String selector, Model model) {


        String userStatus = this.getUserStatus(selector);
        model.addAttribute("userStatus", userStatus);
        return "user/manage/userJoin";
    }

    ;

    private String getUserStatus(String selector) {
        if ("일반회원".equals(selector)) {
            return "1";
        }

        if ("판매자".equals(selector)) {
            return "2";
        }

        if ("라이더".equals(selector)) {
            return "3";
        }

        return "0";

    }

    //휴대폰인증
    @GetMapping("/manage/phoneCheck")
    public @ResponseBody
    String sendSMS(String userPhone) {

        Random rand = new Random();
        String numStr = "";
        for (int i = 0; i < 4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr += ran;
        }
        System.out.println("수신자 번호 : " + userPhone);
        System.out.println("인증번호 : " + numStr);
        userService.certifiedPhoneNumber(userPhone, numStr);
        return numStr;
    }


    //아이디 중복검사
    @GetMapping("/manage/IDCheck/{userId}")
    @ResponseBody
    public JSONObject checkId(HttpServletRequest req, @PathVariable("userId") String userId) {
        //파라미터는 form태그처럼 페이지 이동으로 받을때, pathVariable은 페이지이동 없는 ajax로 받을때. @ResponseBody 줘야함
        JSONObject obj = new JSONObject();
        if (userService.checkId(userId)) {
            obj.put("status", "not-ok");
        } else {
            obj.put("status", "ok");
        }
        return obj;
    }

    //이메일 중복검사
    @GetMapping("/manage/EmailCheck/{userEmail}")
    @ResponseBody
    public JSONObject checkEmail(HttpServletRequest req, @PathVariable("userEmail") String userEmail) {
        //파라미터는 form태그처럼 페이지 이동으로 받을때, pathVariable은 페이지이동 없는 ajax로 받을때. @ResponseBody 줘야함
        JSONObject obj = new JSONObject();
        if (userService.checkEmail(userEmail)) {
            obj.put("status", "not-ok");
        } else {
            obj.put("status", "ok");
        }
        return obj;
    }


    //단순페이지 이동
    @GetMapping("/manage/userFindId")
    public void useFindId() {
    }

    ;

    @GetMapping("/manage/userSelect")
    public void userSelect() {
    }

    ;

    @GetMapping("/manage/userFindPw")
    public void userFindPw() {
    }

    ;

    @GetMapping("/manage/userNewPw")
    public void userNewPw() {
    }

    ;

    @GetMapping("/manage/userJoin")
    public void userJoin() {
    }

    ;

    @GetMapping("/manage/userLogin")
    public void userLogin() {
    }

    ;


}