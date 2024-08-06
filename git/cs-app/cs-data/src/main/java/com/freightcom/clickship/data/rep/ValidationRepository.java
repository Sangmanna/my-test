package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Validation;

@Repository
public interface ValidationRepository extends JpaRepository<Validation, Long> {

	@Query("select v from Validation v where :endpointUri LIKE v.endpointUri||'%'")
	public List<Validation> findByEndpointUri(@Param("endpointUri") String endpointUri);

}