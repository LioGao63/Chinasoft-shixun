package com.chinasoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableAsync
@ServletComponentScan
@EnableSwagger2
@MapperScan("com.chinasoft.dao")
@EnableScheduling
public class CsiapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsiapiApplication.class, args);
    }

}
