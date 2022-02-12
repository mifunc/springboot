package com.rumenz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi //Swagger2 3.0以上版本需要开启的注解
public class Lession9Application {

    public static void main(String[] args) {
        SpringApplication.run(Lession9Application.class, args);
    }

}
