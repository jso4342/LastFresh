package com.example.lastfresh.mapper.user;

import com.example.lastfresh.domain.dto.ReviewDTO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    public void insert(Long userNum, Long productNum);
    public void update(ReviewVO reviewVO);
    public void delete(Long reviewNum);

    //리뷰 1개 조회(read)
    public ReviewVO readReview(Long reviewNum);

    public List<ReviewDTO> getReviewList(Long sellProductNum, CriteriaProduct criteriaProduct);

    //댓글 개수
    public int getTotal(Long sellProductNum);
}


