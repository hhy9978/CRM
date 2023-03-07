package com.hhy.crm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hhy.crm.mapper")
public class Crm02BranchApplication {

    public static void main(String[] args) {
        SpringApplication.run(Crm02BranchApplication.class, args);
    }

}
