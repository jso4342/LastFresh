package com.example.lastfresh.mapper.product;

import com.example.lastfresh.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    //    게시글 목록
    public List<ProductVO> getList();

//    //    특정 게시글 가져오기
//    public ProductVO get(Long SELL_PRODUCT_NUM);
//
    //    전체 게시글 개수
    public int getTotal();
//
//    //    게시글에 작성된 댓글 수 수정
//    public void updateReplyCount( );

//    후기 많은 상품 목록 가져오기
      public List<ProductVO> getListByReview();
    //이미지
    public  List<ProductVO> getImages(Long pno);
}

