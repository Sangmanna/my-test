package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.ShipmentTax;

@Repository
@Transactional("csTransactionManager")
public interface ShipmentTaxRepository extends JpaRepository<ShipmentTax, String>{

	public List<ShipmentTax> findByShipmentId(String shipmentId);
}
