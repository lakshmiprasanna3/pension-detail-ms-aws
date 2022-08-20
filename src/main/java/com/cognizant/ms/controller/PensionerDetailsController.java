package com.cognizant.ms.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ms.model.PensionerDetail;
import com.cognizant.ms.repository.PensionerDetailsRepository;
import com.cognizant.ms.restclient.AuthorizationProxy;
import com.cognizant.ms.service.PensionerDetailService;

@RestController
public class PensionerDetailsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDetailsController.class);

	@Autowired
	private AuthorizationProxy authorizationProxy;

	@Autowired
	private PensionerDetailsRepository pensionerDetailsRepository;

	@Autowired
	private PensionerDetailService pensionerDetailService;

	@GetMapping("/pensionerDetailByAadhaar/{aadhaarNumber}")
	public PensionerDetail findByAadhaarNumber(@RequestHeader("Authorization") String token,
			@PathVariable String aadhaarNumber) throws Exception {
		LOGGER.info("Start");
		if (authorizationProxy.authorization(token)) {
			LOGGER.info("Token is valid and getting details");
			Optional<PensionerDetail> optionalPensionerDetail = pensionerDetailsRepository.findById(aadhaarNumber);
			PensionerDetail pensionerDetail = optionalPensionerDetail.get();

			return pensionerDetail;
		} else {
			LOGGER.error("Token Invalid Exception");
			throw new Exception("token is not valid");
		}
	}

	@GetMapping("/allPensionersdetails")
	public List<PensionerDetail> getAllPensionersDetails() {
		LOGGER.info("Start");

		return pensionerDetailService.getDetails();

	}

}
