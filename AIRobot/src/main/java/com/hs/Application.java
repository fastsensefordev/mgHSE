package com.hs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.hs.mapper")
@EnableScheduling
public class Application {
	
    /**
     * Start
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
