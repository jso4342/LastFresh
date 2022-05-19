package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.BasketDAO;
import com.example.lastfresh.domain.vo.BasketVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BasketService {
    private final BasketDAO basketDAO;
    //  장바구니에 상품 담기
    public void insert(BasketVO basketVO){basketDAO.insert(basketVO);}

}
