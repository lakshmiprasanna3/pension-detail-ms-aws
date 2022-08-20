package com.cognizant.ms.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="authorizationMicroservice",url="${AUTH_VAR:http://localhost:8007/authorization}")
public interface AuthorizationProxy {

	//validating jwt token with authorization microservice
		@GetMapping("/authorize")
		public Boolean authorization(@RequestHeader("Authorization") String token);
}
