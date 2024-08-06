package com.freightcom.clickship.model.v2.claim;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.freightcom.clickship.model.v2.EntityIdDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClaimPaymentDTO {
	private Object allowed_methods;
	private Amount amount_towards_goods;
	private Amount amount_towards_shipping;
	private Amount total_amount;
	private String notes;
	private Date approved_at;
	private String primary_method;
	private ApplyToInvoicesProperties applyToInvoicesProperties;
	private ChequeProperties cheque_properties;
	private CreditCardRefundProperties credit_card_refund_properties;
	private FundTransferProperties funds_transfer_properties;
	private Date accepted_at;
	private EntityIdDTO accepted_by;
	private List<InvoicePayment> invoicePayments;
	private String refund_transaction_id;
	private String refund_invoice_id;
	public Object getAllowed_methods() {
		return allowed_methods;
	}
	public ClaimPaymentDTO setAllowed_methods(Object allowed_methods) {
		this.allowed_methods = allowed_methods;
		return this;
	}
	public Amount getAmount_towards_goods() {
		return amount_towards_goods;
	}
	public ClaimPaymentDTO setAmount_towards_goods(Amount amount_towards_goods) {
		this.amount_towards_goods = amount_towards_goods;
		return this;
	}
	public Amount getAmount_towards_shipping() {
		return amount_towards_shipping;
	}
	public ClaimPaymentDTO setAmount_towards_shipping(Amount amount_towards_shipping) {
		this.amount_towards_shipping = amount_towards_shipping;
		return this;
	}
	public Amount getTotal_amount() {
		return total_amount;
	}
	public ClaimPaymentDTO setTotal_amount(Amount total_amount) {
		this.total_amount = total_amount;
		return this;
	}
	public String getNotes() {
		return notes;
	}
	public ClaimPaymentDTO setNotes(String notes) {
		this.notes = notes;
		return this;
	}
	public Date getApproved_at() {
		return approved_at;
	}
	public ClaimPaymentDTO setApproved_at(Date approved_at) {
		this.approved_at = approved_at;
		return this;
	}
	public String getPrimary_method() {
		return primary_method;
	}
	public ClaimPaymentDTO setPrimary_method(String primary_method) {
		this.primary_method = primary_method;
		return this;
	}
	public ApplyToInvoicesProperties getApplyToInvoicesProperties() {
		return applyToInvoicesProperties;
	}
	public ClaimPaymentDTO setApplyToInvoicesProperties(ApplyToInvoicesProperties applyToInvoicesProperties) {
		this.applyToInvoicesProperties = applyToInvoicesProperties;
		return this;
	}
	public ChequeProperties getCheque_properties() {
		return cheque_properties;
	}
	public ClaimPaymentDTO setCheque_properties(ChequeProperties cheque_properties) {
		this.cheque_properties = cheque_properties;
		return this;
	}
	public CreditCardRefundProperties getCredit_card_refund_properties() {
		return credit_card_refund_properties;
	}
	public ClaimPaymentDTO setCredit_card_refund_properties(CreditCardRefundProperties credit_card_refund_properties) {
		this.credit_card_refund_properties = credit_card_refund_properties;
		return this;
	}
	public FundTransferProperties getFunds_transfer_properties() {
		return funds_transfer_properties;
	}
	public ClaimPaymentDTO setFunds_transfer_properties(FundTransferProperties funds_transfer_properties) {
		this.funds_transfer_properties = funds_transfer_properties;
		return this;
	}
	public Date getAccepted_at() {
		return accepted_at;
	}
	public ClaimPaymentDTO setAccepted_at(Date accepted_at) {
		this.accepted_at = accepted_at;
		return this;
	}
	public EntityIdDTO getAccepted_by() {
		return accepted_by;
	}
	public ClaimPaymentDTO setAccepted_by(EntityIdDTO accepted_by) {
		this.accepted_by = accepted_by;
		return this;
	}
	public List<InvoicePayment> getInvoicePayments() {
		return invoicePayments;
	}
	public ClaimPaymentDTO setInvoicePayments(List<InvoicePayment> invoicePayments) {
		this.invoicePayments = invoicePayments;
		return this;
	}
	public String getRefund_transaction_id() {
		return refund_transaction_id;
	}
	public ClaimPaymentDTO setRefund_transaction_id(String refund_transaction_id) {
		this.refund_transaction_id = refund_transaction_id;
		return this;
	}
	public String getRefund_invoice_id() {
		return refund_invoice_id;
	}

	public ClaimPaymentDTO setRefund_invoice_id(String refund_invoice_id) {
		this.refund_invoice_id = refund_invoice_id;
		return this;
	}
	
}
