package com.example.lastfresh.mapper.owner;

import com.example.lastfresh.domain.dto.BillSoldProductDTO;
import com.example.lastfresh.domain.dto.PosDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PosMapper {
    /*Pos 준비중 주문 리스트 조회*/
    List<PosDTO> getPreparingList(HashMap<String, Object> map);

    /*Pos 준비중 주문 총 개수*/
    int getTotalPreparing(HashMap<String,Object> map);

    /*Pos 주문 접수시 상태 업데이트*/
    int updateBillStatus(PosDTO posDTO);

    /*Pos 주문 취소시 상태 업데이트*/
    int updateBillStatusCancel(PosDTO posDTO);
}
