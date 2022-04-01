package com.zgd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.zgd.mapper")
@SpringBootApplication
public class WsCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsCodeApplication.class, args);
	}

}
