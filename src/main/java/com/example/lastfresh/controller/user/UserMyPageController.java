package com.example.lastfresh.controller.user;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/*유저 마이 페이지*/

@Controller
@Slf4j
@RequestMapping("/user/myPage/*")
public class UserMyPageController {

    @GetMapping("/myChangeInfo")
    public void myChangeInfo(){}

    @GetMapping("/myCheckPw")
    public void myCheckPw(){}

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