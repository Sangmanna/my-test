package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Shipment;
import com.freightcom.clickship.data.entity.ShipmentAdditionalServices;

@Repository
public interface ShipmentAdditionalServicesRepository extends JpaRepository<ShipmentAdditionalServices, String> {

	public List<ShipmentAdditionalServices> findByShipment(Shipment shipment);

}