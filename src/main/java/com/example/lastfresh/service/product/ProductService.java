package com.example.lastfresh.service.product;

import com.example.lastfresh.domain.dao.product.AttachDAO;
import com.example.lastfresh.domain.dao.product.ProductDAO;
import com.example.lastfresh.domain.repository.ProductRepository;
import com.example.lastfresh.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService{
    private final ProductRepository productRepository;
    private final ProductDAO productDAO;
    //상품 목록
    public List<ProductVO> getList() {
        List<ProductVO> products = productRepository.findAll();
        return products;
    }


    //창환
    //새상품 목록
    public List<ProductVO> getListByNew() {
        //when
        PageRequest pageRequest = PageRequest.of(0,4, Sort.by(Sort.Direction.DESC,"sellProductNum"));

        Page<ProductVO> page = productRepository.findAllByOrderBySellProductNumDesc(pageRequest);

        //then
        List<ProductVO> content = page.getContent(); //조회된 데이터
        return content;
    }


    //마감 상품 목록
    @Query("select products from ProductVO products where products.sellProductExpireDay= current_date ")
    public List<ProductVO> getListBySale() {
        //when
        PageRequest pageRequest = PageRequest.of(0,2,Sort.by(Sort.Direction.DESC,"sellProductExpireDay"));

        Page<ProductVO> page = productRepository.findAllByOrderBySellProductExpireDayDesc(pageRequest);

        //then
        List<ProductVO> content = page.getContent(); //조회된 데이터
        return content;
    }
    //후기 많은 상품 목록(myBatis로 구현됨)
    public  List<ProductVO> getListByReview(){
        List<ProductVO> products=productDAO.getListByReview();
        return products;
    }

}

