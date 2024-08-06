package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.PrefetchQuotes;

@Repository
public interface PrefetchQuoteRepository extends JpaRepository<PrefetchQuotes, String> {

	public List<PrefetchQuotes> findByOrder(Order order);
	
	public List<PrefetchQuotes> findAllByOrderInAndServiceIdIn(List<Order> list, List<String> serviceIds);

}
