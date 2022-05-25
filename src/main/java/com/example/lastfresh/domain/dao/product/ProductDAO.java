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
    // 신상품 상품 전체 목록
    public List<ProductVO> getList(CriteriaProduct criteriaProduct) {return productMapper.getList(criteriaProduct);}
    // 신상품 전체 개수
    public int getTotal(CriteriaProduct criteriaProduct) {return productMapper.getTotal(criteriaProduct);}
    // 해당 상품 상세 페이지
    public ProductVO get(Long sellProductNum) {return productMapper.get(sellProductNum);}
    // 픽업 상품 전체 목록
    public List<ProductVO> getPickupList(CriteriaProduct criteriaProduct) {return productMapper.getPickupList(criteriaProduct);}
    // 픽업 전체 개수
    public int getPickupTotal(CriteriaProduct criteriaProduct) {return productMapper.getPickupTotal(criteriaProduct);}
    // 배달 상품 전체 목록
    public List<ProductVO> getDeliveryList(CriteriaProduct criteriaProduct) {return productMapper.getDeliveryList(criteriaProduct);}
    // 배달 전체 개수
    public int getDeliveryTotal(CriteriaProduct criteriaProduct) {return productMapper.getDeliveryTotal(criteriaProduct);}

    // 배송 상품 전체 목록
    public List<ProductVO> getShippingList(CriteriaProduct criteriaProduct) {return productMapper.getShippingList(criteriaProduct);}
    // 배송 전체 개수
    public int getShippingTotal(CriteriaProduct criteriaProduct) {return productMapper.getShippingTotal(criteriaProduct);}

    // 마감 세일 상품 목록 가져오기
    public  List<ProductVO> getListByReview(){return productMapper.getListByReview();};
    //이미지
    public  List<ProductVO> getImages(Long pno){ return productMapper.getImages(pno);}
}
