package com.example.lastfresh.controller.user;


import com.example.lastfresh.domain.vo.UserVO;
import com.example.lastfresh.service.user.MyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
/*유저 마이 페이지*/

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/myPage/*")
public class UserMyPageController {
    private final MyPageService myPageService;


    //회원 정보 수정 페이지
    @GetMapping("/myChangeInfo")
    public void myChangeInfo(Long userNum, HttpServletRequest request, Model model) throws Exception {
        model.addAttribute("user", myPageService.get(userNum));
    };

    //정보 수정
    @PostMapping("/modify")
    public RedirectView modify(UserVO userVO, RedirectAttributes rttr) throws Exception {
        String result = null;
        Long userNum = userVO.getUserNum();

        rttr.addAttribute("userNum", userNum);
        rttr.addAttribute("result", myPageService.modify(userVO, userNum) ? "success" : "failure");

        return new RedirectView("myChangeInfo");
    };


    // 비밀번호 확인 페이지
    @GetMapping("/myCheckPw")
    public void myCheckPw(Long userNum, HttpServletRequest request, Model model) throws Exception {
        model.addAttribute("user", myPageService.get(userNum));
    }

    // 비밀번호 확인
/*    @PostMapping("/myCheckPw")
    public RedirectView verify(Long userNum, String userPw, Model model) throws Exception {
        String result = null;

         model.addAttribute("result", myPageService.checkPw(userNum, userPw) ? "success" : "failure");
        if (myPageService.checkPw(userNum, userPw) == true){
            model.addAttribute("user", myPageService.get(userNum));
            return new RedirectView("myChangeInfo");
        }else{
            return new RedirectView("myCheckPw");
        }*/



    @GetMapping("/myOrder")
    public void myOrder(){}

    @GetMapping("/myOrderDetail")
    public void myOrderDetail(){}

    @GetMapping("/myReviewUnwritten")
    public void myReviewUnwritten(){}

    @GetMapping("/myReviewWrite")
    public void myReviewWrite(){}

    @GetMapping("/myReviewWritten")
    public void myReviewWritten(){}

}