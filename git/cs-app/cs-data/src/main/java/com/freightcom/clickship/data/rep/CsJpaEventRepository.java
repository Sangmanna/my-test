package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.CsJpaEvent;

@Repository
public interface CsJpaEventRepository extends JpaRepository<CsJpaEvent, String> {
	
	public List<CsJpaEvent> findAllByStatus(String status);
	
	public CsJpaEvent findByTypeAndActionAndRefKey1(String type, String action, String refKey1);
	
}
