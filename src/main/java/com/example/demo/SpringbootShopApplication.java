package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class SpringbootShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootShopApplication.class, args);
	}
}
