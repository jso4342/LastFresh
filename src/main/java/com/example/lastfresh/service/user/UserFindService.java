package com.example.lastfresh.service.user;

import com.example.lastfresh.domain.dao.user.UserDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserFindService {
    private final UserDAO userDAO;
}
