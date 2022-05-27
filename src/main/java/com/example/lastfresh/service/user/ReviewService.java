package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.ReviewDAO;
import com.example.lastfresh.domain.repository.ReviewRepository;
import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.ProductVO;
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
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public void insert(Long userNum, Long productNum){
        reviewDAO.insert(userNum, productNum);
    }

    public List<ReviewVO> getReview(Long userNum){
        //return reviewDAO.getUnWritten(userNum);
        return userRepository.getById(userNum).getReviews();
    }

    public ProductVO getProduct(Long reviewNum){
        return reviewRepository.getById(reviewNum).getProductVO();
    }

    public ReviewVO getOneReview(Long reviewNum){
        //return reviewDAO.getUnWritten(userNum);
        return reviewRepository.getById(reviewNum);
    }

    public void update(ReviewVO reviewVO){
        reviewDAO.update(reviewVO);
    }

    public void delete(Long reviewNum){
        reviewDAO.delete(reviewNum);
    }
//    private final ReviewDAO reviewDAO;
//
//    @Override
}
