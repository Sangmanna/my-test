package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Carrier;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier, String> {
	public List<Carrier> findByServiceGroupId(String serviceGroupId);
	
	public Carrier findByServiceAndServiceId(String service, String serviceId);

	public Carrier findByV2ServiceId(String v2ServiceId);
	
	public Carrier findByServiceAndShortName(String service, String shortName);

	public Carrier findByServiceIdAndShortName(String serviceId, String shortName);
	
	public Carrier findByServiceIdAndServiceGroupId(String serviceId, String serviceGroupId);
	
	public List<Carrier> findByShortNameAndServiceIdentifier(String shortName, String serviceIdentifier);
	
	public Carrier findByServiceIdAndServiceGroupIdAndServiceIdentifier(String serviceId, String serviceGroupId, String serviceIdentifier);
	
	@Query("SELECT DISTINCT c FROM Carrier c WHERE c.serviceId=:serviceId OR c.v2ServiceId=:serviceId ")
	public Carrier findByServiceId(@Param("serviceId") String serviceId);
	
	@Query("SELECT DISTINCT shortName FROM Carrier c WHERE c.service = :service")
	public String getShortNameByService(@Param("service") String service);
	
	@Query("SELECT DISTINCT c FROM Carrier c WHERE c.serviceIdentifier = :serviceIdentifier")
	public List<Carrier> findDistinctCarriers(@Param("serviceIdentifier") String serviceIdentifier);
	
	@Query("SELECT DISTINCT c FROM Carrier c WHERE c.serviceIdentifier=:serviceIdentifier AND (c.serviceId=:serviceId OR c.v2ServiceId=:serviceId)")
	public Carrier findByServiceIdAndServiceIdentifier(@Param("serviceId") String serviceId, @Param("serviceIdentifier") String serviceIdentifier);
	
	@Query("SELECT "
			+ "new com.freightcom.clickship.data.entity.Carrier(c.serviceGroupId, c.shortName, c.showPickupOption, c.showInsuranceOption, c.serviceIdentifier, c.isDisplayToCustomer, c.imageName, c.palletCarrier, c.v2ImageName) "
			+ "FROM Carrier c "
			+ "GROUP BY c.serviceGroupId, c.shortName, c.showPickupOption, c.showInsuranceOption, c.serviceIdentifier, c.isDisplayToCustomer "
			+ "ORDER BY c.serviceIdentifier, c.shortName ")
	public List<Carrier> findCarriers();

	public List<Carrier> findByPalletCarrierTrue();
	
    List<Carrier> findByV2ServiceIdStartingWith(String carrierIdPrefix);
}