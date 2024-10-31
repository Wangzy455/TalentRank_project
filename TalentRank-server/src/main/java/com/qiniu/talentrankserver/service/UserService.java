package com.qiniu.talentrankserver.service;

import dto.LoginDTO;
import dto.RegisterDTO;
import entity.User;

public interface UserService {

    /**
     * 用户登录
     * @param loginDTO
     * @return
     */
    User login(LoginDTO loginDTO);

    /**
     * 用户注册
     * @param registerDTO
     */
    void register(RegisterDTO registerDTO);
}
