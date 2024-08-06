package com.freightcom.clickship.model.carrier.ups;

public class UPSOAuthAccountRegisterDTO extends UPSOAuthAccessTokenResponseDto {
	
	private String carrierName;
	
	private String carrierToken;
	
	private boolean negotiatedRates;
	
	private String carrierAccountNumber;

	public String getCarrierToken() {
		return carrierToken;
	}

	public void setCarrierToken(String carrierToken) {
		this.carrierToken = carrierToken;
	}

	public String getCarrierAccountNumber() {
		return carrierAccountNumber;
	}

	public void setCarrierAccountNumber(String carrierAccountNumber) {
		this.carrierAccountNumber = carrierAccountNumber;
	}

	public boolean isNegotiatedRates() {
		return negotiatedRates;
	}

	public void setNegotiatedRates(boolean negotiatedRates) {
		this.negotiatedRates = negotiatedRates;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
}