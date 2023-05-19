package com.caomei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.caomei.mapper")
public class FightingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FightingApplication.class, args);
    }

}
