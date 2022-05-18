package com.example.lastfresh.service.owner;

import com.example.lastfresh.domain.dao.owner.OwnerProductDAO;
import com.example.lastfresh.domain.dao.product.ProductDAO;
import com.example.lastfresh.domain.dto.ProductListDTO;
import com.example.lastfresh.domain.repository.ProductRepository;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.Criteria;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.domain.vo.ProductVO2;
import com.example.lastfresh.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OwnerService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OwnerProductDAO ownerProductDAO;

//    public void register(ProductDTO productDTO, Long userNum) {
//        log.info("--------------------------------------------------");
//        log.info("DTO :" + productDTO);
//        log.info("--------------------------------------------------");
//
//        ProductVO productVO = new ModelMapper().map(productDTO, ProductVO.class);
////        UserVO userVO = userRepository.findById(userNum).get();
////        productVO.setUserVO(userVO);
//
//
//
//        productRepository.save(productVO);
//    }

    public void register(ProductVO productVO, Long userNum) {
        log.info("--------------------------------------------------");
        log.info("DTO :" + productVO);
        log.info("--------------------------------------------------");

//        ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);
        UserVO userVO = userRepository.findById(userNum).get();
        productVO.setUserVO(userVO);
        productRepository.save(productVO);
    }

    public List<ProductListDTO> getList(Criteria criteria){
        List<ProductListDTO> list = ownerProductDAO.getList(criteria);
        return ownerProductDAO.getList(criteria);
    }

    public int getTotal(Criteria criteria) {
        return ownerProductDAO.getTotal(criteria);
    }

    public boolean deleteProductMenu (Long sellProductNum) {
        return ownerProductDAO.deleteProductMenu(sellProductNum);
    }


    //    public PageDTO<ProductVO> getProductVOs(Pageable pageable, Long userNum) {
//        UserVO userVO = userRepository.findById(userNum).get();
//
//        Page<ProductVO> productVOPage = productRepository2.findByUserOrderByIdDesc(userVO, pageable);
//
//        PageDTO<ProductVO> pageDTO = new PageDTO<>(productVOPage);
//        return pageDTO;
//    }

}
