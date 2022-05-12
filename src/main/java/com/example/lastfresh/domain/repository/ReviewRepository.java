package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.vo.ReviewVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewVO, Long> {

}
