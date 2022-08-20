package com.cognizant.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ms.model.PensionerDetail;

@Repository
public interface PensionerDetailsRepository extends JpaRepository<PensionerDetail, String>{

	
}
