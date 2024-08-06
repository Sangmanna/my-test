package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Package;

@Repository
public interface PackageRepository extends JpaRepository<Package, String> {	
	
	@Query("SELECT SUM(p.insuranceAmount) FROM Package p WHERE p.shipment.id = :shipmentId")
	public Double getInsuranceAmount(@Param("shipmentId") String shipmentId);
	
}