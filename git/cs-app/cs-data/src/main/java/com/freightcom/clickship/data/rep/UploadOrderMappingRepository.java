package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.UploadOrderMapping;

@Repository
public interface UploadOrderMappingRepository extends JpaRepository<UploadOrderMapping, String> {

	public List<UploadOrderMapping> findByCustomer(Customer customer);
	
}
