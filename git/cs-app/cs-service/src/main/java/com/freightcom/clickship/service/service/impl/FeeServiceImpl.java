package com.freightcom.clickship.service.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Fee;
import com.freightcom.clickship.data.rep.FeeRepository;
import com.freightcom.clickship.data.rep.InvoiceRepository;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningTableDTO;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningsChartDTO;
import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsInvoiceChartDTO;
import com.freightcom.clickship.service.dao.FeeDao;
import com.freightcom.clickship.service.service.FeeService;

@Service
public class FeeServiceImpl implements FeeService {

	private static final String ERROR_MSG = "Exception while parsing date. Error:[{}]";

	private Logger logger = LogManager.getLogger(this.getClass());

	private static final String YYYY_M_D_T = "yyyy-M-d HH:mm:ss";

	@Autowired
	private FeeDao feeDao;
	
	@Autowired
	private FeeRepository feeRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Override
	@Transactional
	public void save(Fee fee) {
		feeRepository.save(fee);
	}

	@Override
	public List<CsEarningsChartDTO> getCSEarnings(String from, String to) {

		try {
			Date toDate = new SimpleDateFormat(YYYY_M_D_T).parse(to);
			Date fromDate = new SimpleDateFormat(YYYY_M_D_T).parse(from);

			return feeRepository.getEarningsBetweenDays(fromDate, toDate);
		} catch (ParseException e) {
			logger.error(ERROR_MSG, e.getMessage(), e);
		}

		return Collections.emptyList();
	}

	@Override
	public List<CsEarningsChartDTO> getCSEarningsToday(String from, String to) {
		try {
			Date toDate = new SimpleDateFormat(YYYY_M_D_T).parse(to);
			Date fromDate = new SimpleDateFormat(YYYY_M_D_T).parse(from);

			return feeRepository.getEarningsToday(fromDate, toDate);
		} catch (ParseException e) {
			logger.error(ERROR_MSG, e.getMessage(), e);
		}
		
		return Collections.emptyList();
	}
	
	@Override
	public List<CsInvoiceChartDTO> getCSInvoice(String from1,String to1, String from2, String to2) {
		try {
			Date fromDate1 = new SimpleDateFormat(YYYY_M_D_T).parse(from1);
			Date toDate1 = new SimpleDateFormat(YYYY_M_D_T).parse(to1);
			Date fromDate2 = new SimpleDateFormat(YYYY_M_D_T).parse(from2);
			Date toDate2 = new SimpleDateFormat(YYYY_M_D_T).parse(to2);
			
			List<CsInvoiceChartDTO> previousList = invoiceRepository.getInvoiceBetweenDays(fromDate1,toDate1); 
			previousList = CsInvoiceChartDTO.setTermForList(previousList, 1);

			List<CsInvoiceChartDTO> currentList = invoiceRepository.getInvoiceBetweenDays(fromDate2,toDate2); 
			currentList = CsInvoiceChartDTO.setTermForList(currentList, 2);
			
			previousList.addAll(currentList);
			return previousList;
			
		} catch (ParseException e) {
			logger.error(ERROR_MSG, e.getMessage(), e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public List<CsInvoiceChartDTO> getCSInvoiceToday(String from, String to) {
		try {
			
			Date fromDate1 = new SimpleDateFormat(YYYY_M_D_T).parse(from);
			Date toDate2 = new SimpleDateFormat(YYYY_M_D_T).parse(to);

			Calendar from2 = Calendar.getInstance();
			from2.setTime(fromDate1);
			from2.add(Calendar.DATE, +1);
			
			Calendar to1 = Calendar.getInstance();
			to1.setTime(toDate2);
			to1.add(Calendar.DATE, -1);

			List<CsInvoiceChartDTO> previousDayList = invoiceRepository.getInvoiceToday(fromDate1,to1.getTime()); 
			previousDayList = CsInvoiceChartDTO.setTermForList(previousDayList, 1);
			List<CsInvoiceChartDTO> todayList = invoiceRepository.getInvoiceToday(from2.getTime(),toDate2); 
			todayList = CsInvoiceChartDTO.setTermForList(todayList, 2);

			previousDayList.addAll(todayList);
			return previousDayList;
		} catch (ParseException e) {
			logger.error(ERROR_MSG, e.getMessage(), e);
		}
		return Collections.emptyList();
	}
	
	@Override
	public CsInvoiceChartDTO getCSInvoiceData(String from, String to) {
		try {
			
			Date fromDate = new SimpleDateFormat(YYYY_M_D_T).parse(from);
			Date toDate = new SimpleDateFormat(YYYY_M_D_T).parse(to);
			return invoiceRepository.getInvoiceData(fromDate,toDate); 
		} catch (ParseException e) {
			logger.error("Exception while fetching invoice data. Error:[{}]", e.getMessage(), e);
		}
		return null;
	}

	@Override
	public List<CsEarningTableDTO> getCsEaningsTable(String from, String to, String businessName) {
		return feeDao.getEarningsTableData(from, to, businessName);
	}

}
