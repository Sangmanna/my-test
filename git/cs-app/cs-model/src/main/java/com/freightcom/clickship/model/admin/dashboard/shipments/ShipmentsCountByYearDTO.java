package com.freightcom.clickship.model.admin.dashboard.shipments;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ShipmentsCountByYearDTO {

	private int term;
	private int month;
	private int count;

	public ShipmentsCountByYearDTO(Object[] columns) {
		super();
//		this.term = ((BigInteger) columns[0]).intValue();
		this.month =  (Integer)columns[0];
		if(columns[1] instanceof BigDecimal) {
			this.count = ((BigDecimal) columns[1]).intValue();
		}else{
			this.count = ((BigInteger) columns[1]).intValue();
		}
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
