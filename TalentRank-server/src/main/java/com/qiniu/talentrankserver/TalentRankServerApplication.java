package com.qiniu.talentrankserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import properties.JwtProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
@Slf4j
public class TalentRankServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalentRankServerApplication.class, args);
    }

}
