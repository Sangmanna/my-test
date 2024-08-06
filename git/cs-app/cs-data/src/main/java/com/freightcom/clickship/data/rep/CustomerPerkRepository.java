package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerPerk;
import com.freightcom.clickship.data.entity.Perks;

@Repository
public interface CustomerPerkRepository extends JpaRepository<CustomerPerk, String>{

	public CustomerPerk findByCustomerAndPerks(Customer customer, Perks perk);
}
