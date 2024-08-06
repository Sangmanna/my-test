package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.entity.UserMarketplaces;
import com.freightcom.clickship.data.entity.projection.UserMarketplacesProjection;

@Repository
public interface UserMarketplacesRepository extends JpaRepository<UserMarketplaces, String> {
	
	@Transactional
	public void deleteByCustomerAndUser(Customer customer, User user);
	
	@Query(UserMarketplacesProjection.SELECT
			+ " FROM UserMarketplaces um"
			+ " RIGHT JOIN Marketplace mp ON mp.id = um.marketplace.id AND mp.customer.id = :customerId AND um.user.username=:username"
			+ " WHERE mp.customer.id = :customerId AND mp.integrationSuccess is true AND mp.isDeleted is false")
	public List<UserMarketplacesProjection> getUserMarketplaces(String customerId, String username);
	
	public List<UserMarketplaces> findByCustomerAndUser(Customer customer, User user);
	
	
}
