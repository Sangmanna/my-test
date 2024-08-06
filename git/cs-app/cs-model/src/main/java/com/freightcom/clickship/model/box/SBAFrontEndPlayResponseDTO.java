package com.freightcom.clickship.model.box;

import java.io.Serializable;
import java.util.List;

import com.freightcom.clickship.model.CommonDTO;

public class SBAFrontEndPlayResponseDTO extends CommonDTO implements Serializable {

	private static final long serialVersionUID = 7532599650603028218L;
	
	private List<BoxDTO> packages;
	
	private List<BoxDTO> pallets;
	
	private boolean accurateRates = true;
	
	public boolean isAccurateRates() {
		return accurateRates;
	}

	public SBAFrontEndPlayResponseDTO setAccurateRates(boolean accurateRates) {
		this.accurateRates = accurateRates;
		return this;
	}

	public List<BoxDTO> getPackages() {
		return packages;
	}

	public SBAFrontEndPlayResponseDTO setPackages(List<BoxDTO> packages) {
		this.packages = packages;
		return this;
	}

	public List<BoxDTO> getPallets() {
		return pallets;
	}

	public SBAFrontEndPlayResponseDTO setPallets(List<BoxDTO> pallets) {
		this.pallets = pallets;
		return this;
	}
	
}