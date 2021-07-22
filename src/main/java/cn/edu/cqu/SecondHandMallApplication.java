package cn.edu.cqu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="cn.edu.cqu.mapper")
public class SecondHandMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondHandMallApplication.class, args);
    }

}
