package com.example.demo.feignclient;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@FeignClient(name = "http://api-service3/api")
public interface ApiServiceClient3 {

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String processData(Map<String, Object> payload);
}
