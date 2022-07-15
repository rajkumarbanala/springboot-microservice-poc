package com.example.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@FeignClient(name = "http://api-service2/api")
public interface ApiServiceClient2 {

	@GetMapping
	public String get();
}
