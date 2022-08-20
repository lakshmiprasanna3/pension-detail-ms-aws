package com.cognizant.ms.service;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.ms.model.BankDetail;
import com.cognizant.ms.model.PensionerDetail;
import com.cognizant.ms.repository.PensionerDetailsRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class PensionerDetailServiceTest {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@InjectMocks
	private PensionerDetailService pensionerDetailService;
	
	@Mock
	private PensionerDetailsRepository pensionerDetailsRepository;

	@Test
	public void testNotNullPensionDetailServiceObject() {
		logger.info("started");
		assertNotNull(pensionerDetailService);
	}
	
	
	@Test
	public void testPensionerDetailFunction() {
		
		assertEquals(pensionerDetailService.addPensionerDetails(),"Successfull");
	}
	

	
	
	@Test
	public void testGetAllDetails() {
		List<PensionerDetail> pensionerDetailsList = new ArrayList<>();
		BankDetail bankDetail = new BankDetail("ICICI", "12345678", "private");
		PensionerDetail pensionerDetail = new PensionerDetail("982897132579", "Prasanna", "03-03-2000", "PCASD1234Q",
				27000, 10000, "self", bankDetail);
		pensionerDetailsList.add(pensionerDetail);
	
		when(pensionerDetailService.getDetails()).thenReturn(pensionerDetailsList);
		assertEquals(pensionerDetailService.getDetails(),pensionerDetailsList);
		//assertNotNull(pensionerDetailService.getDetails());
	}

	
	
}
