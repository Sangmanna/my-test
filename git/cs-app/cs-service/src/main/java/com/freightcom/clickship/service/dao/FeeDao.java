package com.freightcom.clickship.service.dao;

import java.util.List;

import com.freightcom.clickship.model.admin.dashboard.csEarnings.CsEarningTableDTO;

public interface FeeDao {

	public List<CsEarningTableDTO> getEarningsTableData(String from, String to, String businessName);

}
