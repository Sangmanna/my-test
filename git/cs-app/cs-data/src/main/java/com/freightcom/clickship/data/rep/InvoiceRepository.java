package com.freightcom.clickship.data.rep;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Invoice;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsInvoiceChartDTO;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {
	
	public Invoice findByCustomerIdAndId(String customerId, String id);

	public Invoice findFirstByCustomerIdOrderByCreatedDatetime(String customerId);
	
	public Invoice findByCustomerIdAndChargebeeId(String customerId, String chargebeeId);

	public Invoice findByCustomerIdAndFreightcomInvoiceId(String customerId, String freightcomInvoiceId);
	
	@Query("select count(1) from com.freightcom.clickship.data.entity.Invoice where customerId = :customerId and (status not in ('Paid') or status is null) and chargebeeId is not null")
	public int countByCustomerIdAndStatusNotPaid(@Param("customerId") String customerId);
	
	@Query("Select new com.freightcom.clickship.model.admin.dashboard.csEarnings.CsInvoiceChartDTO( "
			+ "function('DATE_FORMAT',createdDatetime ,'%d-%m-%Y %H') AS charge_day, " 
			+ "ROUND(SUM(total),2)) from Invoice "
			+ "WHERE createdDatetime BETWEEN :from AND :to AND chargebeeId is not null "
			+ "GROUP BY charge_day "
			+ "ORDER BY charge_day ")
	public List<CsInvoiceChartDTO> getInvoiceToday (Date from, Date to);
	
	@Query("Select new com.freightcom.clickship.model.admin.dashboard.csEarnings.CsInvoiceChartDTO( "
			+ "function('DATE_FORMAT',createdDatetime ,'%d-%m-%Y') AS trans_date, " 
			+ "ROUND(SUM(total),2)) from Invoice "
			+ "WHERE createdDatetime BETWEEN :from AND :to AND chargebeeId is not null "
			+ "GROUP BY trans_date "
			+ "ORDER BY trans_date")
	public List<CsInvoiceChartDTO> getInvoiceBetweenDays (Date from, Date to);
	
	@Query("Select new com.freightcom.clickship.model.admin.dashboard.csEarnings.CsInvoiceChartDTO( " 
			+ "ROUND(SUM(total),2)) from Invoice "
			+ "WHERE createdDatetime BETWEEN :from AND :to AND chargebeeId is not null ")
	public CsInvoiceChartDTO getInvoiceData (Date from, Date to);
	
	
	Invoice findByCustomerIdAndFreightcomV2InvoiceId(String customerId, String freightcomV2InvoiceId);	



}