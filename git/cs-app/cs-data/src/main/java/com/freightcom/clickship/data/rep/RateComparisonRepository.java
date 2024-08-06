package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.RateComparison;
import com.freightcom.clickship.data.entity.Shipment;

@Repository
public interface RateComparisonRepository extends JpaRepository<RateComparison, String> {

	public List<RateComparison> findAllByShipmentIn(List<Shipment> shipments);

}