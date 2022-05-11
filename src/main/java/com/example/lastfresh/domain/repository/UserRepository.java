package com.example.lastfresh.domain.repository;

import com.example.lastfresh.domain.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserVO, Long> {

}
