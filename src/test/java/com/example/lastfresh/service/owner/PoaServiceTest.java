package com.example.lastfresh.service.owner;

import com.example.lastfresh.domain.vo.Criteria;
import com.example.lastfresh.domain.vo.CriteriaPos;
import com.example.lastfresh.mapper.owner.PosMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class PoaServiceTest {
    @Autowired
    private PosMapper posMapper;

    @Transactional
    @Test
    public void testGetLis() {
        Criteria criteria = new Criteria(1,4, 0);
        Long userNum = 6L;

        HashMap<String, Object> map = new HashMap<>();
        map.put("criteria", criteria);
        map.put("userNum", userNum);

        posMapper.getPreparingList(map).stream().map(v -> v.toString()).forEach(log::info);
    }
}