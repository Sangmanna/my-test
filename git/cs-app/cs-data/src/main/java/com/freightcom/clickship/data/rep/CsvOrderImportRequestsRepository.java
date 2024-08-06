package com.freightcom.clickship.data.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.CsvOrderImportRequests;

@Repository
public interface CsvOrderImportRequestsRepository extends JpaRepository<CsvOrderImportRequests, String> {

	public CsvOrderImportRequests findByMarketplaceIdAndStatus(String marketplaceId,String status);

}
