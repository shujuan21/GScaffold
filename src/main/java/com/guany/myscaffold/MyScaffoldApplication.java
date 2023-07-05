package com.guany.myscaffold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableJpaAuditing
@MapperScan("com.guany.myscaffold.mapper")
public class MyScaffoldApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyScaffoldApplication.class, args);
    }

}
