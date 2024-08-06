package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Tag;
import com.freightcom.clickship.data.entity.TagLink;

@Repository
public interface TagLinkRepository extends JpaRepository<TagLink, String> {
	
	public List<TagLink> findByTag(Tag tag);
	
	public List<TagLink> findByTargetId(String targetId);
	
	public List<TagLink> findByTagAndTargetId(Tag tag, String targetId);
	
	public List<TagLink> findByTargetIdAndShippingRuleActionId(String targetId, String shippingRuleActionId);
}
