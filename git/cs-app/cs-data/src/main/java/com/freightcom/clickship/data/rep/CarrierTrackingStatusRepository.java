package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.CarrierTrackingStatus;

@Repository
public interface CarrierTrackingStatusRepository extends JpaRepository<CarrierTrackingStatus, String> {

	public CarrierTrackingStatus findByCarrierAndStatusCode(String carrier, String statusCode);

	public CarrierTrackingStatus findByCarrierAndStatusDescriptionIgnoreCase(String carrier, String statusDescription);
}
