package com.example.esdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication 标注在SpringBoot的主配置类，运行这个类的main方法启动SpringBoot应用
@SpringBootApplication
public class EsDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(EsDemoApplication.class, args);
    }

}
