package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Shipment;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.entity.UserShipments;

@Repository
public interface UserShipmentsRepository extends JpaRepository<UserShipments, String> {
	
	public List<UserShipments> findByUser(User user);
	
	public UserShipments findByShipment(Shipment shipment);
	
	public List<UserShipments> findAllByShipmentIn(List<Shipment> shipments);

}
