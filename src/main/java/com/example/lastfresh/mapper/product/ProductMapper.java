package com.example.lastfresh.mapper.product;

import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    //   신상품 게시글 목록
    public List<ProductVO> getList(CriteriaProduct criteriaProduct);

    //    특정 게시글 가져오기
    public ProductVO get(Long sellProductNum);

    //    신상품 게시글 전체 개수
    public int getTotal(CriteriaProduct criteriaProduct);

    //   픽업 게시글 목록
    public List<ProductVO> getPickupList(CriteriaProduct criteriaProduct);

    //    픽업 게시글 전체 개수
    public int getPickupTotal(CriteriaProduct criteriaProduct);

    //   배달 게시글 목록
    public List<ProductVO> getDeliveryList(CriteriaProduct criteriaProduct);

    //    배달 게시글 전체 개수
    public int getDeliveryTotal(CriteriaProduct criteriaProduct);

    //   배송 게시글 목록
    public List<ProductVO> getShippingList(CriteriaProduct criteriaProduct);

    //    배송 게시글 전체 개수
    public int getShippingTotal(CriteriaProduct criteriaProduct);
//
//    //    게시글에 작성된 댓글 수 수정
//    public void updateReplyCount( );

//    후기 많은 상품 목록 가져오기
      public List<ProductVO> getListByReview();
    //이미지
    public  List<ProductVO> getImages(Long pno);
}

