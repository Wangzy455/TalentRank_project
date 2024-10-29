package com.qiniu.talentrankserver.mapper;

import entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User getUserByName(String username);
}
