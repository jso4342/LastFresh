package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.vo.ProductVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductVO, Long> {

}
