package com.example.lastfresh.domain.dao.user;

import com.example.lastfresh.domain.repository.UserFindRepository;
import com.example.lastfresh.mapper.user.UserFindMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserFindDAO {
    private final UserFindMapper userFindMapper;

    // 휴대폰 인증 ID
    public String selectId(String userPhone){return userFindMapper.selectId(userPhone);};
}
