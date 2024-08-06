package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.OrderNotes;

@Repository
@Transactional("csTransactionManager")
public interface OrderNotesRepository extends JpaRepository<OrderNotes, String> {

	public List<OrderNotes> findAllByOrderIdOrderByCreatedDatetimeDesc(String orderId);
	
}
