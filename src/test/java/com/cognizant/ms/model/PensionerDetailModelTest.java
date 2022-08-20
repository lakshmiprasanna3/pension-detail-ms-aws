package com.cognizant.ms.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PensionerDetailModelTest {

	@Test
	void testNoArgsBankDetailTest() {
		assertThat(new BankDetail()).isNotNull();
	}

	@Test
	void testAllArgsBankDetailTest() {
		BankDetail bankDetails = new BankDetail("SBI", "1234567890", "Private") ;
		assertNotNull(bankDetails) ;
	}

	@Test
	void testSetterBankTest() {
		BankDetail b = new BankDetail();
		b.setAccountNumber("583920012848");
		b.setBankName("SBI");
		b.setBankType("public");
		assertThat(assertThat(b).isNotNull());

	}
	
	@Test
	void GetterArgsBankDetailTest() {
		BankDetail bankDetails = new BankDetail("SBI", "1234567890", "private") ;
		assertEquals("SBI", bankDetails.getBankName()) ;
		assertEquals("1234567890", bankDetails.getAccountNumber()) ;
		assertEquals("private", bankDetails.getBankType()) ;
	}


	@Test
	void testSetterPensionerDetailTest() {
		PensionerDetail pensionerDetail = new PensionerDetail();
		pensionerDetail.setAadhaarNumber("986543276547");
		pensionerDetail.setDateOfBirth("03-03-2000");
		pensionerDetail.setName("Lakshmi Prasanna");
		pensionerDetail.setPanNumber("GTYIK7412L");
		pensionerDetail.setSalary(70000);
		pensionerDetail.setAllowance(12000);
		pensionerDetail.setPensionType("family");

		BankDetail bankDetail = new BankDetail();
		bankDetail.setAccountNumber("102233445566");
		bankDetail.setBankName("SBI");
		bankDetail.setBankType("public");

		pensionerDetail.setBankDetail(bankDetail);
		assertThat(assertThat(pensionerDetail).isNotNull());
		
		assertEquals("986543276547",pensionerDetail.getAadhaarNumber() ) ;
		assertEquals("03-03-2000", pensionerDetail.getDateOfBirth()) ;
		assertEquals("Lakshmi Prasanna", pensionerDetail.getName()) ;
		assertEquals("GTYIK7412L", pensionerDetail.getPanNumber()) ;
		assertEquals(70000, pensionerDetail.getSalary()) ;
		assertEquals(12000, pensionerDetail.getAllowance()) ;
		assertEquals("family", pensionerDetail.getPensionType()) ;
		
		assertEquals("102233445566",bankDetail.getAccountNumber() ) ;
		assertEquals("SBI", bankDetail.getBankName()) ;
		assertEquals("public",bankDetail.getBankType() ) ;
		
	}

}
