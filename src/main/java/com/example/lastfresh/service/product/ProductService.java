package com.example.lastfresh.service.product;

import com.example.lastfresh.domain.dao.product.AttachDAO;
import com.example.lastfresh.domain.dao.product.ProductDAO;
import com.example.lastfresh.domain.repository.ProductRepository;
import com.example.lastfresh.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService{
    private final ProductRepository productRepository;

    //상품 목록
    public List<ProductVO> getList() {
        List<ProductVO> products = productRepository.findAll();
        return products;
    }

}