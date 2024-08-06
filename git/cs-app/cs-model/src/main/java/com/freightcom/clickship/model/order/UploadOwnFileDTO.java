package com.freightcom.clickship.model.order;

public class UploadOwnFileDTO {
	
	
	
	
	
	private byte[] file;
	
	private String other;
	
	private String fileType;
	
	private String mappings;
	
	private String platform;

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getMappings() {
		return mappings;
	}

	public void setMappings(String mappings) {
		this.mappings = mappings;
	}
}
