package com.example.lastfresh.service.product;

import com.example.lastfresh.domain.dao.product.ProductDAO;
import com.example.lastfresh.domain.repository.BasketRepository;
import com.example.lastfresh.domain.repository.ProductRepository;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.BasketVO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;

    private final ProductDAO productDAO;
    //상품 목록
    public List<ProductVO> getList(CriteriaProduct criteriaProduct) {
        return productDAO.getList(criteriaProduct);
//        List<ProductVO> products = productRepository.findAll();
//        return products;
    }
    // 특정 게시글 가져오기
    public ProductVO get(Long sellProductNum) {
        return productDAO.get(sellProductNum);
    }
    // 상품 전체 갯수
    public int getTotal() {
        return productDAO.getTotal();
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

    //이미지
    public  List<ProductVO> getImages(Long pno){ return productDAO.getImages(pno);}

    //상품 담기
    public  void productToBasket(Long userNum, BasketVO basketVO,ProductVO productVO){

        UserVO userVO = userRepository.findById(userNum).get();
        basketVO.setProductVO(productVO);
        basketVO.setUserVO(userVO);
        basketVO.setBasketGoOrder(0L);
        basketRepository.save(basketVO);
    }

}

