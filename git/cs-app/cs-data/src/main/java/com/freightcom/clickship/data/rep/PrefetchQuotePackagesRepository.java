package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.PrefetchQuotePackages;

@Repository
public interface PrefetchQuotePackagesRepository extends JpaRepository<PrefetchQuotePackages, String> {

	public List<PrefetchQuotePackages> findByOrder(Order order);
	
	public List<PrefetchQuotePackages> findAllByOrderIn(List<Order> order);

}
