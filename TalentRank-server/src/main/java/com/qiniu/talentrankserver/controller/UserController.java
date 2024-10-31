package com.qiniu.talentrankserver.controller;

import Result.Result;
import com.qiniu.talentrankserver.service.UserService;
import constent.JwtClaimsConstant;
import dto.LoginDTO;
import dto.RegisterDTO;
import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import properties.JwtProperties;
import utils.JwtUtil;
import vo.LoginVO;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private JwtProperties jwtProperties;

    /**
     * 用户登录
     * @param loginDTO
     */
    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO){
        log.info("用户登录：{}",loginDTO);

        User user = userService.login(loginDTO);
        log.info("{}",user);
        //登录成功后生成jwt令牌
        Map<String,Object> claims =new HashMap<>();
        claims.put(JwtClaimsConstant.EMP_ID,user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);
        LoginVO loginVO = LoginVO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .token(token)
                .build();

        return Result.success(loginVO);
    }

    /**
     * 用户注册
     * @param registerDTO
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody RegisterDTO registerDTO){
        log.info("用户注册：{}",registerDTO);
        userService.register(registerDTO);
        return Result.success();
    }
}
