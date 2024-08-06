package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Permissions;

@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, String> {

	public Permissions findByTypeAndValue(String type, String value);
	
}