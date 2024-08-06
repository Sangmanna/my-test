package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.AmazonFeed;
import com.freightcom.clickship.data.entity.Order;

@Repository
public interface AmazonFeedRepository extends JpaRepository<AmazonFeed, String> {	
	
	public AmazonFeed findByOrder(Order order);
	
	public AmazonFeed getFeedResponseByFeedSubmissionId(String feedSubmissionId);
}
