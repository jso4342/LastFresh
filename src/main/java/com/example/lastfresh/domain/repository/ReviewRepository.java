package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.vo.ReviewVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewVO, Long> {
    public List<ReviewVO> findAll();
  //  public List<StudentEntity> findAllByOrderByIdAsc();
}
