package com.yh.st;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.yh.st")
public class YhApplication {

	public static void main(String[] args) {
		SpringApplication.run(YhApplication.class, args);
	}
}
