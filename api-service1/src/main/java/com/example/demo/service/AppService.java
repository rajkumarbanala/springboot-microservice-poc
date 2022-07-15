package com.example.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exception.AppBaseException;
import com.example.demo.feignclient.ApiServiceClient2;
import com.example.demo.feignclient.ApiServiceClient3;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@Service
public class AppService {
	
	@Autowired
	ApiServiceClient2 apiServiceClient2;

	@Autowired
	ApiServiceClient3 apiServiceClient3;
	
	public String callService2() {

		return apiServiceClient2.get();
//		try {
//
//
//		} catch (Exception e) {
//			throw new AppBaseException("Unable to fetch details from service2");
//		}
	}

	public String callService3(Map<String, Object> payload) {

		return apiServiceClient3.processData(payload);

//		try {
//			
//		} catch (Exception e) {
//			throw new AppBaseException("Unable to fetch details from service3");
//		}
	}

	public String getData(Map<String, Object> payload) {

		StringBuffer finalResponse = new StringBuffer();

		String response1 = callService2();

		String response2 = callService3(payload);

		if (response1 != null)
			finalResponse.append(response1);

		if (response2 != null) {

			if (!finalResponse.isEmpty())
				finalResponse.append(" ");

			finalResponse.append(response2);
		}

		return finalResponse.toString();
	}
}
