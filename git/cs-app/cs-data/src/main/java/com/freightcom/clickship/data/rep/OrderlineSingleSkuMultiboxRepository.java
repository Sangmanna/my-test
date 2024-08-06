package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.OrderlineSingleSkuMultibox;

@Repository
public interface OrderlineSingleSkuMultiboxRepository extends JpaRepository<OrderlineSingleSkuMultibox, String> {

	public List<OrderlineSingleSkuMultibox> findAllByOrderId(String id);
	
}
