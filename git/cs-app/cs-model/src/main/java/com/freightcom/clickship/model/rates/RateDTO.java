package com.freightcom.clickship.model.rates;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.freightcom.clickship.model.CommonDTO;

public class RateDTO extends CommonDTO implements Serializable {
	
	private static final long serialVersionUID = -8060271154494787667L;

	private String note;
	
	private Date validUntil;
	
	private String currency;
	
	private String imageName;
	
	private String v2ImageName;

	private String shortName;
	
	private String serviceId;
	
	private String v2ServiceId;

	private String carrierId;
	
	private int estimatedDate;
	
	private String carrierName;
	
	private double totalCharge;
	
	private String rateRequestId;
	
	private String carrierServiceName;
	
	private String carrierAccountNumber;
	
	private double canadianTotalCharge;
	
	private boolean carrierRate = false;
	
	private boolean isPaperlessCustomsInvoice;

	private boolean showPickupOption = true;

	private boolean showInsuranceOption = true;
	
	private boolean showPickupInstructions = true;

	private boolean palletRate = false;
	
	private List<RateChargeDTO> charges = new ArrayList<>();

	private Boolean whiteGloveDelivery;
	
	private boolean showPickupOptionInQuickShip = false;

	public RateDTO() {
		super();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		 
		this.validUntil = calendar.getTime();
	}

	public String getCarrierName() {
		return carrierName;
	}

	public RateDTO setCarrierName(String carrierName) {
		this.carrierName = carrierName;
		return this;
	}

	public double getTotalCharge() {
		return totalCharge;
	}

	public RateDTO setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
		return this;
	}

	public String getServiceId() {
		return serviceId;
	}

	public RateDTO setServiceId(String serviceId) {
		this.serviceId = serviceId;
		return this;
	}

	public String getV2ServiceId() {
		return v2ServiceId;
	}

	public RateDTO setV2ServiceId(String v2ServiceId) {
		this.v2ServiceId = v2ServiceId;
		return this;
	}

	public String getCurrency() {
		return currency;
	}

	public RateDTO setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public int getEstimatedDate() {
		return estimatedDate;
	}

	public RateDTO setEstimatedDate(int estimatedDate) {
		this.estimatedDate = estimatedDate;
		return this;
	}

	public boolean isCarrierRate() {
		return carrierRate;
	}

	public RateDTO setCarrierRate(boolean carrierRate) {
		this.carrierRate = carrierRate;
		return this;
	}
	
	public String getCarrierId() {
		return carrierId;
	}

	public RateDTO setCarrierId(String carrierId) {
		this.carrierId = carrierId;
		return this;
	}

	public String getCarrierServiceName() {
		return carrierServiceName;
	}

	public RateDTO setCarrierServiceName(String carrierServiceName) {
		this.carrierServiceName = carrierServiceName;
		return this;
	}
	
	
	public String getShortName() {
		return shortName;
	}

	public RateDTO setShortName(String shortName) {
		this.shortName = shortName;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RateDTO) {
			RateDTO target = (RateDTO)obj;
			return (StringUtils.equalsIgnoreCase(target.getServiceId(), this.getServiceId()));
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return (this.getServiceId() != null ? this.getServiceId().hashCode() : 0) + super.hashCode();
	}

	public List<RateChargeDTO> getCharges() {
		return charges;
	}

	public RateDTO setCharges(List<RateChargeDTO> charges) {
		this.charges = charges;
		return this;
	}
	
	public RateDTO addCharge(RateChargeDTO charge) {
		if(this.charges == null) {
			this.charges = new ArrayList<>();
		} 
		this.charges.add(charge);
		return this;
	}

	public String getCarrierAccountNumber() {
		return carrierAccountNumber;
	}

	public RateDTO setCarrierAccountNumber(String carrierAccountNumber) {
		this.carrierAccountNumber = carrierAccountNumber;
		return this;
	}

	public double getCanadianTotalCharge() {
		return canadianTotalCharge;
	}

	public RateDTO setCanadianTotalCharge(double canadianTotalCharge) {
		this.canadianTotalCharge = canadianTotalCharge;
		return this;
	}

	public String getImageName() {
		return imageName;
	}

	public RateDTO setImageName(String imageName) {
		this.imageName = imageName;
		return this;
	}

	public String getV2ImageName() {
		return v2ImageName;
	}

	public RateDTO setV2ImageName(String v2ImageName) {
		this.v2ImageName = v2ImageName;
		return this;
	}

	public String getNote() {
		return note;
	}

	public RateDTO setNote(String note) {
		this.note = note;
		return this;
	}

	public boolean isShowPickupOption() {
		return showPickupOption;
	}

	public RateDTO setShowPickupOption(boolean showPickupOption) {
		this.showPickupOption = showPickupOption;
		return this;
	}

	public boolean isShowInsuranceOption() {
		return showInsuranceOption;
	}

	public RateDTO setShowInsuranceOption(boolean showInsuranceOption) {
		this.showInsuranceOption = showInsuranceOption;
		return this;
	}

	public boolean isPaperlessCustomsInvoice() {
		return isPaperlessCustomsInvoice;
	}

	public RateDTO setPaperlessCustomsInvoice(boolean isPaperlessCustomsInvoice) {
		this.isPaperlessCustomsInvoice = isPaperlessCustomsInvoice;
		return this;
	}

	public Date getValidUntil() {
		return validUntil;
	}

	public RateDTO setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
		return this;
	}

	public boolean isPalletRate() {
		return palletRate;
	}

	public void setPalletRate(boolean palletRate) {
		this.palletRate = palletRate;
	}
	
	public String getRateRequestId() {
		return rateRequestId;
	}

	public RateDTO setRateRequestId(String rateRequestId) {
		this.rateRequestId = rateRequestId;
		return this;
	}

	public Boolean getWhiteGloveDelivery() {
		return whiteGloveDelivery;
	}

	public RateDTO setWhiteGloveDelivery(Boolean whiteGloveDelivery) {
		this.whiteGloveDelivery = whiteGloveDelivery;
		return this;
	}

	public boolean isShowPickupInstructions() {
		return showPickupInstructions;
	}

	public RateDTO setShowPickupInstructions(boolean showPickupInstructions) {
		this.showPickupInstructions = showPickupInstructions;
		return this;
	}

	public boolean isShowPickupOptionInQuickShip() {
		return showPickupOptionInQuickShip;
	}

	public void setShowPickupOptionInQuickShip(boolean showPickupOptionInQuickShip) {
		this.showPickupOptionInQuickShip = showPickupOptionInQuickShip;
	}
}
