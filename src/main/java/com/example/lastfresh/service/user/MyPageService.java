package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.BillDAO;
import com.example.lastfresh.domain.dao.user.UserDAO;
import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.domain.dto.OrderDTO;
import com.example.lastfresh.domain.repository.BillRepository;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.BillProductVO;
import com.example.lastfresh.domain.vo.BillVO;
import com.example.lastfresh.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyPageService {
    private final UserDAO userDAO;
    private final BillDAO billDAO;
    private final UserRepository userRepository;
   // @Autowired
    private BillRepository billRepository;


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

    @Transactional
    public List<BillVO> getBills(Long userNum) throws Exception{
        List<BillVO> bills = userRepository.getById(userNum).getBills();
        return bills;
       /* List<BillProductVO> products = new ArrayList<>();
        bills.forEach(bill -> {
            products.add((BillProductVO) bill.getProducts());
            //  log.info(billVO.getUserVO().toString());
            //  log.info(bill.getProducts().toString());
        });*/

      /*  List<BillVO> orders = billRepository.findAllById(userNum);
       BillVO billVO = billRepository.findById(userNum).orElseThrow(EntityNotFoundException::new);
  */     //return billVO;
    }


   /* public List<BillVO> getOrders(Long userNum) throws Exception{
        return billDAO.getOrders(userNum);
    }*/

  /*
  getProductNames

  public List<BasketDTO> getListByDTO(Long userNum) throws Exception {
        return basketDAO.getListByDTO(userNum);
    }*/

}
