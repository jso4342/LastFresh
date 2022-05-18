package com.example.lastfresh.controller.user;

import com.example.lastfresh.mapper.user.UserFindMapper;
import com.example.lastfresh.service.user.UserFindService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Controller
@Slf4j
@RequestMapping("/find/*")
public class UserFindController {

    @Autowired
    UserFindService userFindService;
    @Autowired
    UserFindMapper userFindMapper;


    @GetMapping("/check/sendSMS")
    public @ResponseBody
    String sendSMS(String phoneNumber) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        userFindService.certifiedPhoneNumber(phoneNumber,numStr);

        return numStr;
    }

    @GetMapping("/phoneNumber")
    public String phoneNumber(String userPhone, Model model){
        /*log.info("-------------------------------");
        log.info("폰번호" + userPhone);
        log.info("-------------------------------");
        log.info("-------------------------------");
        log.info("폰서비스" + userFindService.selectId(userPhone));
        log.info("-------------------------------");*/
        return userFindService.selectId(userPhone);
    }



}
