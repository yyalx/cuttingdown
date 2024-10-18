package org.example.cuttingdown;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.example.cuttingdown.mapper")
public class CuttingdownApplication {

    public static void main(String[] args) {
        SpringApplication.run(CuttingdownApplication.class, args);
    }

}
