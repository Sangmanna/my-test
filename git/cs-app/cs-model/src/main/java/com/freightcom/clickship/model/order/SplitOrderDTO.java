package com.freightcom.clickship.model.order;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.freightcom.clickship.model.CommonDTO;

public class SplitOrderDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = 7241702775887154638L;

	private String orderId;
	private List<SplitOrderVO> splitInfo;
	private Map<String, int[]> quantityMap;

	public List<SplitOrderVO> getSplitInfo() {
		return splitInfo;
	}

	public SplitOrderDTO setSplitInfo(List<SplitOrderVO> splitInfo) {
		this.splitInfo = splitInfo;
		if (splitInfo != null && splitInfo.size() > 0) {
			quantityMap = new HashMap<>();
			splitInfo.forEach(vo -> quantityMap.put(vo.getOrderlineId(), vo.getQuantities()));
		}
		return this;
	}

	public int[] getQuantity(String orderlineId) {
		if (quantityMap != null) {
			return quantityMap.get(orderlineId);
		}
		return null;
	}

	public String getOrderId() {
		return orderId;
	}

	public SplitOrderDTO setOrderId(String orderId) {
		this.orderId = orderId;
		return this;
	}
}