package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.BasketDAO;
import com.example.lastfresh.domain.dao.user.BillDAO;
import com.example.lastfresh.domain.dao.user.UserDAO;
import com.example.lastfresh.domain.dto.OrderDTO;
import com.example.lastfresh.domain.repository.BasketRepository;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.domain.vo.BasketVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final BasketDAO basketDAO;
    private final BillDAO billDAO;

    public List<BasketDTO> getListByDTO(Long userNum) throws Exception { return basketDAO.getListByDTO(userNum); }

    public void insert(OrderDTO orderDTO, Long userNum){
        billDAO.insertBill(orderDTO);
        billDAO.insertBillProduct(userNum);
        basketDAO.decreaseStock(userNum);
        basketDAO.soldOut();
        basketDAO.removeItems(userNum);
    }

}
