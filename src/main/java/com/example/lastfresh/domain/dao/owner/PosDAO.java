package com.example.lastfresh.domain.dao.owner;

import com.example.lastfresh.domain.dto.PosDTO;
import com.example.lastfresh.mapper.owner.PosMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PosDAO {
    private final PosMapper posMapper;

    /*Pos 준비중 주문 리스트 조회*/
    public List<PosDTO> getPreparingList(HashMap<String, Object> map){return posMapper.getPreparingList(map);}

    /*Pos 준비중 주문 총 개수*/
    public int getTotalPreparing(HashMap<String,Object> map){return posMapper.getTotalPreparing(map);}
}
