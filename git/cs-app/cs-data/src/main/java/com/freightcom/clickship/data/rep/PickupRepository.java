package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Pickup;

@Repository
public interface PickupRepository extends JpaRepository<Pickup, String> {
 
	public Pickup findByConfirmationNumber(String confirmationNumber);
}