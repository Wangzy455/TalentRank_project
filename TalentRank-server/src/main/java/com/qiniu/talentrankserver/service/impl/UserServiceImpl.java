package com.qiniu.talentrankserver.service.impl;

import com.qiniu.talentrankserver.mapper.UserMapper;
import com.qiniu.talentrankserver.service.UserService;
import constent.MessageConstant;
import dto.LoginDTO;
import entity.User;
import exception.AccountNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    /**
     * 用户登录
     * @param loginDTO
     * @return
     */
    public User login(LoginDTO loginDTO) {
        String username = loginDTO.getUsername();
        String password = loginDTO.getPassword();

        User user = userMapper.getUserByName(username);
        if(user==null){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        if(!password.equals(loginDTO.getPassword())){
            throw new AccountNotFoundException(MessageConstant.PASSWORD_ERROR);
        }

        return user;
    }
}
