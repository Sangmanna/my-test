package com.freightcom.clickship.model.marketplace.wix.ecom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WixEcomAppliedDiscounts {

	@JsonProperty("id")
	private String id;

	@JsonProperty("discountType")
	private String discountType;

	@JsonProperty("coupon")
	private WixEcomCoupon coupon;

	@JsonProperty("discountRule")
	private WixEcomDiscountRule discountRule;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public WixEcomCoupon getCoupon() {
		return coupon;
	}

	public void setCoupon(WixEcomCoupon coupon) {
		this.coupon = coupon;
	}

	public WixEcomDiscountRule getDiscountRule() {
		return discountRule;
	}

	public void setDiscountRule(WixEcomDiscountRule discountRule) {
		this.discountRule = discountRule;
	}



	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomCoupon {

		@JsonProperty("id")
		private String id;

		@JsonProperty("code")
		private String code;

		@JsonProperty("name")
		private String name;

		@JsonProperty("amount")
		private WixEcomAmount amount;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public WixEcomAmount getAmount() {
			return amount;
		}

		public void setAmount(WixEcomAmount amount) {
			this.amount = amount;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomDiscountRule {

		@JsonProperty("id")
		private String id;

		@JsonProperty("name")
		private WixEcomDiscountRuleName name;

		@JsonProperty("amount")
		private WixEcomAmount amount;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public WixEcomDiscountRuleName getName() {
			return name;
		}

		public void setName(WixEcomDiscountRuleName name) {
			this.name = name;
		}

		public WixEcomAmount getAmount() {
			return amount;
		}

		public void setAmount(WixEcomAmount amount) {
			this.amount = amount;
		}

	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomDiscountRuleName {

		@JsonProperty("original")
		private String original;

		@JsonProperty("translated")
		private String translated;

		public String getOriginal() {
			return original;
		}

		public void setOriginal(String original) {
			this.original = original;
		}

		public String getTranslated() {
			return translated;
		}

		public void setTranslated(String translated) {
			this.translated = translated;
		}
	}

	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class WixEcomDiscountRuleAmount {

		@JsonProperty("amount")
		private String amount;

		@JsonProperty("formattedAmount")
		private String formattedAmount;

		public String getAmount() {
			return amount;
		}

		public void setAmount(String amount) {
			this.amount = amount;
		}

		public String getFormattedAmount() {
			return formattedAmount;
		}

		public void setFormattedAmount(String formattedAmount) {
			this.formattedAmount = formattedAmount;
		}
	}
}
