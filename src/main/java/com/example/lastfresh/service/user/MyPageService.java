package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.UserDAO;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyPageService {
    private final UserDAO userDAO;
    private final UserRepository userRepository;


    public boolean modify(UserVO userVO, Long userNum) throws Exception{
        // original userVO
        UserVO originalUserVO = userRepository.findById(userNum).get();
        originalUserVO.updateAll(userVO.getUserPw(), userVO.getUserName(), userVO.getUserEmail(), userVO.getUserAddress(), userVO.getUserAddressDetail(), userVO.getUserAddressPostNum(), userVO.getUserPhone(), userVO.getUserKakao(), userVO.getUserStatus());
        userRepository.save(userVO);

        return true;
    }

    public UserVO get(Long userNum) throws Exception{
      UserVO userVO = userRepository.findById(userNum).get();
      userVO.setUserNum(userNum);
      return userVO;
    }


}
