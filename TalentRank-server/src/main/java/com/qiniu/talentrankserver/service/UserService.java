package com.qiniu.talentrankserver.service;

import dto.LoginDTO;
import entity.User;

public interface UserService {

    /**
     * 用户登录
     * @param loginDTO
     * @return
     */
    User login(LoginDTO loginDTO);
}
