package com.example.lastfresh.domain.dao.product;


import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.mapper.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;
    public List<ProductVO> getList() {return productMapper.getList();}
    public int getTotal() {return productMapper.getTotal();}
//    public  get( ) {}
//    public void updateReplyCount() {}
}
