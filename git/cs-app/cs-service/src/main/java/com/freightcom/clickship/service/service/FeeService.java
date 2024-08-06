package com.freightcom.clickship.service.service;

import java.util.List;

import com.freightcom.clickship.data.entity.Fee;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningTableDTO;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningsChartDTO;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsInvoiceChartDTO;

public interface FeeService {
	
	public void save(Fee fee);

	public List<CsEarningsChartDTO> getCSEarnings(String from, String to);

	public List<CsEarningsChartDTO> getCSEarningsToday(String fromDate, String toDate);
	
	public List<CsInvoiceChartDTO> getCSInvoice(String fromDate1,String toDate1, String fromDate2, String toDate2);
	
	public List<CsInvoiceChartDTO> getCSInvoiceToday(String fromDate, String toDate);

	public CsInvoiceChartDTO getCSInvoiceData(String fromDate, String toDate);

	public List<CsEarningTableDTO> getCsEaningsTable(String fromDate, String toDate, String businessName);

}
