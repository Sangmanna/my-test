package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.PalletServices;
import com.freightcom.clickship.data.entity.Shipment;

@Repository
public interface PalletServicesRepository extends JpaRepository<PalletServices, String>{

	PalletServices findByShipment(Shipment shipment);
}
