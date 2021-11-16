package com.heqing.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author heqing
 * @date 2021/7/14 10:40
 */
@MapperScan("com.heqing.mybatisplus")
@SpringBootApplication
public class MybatisPlusApplication {

    public static void main(String[] args) {
        new SpringApplication(MybatisPlusApplication.class).run(args);
    }

}
