package com.uchung.departmentappraise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.uchung.resources.mapping")
public class DepartmentAppraiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentAppraiseApplication.class, args);
    }

}
