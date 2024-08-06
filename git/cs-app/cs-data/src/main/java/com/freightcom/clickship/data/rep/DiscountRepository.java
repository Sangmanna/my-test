package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Discount;
import com.freightcom.clickship.data.entity.Order;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, String> {
	
	public List<Discount> findByOrder(Order order);
	
	public Discount findByOrderAndTypeAndTitle(Order order, String type, String title);
}