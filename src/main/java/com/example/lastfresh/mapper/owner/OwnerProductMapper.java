package com.example.lastfresh.mapper.owner;

import com.example.lastfresh.domain.dto.ProductDTO;
import com.example.lastfresh.domain.dto.ProductListDTO;
import com.example.lastfresh.domain.vo.Criteria;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.domain.vo.ProductVO2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface OwnerProductMapper {
    //    게시글 목록
//    public List<ProductListDTO> getList(Criteria criteria);
    public List<ProductListDTO> getList(HashMap<String,Object> map);

    //    전체 게시글 개수
//    public int getTotal(Criteria criteria);
    public int getTotal(HashMap<String,Object> map);

    //      메뉴 삭제
    public int deleteProductMenu(Long sellProductNum);

    // 프로덕트 넘버로 상품 조회
    public ProductDTO getListAll(Long sellProductNum);

    
    // 마감기한 지난 상품 업데이트
    public void updateExpireProduct();
//
}

