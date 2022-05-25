package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.UserDAO;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.apache.catalina.User;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.persistence.Column;
import java.sql.Array;
import java.util.*;

@Service
@RequiredArgsConstructor //final 붙은거 자동 오토와이어
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final UserDAO userDAO;

    //회원가입
    public void join(UserVO userVO) {
        String encodedPassword = passwordEncoder.encode(userVO.getUserPw());
        userVO.setUserPw(encodedPassword);
        userRepository.save(userVO);
    }

    //복호화 ,로그인
    public Long decryption(String userId, String userPw){
        Long userNum = 0L;
        UserVO userVO = userRepository.findByUserId(userId);
        System.out.println(passwordEncoder.matches(userPw, userVO.getUserPw()));
        if(!passwordEncoder.matches(userPw, userVO.getUserPw())){
            System.out.println("비밀번호가 일치하지 않습니다.");
            log.info("asd"+userNum);
            return null;
        }
        userNum = userVO.getUserNum();
        log.info("로그인성공"+userNum);
        return userNum;

    }


//휴대폰인증
    public void certifiedPhoneNumber(String userPhone, String cerNum) {

        String api_key = "NCSZMN9NMV9PSDYK";
        String api_secret = "SASZDMHFNE7UXW19LKE8NBANAFIW6UTS";
        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", userPhone);    // 수신전화번호
        params.put("from", "01049974699");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
        params.put("type", "SMS");
        params.put("text", "LastFresh 휴대폰인증 메시지 : 인증번호는" + "[" + cerNum + "]" + "입니다.");
        params.put("app_version", "test app 2.2"); // application name and version

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
            System.out.println(obj.toString());
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }

    }


    //아이디 중복검사

    public boolean checkId(String userId) {
        boolean checkId=false;
        List<UserVO> users= userRepository.findAll();
        List<String> ids= new ArrayList<>();

        for (UserVO u : users){
            ids.add(u.getUserId());
        }

        HashSet<String> idCheck = new HashSet<String>(ids);

        if(!idCheck.add(userId)){
            checkId=true;
        }
        return checkId;
    }


//이메일 중복검사
    public boolean checkEmail(String userEmail) {
        boolean checkEmail=false;
        List<UserVO> email= userRepository.findAll();
        List<String> emailcheck= new ArrayList<>();

        for (UserVO u : email){
            emailcheck.add(u.getUserEmail());
        }

        HashSet<String> idCheck = new HashSet<String>(emailcheck);

        if(!idCheck.add(userEmail)){
            checkEmail=true;
        }
        return checkEmail;
    }




}