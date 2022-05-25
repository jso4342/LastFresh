package com.example.lastfresh.service.owner;

import com.example.lastfresh.domain.dao.owner.PosDAO;
import com.example.lastfresh.domain.dto.PosDTO;
import com.example.lastfresh.domain.vo.CriteriaPos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PosService {
    private final PosDAO posDAO;

    /* 준비중인 주문 리스트 조회 */
    public List<PosDTO> getListPreparing(HashMap<String,Object> map) {
        return posDAO.getPreparingList(map);
    }
    
    /* 준비중인 주문 리스트 총개수 */
    public int getTotalPreparing(HashMap<String,Object> map) {
        return posDAO.getTotalPreparing(map);
    }

    /* 주문 접수시 상태, 쿠킹타임 변경 */
    public boolean modifyBill(PosDTO posDTO) {
        return posDAO.updateBillStatus(posDTO) == 1;
    }
    
    /* 주문 취소시 상태 변경 */
    public boolean cancelBill(PosDTO posDTO) {
        return posDAO.updateBillStatusCancel(posDTO) == 1;
    }
}
