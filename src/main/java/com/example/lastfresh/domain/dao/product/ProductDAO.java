package com.example.lastfresh.domain.dao.product;


import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.mapper.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;
    public List<ProductVO> getList(CriteriaProduct criteriaProduct) {return productMapper.getList(criteriaProduct);}
    public int getTotal() {return productMapper.getTotal();}
    public ProductVO get(Long sellProductNum) {return productMapper.get(sellProductNum);}

    // 마감 세일 상품 목록 가져오기
    public  List<ProductVO> getListByReview(){return productMapper.getListByReview();};
    //이미지
    public  List<ProductVO> getImages(Long pno){ return productMapper.getImages(pno);}
}
