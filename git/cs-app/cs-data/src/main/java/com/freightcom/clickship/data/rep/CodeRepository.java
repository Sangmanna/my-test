package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Code;

@Repository
public interface CodeRepository extends JpaRepository<Code, String> {
	
	public List<Code> findAllByGroupName(String string);

	public List<Code> findAllByParentCodeId(String parentCodeId);

	public Code findByGroupNameAndName(String groupName, String name);

	public Code findByGroupNameAndValue(String groupName, String value);
	
	public List<Code> findByGroupNameAndNameOrValue(String groupName, String name, String value);

	public List<Code> findAllByParentCodeIdAndGroupName(String parentCodeId, String groupName);
	
	public Code findByParentCodeIdAndGroupNameAndNameOrValue(String parentCodeId, String groupName, String name, String value);

	public List<Code> findAllByGroupNameOrderById(String country);

	public Code findTopByNameOrderById(String countryOfOrigin);

	@Query("SELECT c.name FROM Code c WHERE c.groupName = :groupName")
    List<String> findNamesByGroupName(@Param("groupName") String groupName);

	Code findByGroupNameIgnoreCaseAndNameIgnoreCase(String groupName, String name);
}