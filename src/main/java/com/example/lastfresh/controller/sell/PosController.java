package com.example.lastfresh.controller.sell;

import com.example.lastfresh.domain.dto.PosDTO;
import com.example.lastfresh.domain.vo.Criteria;
import com.example.lastfresh.service.owner.PosService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pos/*")
public class PosController {
    private final PosService posService;

    @GetMapping("/list/{billStatus}/{pageNum}/{amount}/{limit}")
    public List<PosDTO> getList(@PathVariable("billStatus") int billStatus, @PathVariable("pageNum") int pageNum, @PathVariable("amount") int amount, @PathVariable("limit") int limit, HttpServletRequest request) {
        Criteria criteria = new Criteria();

        if(pageNum == 0) {
            criteria.setAmount(4);
            criteria.setPageNum(1);
            criteria.setLimit(0);
        }else {
            criteria = new Criteria(pageNum, amount, limit);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("userNum", 6L);
        map.put("criteria", criteria);
        map.put("billStatus", 3);

        return posService.getListPreparing(map);
    }
}
