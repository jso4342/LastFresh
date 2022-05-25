package com.example.lastfresh.domain.dao.user;


import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ReviewVO;
import com.example.lastfresh.mapper.user.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReviewDAO {
    private final ReviewMapper reviewMapper;

    //    public int register( ){
//
//    }
//
    public ReviewVO readReview(Long reviewNum){
        log.info("readReview...."+ reviewNum);
        return reviewMapper.readReview(reviewNum);
    }

    public List<ReviewVO> getReviewList(Long sellProductNum, CriteriaProduct criteriaProduct){
        log.info("getReviewList...."+ sellProductNum);
        return reviewMapper.getReviewList(sellProductNum, criteriaProduct);
    }
    //
//    public int remove( ){
//
//    }
//
//    public int modify( ){
//
//    }
//
//
    public int getTotal(Long sellProductNum){
        log.info("review get total.....");
        return reviewMapper.getTotal(sellProductNum);
    }

}












