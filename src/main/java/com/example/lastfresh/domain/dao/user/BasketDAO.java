package com.example.lastfresh.domain.dao.user;


import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.domain.vo.BasketVO;
import com.example.lastfresh.mapper.user.BasketMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BasketDAO {
    private final BasketMapper basketMapper;

    public List<BasketVO> getListByUserNum(Long userNum) {return basketMapper.getListByUserNum(userNum);}
    public List<BasketDTO> getListByDTO(Long userNum){return basketMapper.getListByDTO(userNum);}
//    public  getList( ) {}
//    public void insert( ) {}
//    public  get( ) {}

}













