package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.persistence.Column;

@Service
@RequiredArgsConstructor //final 붙은거 자동 오토와이어
@Slf4j
public class UserService {

    private final UserRepository userRepository;


    public void join(UserVO userVO) {
        userRepository.save(userVO);



    }
}
