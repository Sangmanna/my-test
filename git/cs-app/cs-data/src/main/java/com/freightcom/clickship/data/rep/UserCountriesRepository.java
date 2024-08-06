package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.User;
import com.freightcom.clickship.data.entity.UserCountries;
import com.freightcom.clickship.data.entity.projection.UserCountriesProjection;

@Repository
public interface UserCountriesRepository extends JpaRepository<UserCountries, String> {	
	
	@Query(UserCountriesProjection.SELECT
			+ " FROM Code cc, Code pc"
			+ " LEFT JOIN UserCountries uc ON uc.proviance = pc.value AND uc.customer.id= :customerId AND uc.user.username=:username"
			+ " WHERE cc.id = pc.parentCodeId AND cc.groupName='COUNTRY' AND pc.groupName='PROVINCE' AND cc.name='Canada'")
	public List<UserCountriesProjection> getUserCanadaCountries(String customerId, String username);
	
	@Transactional
	public void deleteByCustomerAndUserAndCountry(Customer customer, User user, String country);
	
	public List<UserCountries> findByCustomerAndUserAndCountry(Customer customer, User user, String country);
}
