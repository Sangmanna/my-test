package com.freightcom.clickship.data.rep;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.Fee;
import com.freightcom.clickship.data.entity.FeeType;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningsChartDTO;


@Repository
public interface FeeRepository extends JpaRepository<Fee, String> {
	
	public List<Fee> findByStatusIsNull();
	
	public List<Fee> findByCustomerAndStatusIsNull(Customer customer);
	
	@Query("SELECT f FROM Fee f "
			+ "WHERE f.status IS NULL "
			+ "AND f.customer=:customer "
			+ "AND f.feeType=:feeType "
			+ "AND f.createdDatetime > CURDATE()")
	public List<Fee> findTodayFeesByCustomerAndFeeTypeAndStatusIsNull(Customer customer, FeeType feeType);
	
	@Query("SELECT f FROM Fee f "
			+ "WHERE f.status IS NULL "
			+ "AND f.customer=:customer "
			+ "AND f.feeType=:feeType "
			+ "AND f.createdDatetime < :date")
	public List<Fee> findByCustomerAndFeeTypeAndStatusIsNullAndCreatedDate(Customer customer, FeeType feeType, Date date);
	
	@Query("SELECT DISTINCT new com.freightcom.clickship.data.entity.Customer("
			+ "f.customer.id, f.customer.chargebeeId, f.customer.chargebeeSubscriptionId) "
			+ "FROM Fee f "
			+ "WHERE f.status IS NULL")
	public List<Customer> getDistinctCustomerFromFee();

	/************************************************************************************************/
	
	/*
	 * For admin portal
	 * 
	 */

	@Query("Select new com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningsChartDTO( "
			+ "feeTypeName, ROUND(feeTotal,2) as charge, function('DATE_FORMAT',createdDatetime ,'%d-%m-%Y %H') AS charge_day, " 
			+ "SUM(ROUND(feeTotal,2))) from Fee "
			+ "WHERE createdDatetime BETWEEN :from AND :to "
			+ "GROUP BY charge_day,feeTypeName "
			+ "ORDER BY feeTypeName,charge_day")
	public List<CsEarningsChartDTO> getEarningsToday (Date from, Date to);
	
	@Query("Select new com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningsChartDTO( "
			+ "feeTypeName, ROUND(feeTotal,2) as charge, function('DATE_FORMAT',createdDatetime ,'%d-%m-%Y') AS trans_date, " 
			+ "SUM(ROUND(feeTotal,2))) from Fee "
			+ "WHERE createdDatetime BETWEEN :from AND :to "
			+ "GROUP BY function('DATE_FORMAT',createdDatetime ,'%d-%m-%Y'),feeTypeName "
			+ "ORDER BY feeTypeName,trans_date")
	public List<CsEarningsChartDTO> getEarningsBetweenDays (Date from, Date to);
	
}
