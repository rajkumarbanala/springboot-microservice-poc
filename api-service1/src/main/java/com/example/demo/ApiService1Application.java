package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class ApiService1Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiService1Application.class, args);
	}

}
