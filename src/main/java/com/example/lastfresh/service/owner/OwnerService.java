package com.example.lastfresh.service.owner;

import com.example.lastfresh.domain.repository.ProductRepository;
import com.example.lastfresh.domain.vo.ProductVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OwnerService {
    private final ProductRepository productRepository;

    public void register(ProductVO productVO) {

        productRepository.save(productVO);
    }

}
