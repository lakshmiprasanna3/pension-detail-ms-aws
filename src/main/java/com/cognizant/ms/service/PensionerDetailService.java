package com.cognizant.ms.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ms.model.BankDetail;
import com.cognizant.ms.model.PensionerDetail;
import com.cognizant.ms.repository.PensionerDetailsRepository;

@Service
public class PensionerDetailService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDetailService.class);

	@Autowired
	private PensionerDetailsRepository pensionerDetailsRepository;

	
	
	public String addPensionerDetails() {

		LOGGER.info("Start");

		List<PensionerDetail> pensionerDetailsList = new ArrayList<>();
		
		String path = "/pensionerDetails.csv";
		InputStream inputStream = getClass().getResourceAsStream(path);
		
		
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

			while ((line = br.readLine()) != null) {

				
				
				String[] values = line.split(",");
				PensionerDetail pensionerDetail = new PensionerDetail();
				pensionerDetail.setAadhaarNumber(values[0]);
				pensionerDetail.setName(values[1]);
				pensionerDetail.setDateOfBirth(values[2]);
				pensionerDetail.setPanNumber(values[3]);
				pensionerDetail.setSalary(Double.parseDouble(values[4]));
				pensionerDetail.setAllowance(Double.parseDouble(values[5]));
				pensionerDetail.setPensionType(values[6]);
				pensionerDetail.setBankDetail(new BankDetail(values[7],values[8],values[9]));
				pensionerDetailsList.add(pensionerDetail);
				
				
			}
			

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		pensionerDetailsRepository.saveAll(pensionerDetailsList);
		LOGGER.info("END ");
		return "Successfull";
	
		
	}
	
	public List<PensionerDetail> getDetails() {
		addPensionerDetails();
		return  pensionerDetailsRepository.findAll();
	}

}
