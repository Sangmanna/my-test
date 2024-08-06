package com.freightcom.clickship.model.marketplace.amazon.orderitems;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OrderItem")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="QuantityOrdered")
	private String quantityOrdered;
	
	@XmlElement(name="Title")
	private String title;
	
	@XmlElement(name="PromotionDiscount")
	private PromotionDiscount promotionDiscount;
	
	@XmlElement(name="ConditionId")
	private String conditionId;
	
	@XmlElement(name="IsGift")
	private String isGift;
	
	@XmlElement(name="ASIN")
	private String asin;
	
	@XmlElement(name="SellerSKU")
	private String sellerSKU;
	
	@XmlElement(name="OrderItemId")
	private String orderItemId;
	
	@XmlElement(name="IsTransparency")
	private String isTransparency;
	
	@XmlElement(name="ProductInfo")
	private ProductInfo productInfo;
	
	@XmlElement(name="QuantityShipped")
	private String quantityShipped;
	
	@XmlElement(name="ConditionSubtypeId")
	private String conditionSubtypeId;
	
	@XmlElement(name="ItemPrice")
	private ItemPrice itemPrice;
	
	@XmlElement(name="ItemTax")
	private ItemTax itemTax;
	
	@XmlElement(name="PromotionDiscountTax")
	private PromotionDiscountTax promotionDiscountTax;
	
	@XmlElement(name="ShippingPrice")
	private ShippingPrice shippingPrice;
	
	@XmlElement(name="GiftWrapPrice")
	private GiftWrapPrice giftWrapPrice;
	
	@XmlElement(name="ShippingTax")
	private ShippingTax shippingTax;
	
	@XmlElement(name="GiftWrapTax")
	private GiftWrapTax giftWrapTax;
	
	@XmlElement(name="ShippingDiscount")
	private ShippingDiscount shippingDiscount;
	
	@XmlElement(name="ShippingDiscountTax")
	private ShippingDiscountTax shippingDiscountTax;
	
	@XmlElement(name="CODFee")
	private CODFee codFee;
	
	@XmlElement(name="CODFeeDiscount")
	private CODFeeDiscount codFeeDiscount;
	
	
	public OrderItem() {
		super();
	}
	
	public OrderItem(String quantityOrdered,String title, PromotionDiscount promotionDiscount,
			String conditionId,String isGift,String asin,String sellerSKU, String orderItemId,
			String isTransparency,ProductInfo productInfo,String quantityShipped,
			String conditionSubtypeId, ItemPrice itemPrice,ItemTax itemTax,PromotionDiscountTax promotionDiscountTax  ) {
		super();
		
		this.quantityOrdered = quantityOrdered;
		this.title = title;
		this.promotionDiscount = promotionDiscount;
		this.conditionId = conditionId;
		this.isGift = isGift;
		this.asin = asin;
		this.sellerSKU = sellerSKU;
		this.orderItemId = orderItemId;
		this.isTransparency = isTransparency;
		this.productInfo = productInfo;
		this.quantityShipped = quantityShipped;
		this.conditionSubtypeId = conditionSubtypeId;
		this.itemPrice = itemPrice;
		this.itemTax = itemTax;
		this.promotionDiscountTax = promotionDiscountTax;
		
		
	}

	public String getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(String quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PromotionDiscount getPromotionDiscount() {
		return promotionDiscount;
	}

	public void setPromotionDiscount(PromotionDiscount promotionDiscount) {
		this.promotionDiscount = promotionDiscount;
	}

	public String getConditionId() {
		return conditionId;
	}

	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
	}

	public String getIsGift() {
		return isGift;
	}

	public void setIsGift(String isGift) {
		this.isGift = isGift;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public String getSellerSKU() {
		return sellerSKU;
	}

	public void setSellerSKU(String sellerSKU) {
		this.sellerSKU = sellerSKU;
	}

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getIsTransparency() {
		return isTransparency;
	}

	public void setIsTransparency(String isTransparency) {
		this.isTransparency = isTransparency;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public String getQuantityShipped() {
		return quantityShipped;
	}

	public void setQuantityShipped(String quantityShipped) {
		this.quantityShipped = quantityShipped;
	}

	public String getConditionSubtypeId() {
		return conditionSubtypeId;
	}

	public void setConditionSubtypeId(String conditionSubtypeId) {
		this.conditionSubtypeId = conditionSubtypeId;
	}

	public ItemPrice getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(ItemPrice itemPrice) {
		this.itemPrice = itemPrice;
	}

	public ItemTax getItemTax() {
		return itemTax;
	}

	public void setItemTax(ItemTax itemTax) {
		this.itemTax = itemTax;
	}

	public PromotionDiscountTax getPromotionDiscountTax() {
		return promotionDiscountTax;
	}

	public void setPromotionDiscountTax(PromotionDiscountTax promotionDiscountTax) {
		this.promotionDiscountTax = promotionDiscountTax;
	}

	public ShippingPrice getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(ShippingPrice shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public GiftWrapPrice getGiftWrapPrice() {
		return giftWrapPrice;
	}

	public void setGiftWrapPrice(GiftWrapPrice giftWrapPrice) {
		this.giftWrapPrice = giftWrapPrice;
	}

	public ShippingTax getShippingTax() {
		return shippingTax;
	}

	public void setShippingTax(ShippingTax shippingTax) {
		this.shippingTax = shippingTax;
	}

	public GiftWrapTax getGiftWrapTax() {
		return giftWrapTax;
	}

	public void setGiftWrapTax(GiftWrapTax giftWrapTax) {
		this.giftWrapTax = giftWrapTax;
	}

	public ShippingDiscount getShippingDiscount() {
		return shippingDiscount;
	}

	public void setShippingDiscount(ShippingDiscount shippingDiscount) {
		this.shippingDiscount = shippingDiscount;
	}

	public ShippingDiscountTax getShippingDiscountTax() {
		return shippingDiscountTax;
	}

	public void setShippingDiscountTax(ShippingDiscountTax shippingDiscountTax) {
		this.shippingDiscountTax = shippingDiscountTax;
	}

	public CODFee getCodFee() {
		return codFee;
	}

	public void setCodFee(CODFee codFee) {
		this.codFee = codFee;
	}

	public CODFeeDiscount getCodFeeDiscount() {
		return codFeeDiscount;
	}

	public void setCodFeeDiscount(CODFeeDiscount codFeeDiscount) {
		this.codFeeDiscount = codFeeDiscount;
	}
}
