package com.example.lastfresh.mapper.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFindMapper {
    public String selectId(String userPhone);
}
