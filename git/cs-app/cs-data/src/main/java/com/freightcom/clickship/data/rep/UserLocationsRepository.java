package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.entity.UserLocations;
import com.freightcom.clickship.data.entity.projection.UserLocationsProjection;

@Repository
public interface UserLocationsRepository extends JpaRepository<UserLocations, String> {	
	
	@Transactional
	public void deleteByCustomerAndUser(Customer customer, User user);
	
	@Query(nativeQuery = true, value = UserLocationsProjection.SELECT
			+ " FROM user_locations ul"
			+ " RIGHT JOIN customer_address ca ON ca.id = ul.location_id AND ul.customer_id = :customerId AND ul.username = :username"
			+ " WHERE ca.customer_id = :customerId")
	public List<UserLocationsProjection> getUserLocations(String customerId, String username);
	
}
