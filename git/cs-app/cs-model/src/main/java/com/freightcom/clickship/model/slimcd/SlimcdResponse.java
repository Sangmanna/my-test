package com.freightcom.clickship.model.slimcd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SlimcdResponse {
	
	private SlimcdReply reply;
	
	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class SlimcdReply {
		
		private String response;
		
		private String responsecode;
		
		private String description;
		
		private String responseurl;
		
		private SlimcdDatablock datablock;

		public String getResponse() {
			return response;
		}

		public SlimcdReply setResponse(String response) {
			this.response = response;
			return this;
		}

		public String getResponsecode() {
			return responsecode;
		}

		public SlimcdReply setResponsecode(String responsecode) {
			this.responsecode = responsecode;
			return this;
		}

		public String getDescription() {
			return description;
		}

		public SlimcdReply setDescription(String description) {
			this.description = description;
			return this;
		}

		public String getResponseurl() {
			return responseurl;
		}

		public SlimcdReply setResponseurl(String responseurl) {
			this.responseurl = responseurl;
			return this;
		}

		public SlimcdDatablock getDatablock() {
			return datablock;
		}

		public SlimcdReply setDatablock(SlimcdDatablock datablock) {
			this.datablock = datablock;
			return this;
		}
	}
	
	@Data
	@EqualsAndHashCode(callSuper = false)
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class SlimcdDatablock {
		
		private String authcode;
		
		private String approved;
		
		private String cvv2reply;
		
		private String avsreply;
		
		private Long gateid;
		
		private Long bankid;
		
		private String corporatecardindicator;	
		
		private String invoiceno;
		
		private String firstname;
		
		private String lastname;
		
		private String cardtype;
		
		private String last4;
		
		private String expmonth;
		
		private String expyear;
		
		private String processor_token;
		
		private String emvreplytags;
		
		private Double approvedhsaamt;
		
		private Double approvedamt;
		
		private Double bal;
		
		private Double returncheckservicecharge;

		public String getAuthcode() {
			return authcode;
		}

		public SlimcdDatablock setAuthcode(String authcode) {
			this.authcode = authcode;
			return this;
		}

		public String getApproved() {
			return approved;
		}

		public SlimcdDatablock setApproved(String approved) {
			this.approved = approved;
			return this;
		}

		public String getCvv2reply() {
			return cvv2reply;
		}

		public SlimcdDatablock setCvv2reply(String cvv2reply) {
			this.cvv2reply = cvv2reply;
			return this;
		}

		public String getAvsreply() {
			return avsreply;
		}

		public SlimcdDatablock setAvsreply(String avsreply) {
			this.avsreply = avsreply;
			return this;
		}

		public Long getGateid() {
			return gateid;
		}

		public SlimcdDatablock setGateid(Long gateid) {
			this.gateid = gateid;
			return this;
		}

		public Long getBankid() {
			return bankid;
		}

		public SlimcdDatablock setBankid(Long bankid) {
			this.bankid = bankid;
			return this;
		}

		public String getCorporatecardindicator() {
			return corporatecardindicator;
		}

		public SlimcdDatablock setCorporatecardindicator(String corporatecardindicator) {
			this.corporatecardindicator = corporatecardindicator;
			return this;
		}

		public String getInvoiceno() {
			return invoiceno;
		}

		public SlimcdDatablock setInvoiceno(String invoiceno) {
			this.invoiceno = invoiceno;
			return this;
		}

		public String getFirstname() {
			return firstname;
		}

		public SlimcdDatablock setFirstname(String firstname) {
			this.firstname = firstname;
			return this;
		}

		public String getLastname() {
			return lastname;
		}

		public SlimcdDatablock setLastname(String lastname) {
			this.lastname = lastname;
			return this;
		}

		public String getCardtype() {
			return cardtype;
		}

		public SlimcdDatablock setCardtype(String cardtype) {
			this.cardtype = cardtype;
			return this;
		}

		public String getLast4() {
			return last4;
		}

		public SlimcdDatablock setLast4(String last4) {
			this.last4 = last4;
			return this;
		}

		public String getExpmonth() {
			return expmonth;
		}

		public SlimcdDatablock setExpmonth(String expmonth) {
			this.expmonth = expmonth;
			return this;
		}

		public String getExpyear() {
			return expyear;
		}

		public SlimcdDatablock setExpyear(String expyear) {
			this.expyear = expyear;
			return this;
		}

		public String getProcessor_token() {
			return processor_token;
		}

		public SlimcdDatablock setProcessor_token(String processor_token) {
			this.processor_token = processor_token;
			return this;
		}

		public String getEmvreplytags() {
			return emvreplytags;
		}

		public SlimcdDatablock setEmvreplytags(String emvreplytags) {
			this.emvreplytags = emvreplytags;
			return this;
		}

		public Double getApprovedhsaamt() {
			return approvedhsaamt;
		}

		public SlimcdDatablock setApprovedhsaamt(Double approvedhsaamt) {
			this.approvedhsaamt = approvedhsaamt;
			return this;
		}

		public Double getApprovedamt() {
			return approvedamt;
		}

		public SlimcdDatablock setApprovedamt(Double approvedamt) {
			this.approvedamt = approvedamt;
			return this;
		}

		public Double getBal() {
			return bal;
		}

		public SlimcdDatablock setBal(Double bal) {
			this.bal = bal;
			return this;
		}

		public Double getReturncheckservicecharge() {
			return returncheckservicecharge;
		}

		public SlimcdDatablock setReturncheckservicecharge(Double returncheckservicecharge) {
			this.returncheckservicecharge = returncheckservicecharge;
			return this;
		}
	}

	public SlimcdReply getReply() {
		return reply;
	}

	public SlimcdResponse setReply(SlimcdReply reply) {
		this.reply = reply;
		return this;
	}
}
