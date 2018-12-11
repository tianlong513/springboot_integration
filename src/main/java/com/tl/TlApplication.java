package com.tl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan("com.tl.mapper*")
public class TlApplication {
    public static void main(String[] args) {
        SpringApplication.run(TlApplication.class, args);
    }

}
