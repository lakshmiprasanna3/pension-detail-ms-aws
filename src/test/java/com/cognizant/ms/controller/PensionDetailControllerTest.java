package com.cognizant.ms.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;




import com.cognizant.ms.model.BankDetail;
import com.cognizant.ms.model.PensionerDetail;
import com.cognizant.ms.repository.PensionerDetailsRepository;
import com.cognizant.ms.restclient.AuthorizationProxy;
import com.cognizant.ms.service.PensionerDetailService;



@SpringBootTest
@AutoConfigureMockMvc
public class PensionDetailControllerTest {

	
	
	@Mock
	PensionerDetailsController pensionerDetailsController;
	
	@Mock
	private PensionerDetailService pensionerDetailService;
	
	@Mock
	private AuthorizationProxy authorizationProxy;
	
	@Mock
	private PensionerDetailsRepository pensionerDetailsRepository;
	
	List<PensionerDetail> pensionerDetailsList;

	
	
	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYxNTcyMTkxMywiaWF0IjoxNjE1NTQxOTEzfQ.sBh1dxvrhBUQWtmOIzJ0HYBIQCxZ__5Hhr1IvsOyYNI";

	private  String aadharNumber = "330583515906";
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Test
	public void testNotNullPensionDetailController() {
		assertNotNull(pensionerDetailsController);
	}
	
	
	@Test
	public void getAllPensionersDetailsTest()  {
		
	assertNotNull(pensionerDetailsController.getAllPensionersDetails());
		
	}


	
	@Test
	public void findByAadhaarNumberTest() throws Exception {
		
		
		logger.info("started");
		BankDetail bankDetail = new BankDetail("ICICI", "12345678", "private");
		PensionerDetail pensionerDetail = new PensionerDetail("982897132579", "Prasanna", "03-03-2000", "PCASD1234Q",
				27000, 10000, "self", bankDetail);
		
		
		when(pensionerDetailsController.findByAadhaarNumber(token, aadharNumber)).thenReturn(pensionerDetail);
	assertEquals(pensionerDetailsController.findByAadhaarNumber(token, aadharNumber),pensionerDetail);
	Optional<PensionerDetail> optionalPensionerDetail = Optional.of(pensionerDetail);
	
	
	when(optionalPensionerDetail.get()).thenReturn(pensionerDetail);

	
	assertEquals(optionalPensionerDetail.get(), pensionerDetail);

	
	}
	
	


	
}
