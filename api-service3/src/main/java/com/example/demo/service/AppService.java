package com.example.demo.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Rajkumar Banala 14-Jul-2022
 *
 */

@Service
public class AppService {

	private static final Logger LOG = LoggerFactory.getLogger(AppService.class);

	public String processData(Map<String, Object> payload) {
		LOG.debug("processData()");

		String name = (String) payload.get("Name");
		String surName = (String) payload.get("Surname");

		StringBuffer response = new StringBuffer("");

		if (name != null)
			response.append(payload.get("Name"));

		if (surName != null) {

			if (!response.isEmpty())
				response.append(" ");

			response.append(payload.get("Surname"));
		}

		LOG.debug("getData.payload():" + payload);

		return response.toString();
	}
}
