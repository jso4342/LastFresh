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

    //    마감 세일 상품 목록 가져오기
    public  List<ProductVO> getListByReview(){return productMapper.getListByReview();};
//    public  get( ) {}
//    public void updateReplyCount() {}
}
