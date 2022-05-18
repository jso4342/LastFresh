package com.example.lastfresh.domain.dao.owner;


import com.example.lastfresh.domain.dto.ProductListDTO;
import com.example.lastfresh.domain.vo.Criteria;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.domain.vo.ProductVO2;
import com.example.lastfresh.mapper.owner.OwnerProductMapper;
import com.example.lastfresh.mapper.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OwnerProductDAO {
    private final OwnerProductMapper ownerproductMapper;

    public List<ProductListDTO> getList(Criteria criteria) {return ownerproductMapper.getList(criteria);}
    public int getTotal(Criteria criteria) {return ownerproductMapper.getTotal(criteria);}
    public boolean deleteProductMenu(Long sellProductNum) {return ownerproductMapper.deleteProductMenu(sellProductNum) == 1;}
//    public void register( ) {}
//    public boolean modify( ) {}
//    public boolean remove( ) {}
//    public  get( ) {}
//    public int getTotal( ) {}
//    public void updateReplyCount() {}

}













