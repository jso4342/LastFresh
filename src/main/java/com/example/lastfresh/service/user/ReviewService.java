package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.ReviewDAO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ReviewVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewService {
    private final ReviewDAO reviewDAO;

    //리뷰 1개 조회(read)
    public ReviewVO readReview(Long reviewNum) {
        return reviewDAO.readReview(reviewNum);
    }

    //리뷰 목록(getList)
    public List<ReviewVO> getReviewList(Long sellProductNum, CriteriaProduct criteriaProduct) {
        return reviewDAO.getReviewList(sellProductNum, criteriaProduct);
    }
    //리뷰 전체 조회(getTotal)
    public int getTotal(Long sellProductNum) {
        return reviewDAO.getTotal(sellProductNum);
    }
}
