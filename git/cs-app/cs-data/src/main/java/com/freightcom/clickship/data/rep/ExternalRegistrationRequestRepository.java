package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.ExternalRegistrationRequest;

@Repository
public interface ExternalRegistrationRequestRepository extends JpaRepository<ExternalRegistrationRequest, String> {
    
	public ExternalRegistrationRequest findByExternalId(String accountId);
	
}
