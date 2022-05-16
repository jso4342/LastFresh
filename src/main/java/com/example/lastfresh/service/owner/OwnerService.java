package com.example.lastfresh.service.owner;

import com.example.lastfresh.domain.dto.ProductDTO;
import com.example.lastfresh.domain.repository.ProductRepository;
import com.example.lastfresh.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class OwnerService {
    private final ProductRepository productRepository;

    public void register(ProductVO productVO) {
        log.info("--------------------------------------------------");
        log.info("DTO :" + productVO);
        log.info("--------------------------------------------------");


        ModelMapper modelMapper = new ModelMapper();

//        ProductVO productVO = modelMapper.map(productDTO, ProductVO.class);

        productRepository.save(productVO);
    }

}
