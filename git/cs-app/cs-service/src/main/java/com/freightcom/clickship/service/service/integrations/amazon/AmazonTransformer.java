package com.freightcom.clickship.service.service.integrations.amazon;

import static com.freightcom.clickship.model.util.ClickshipStringUtil.removeSpecialCharsAndAreaCode;
import static com.freightcom.clickship.model.util.Convert.getImperialDimesionByUOM;
import static com.freightcom.clickship.model.util.Convert.getImperialWeigthByUOM;
import static com.freightcom.clickship.model.util.Convert.getMetricDimesionByUOM;
import static com.freightcom.clickship.model.util.Convert.getMetricWeigthByUOM;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Code;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.Discount;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Orderline;
import com.freightcom.clickship.data.entity.OrderlineDiscount;
import com.freightcom.clickship.data.entity.Tax;
import com.freightcom.clickship.data.entity.common.ClickShipOrderStatus;
import com.freightcom.clickship.data.rep.OrderlineRepository;
import com.freightcom.clickship.data.rep.TaxRepository;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.marketplace.amazon.AmazonOrder;
import com.freightcom.clickship.model.marketplace.amazon.AmazonOrderStatuses;
import com.freightcom.clickship.model.marketplace.amazon.MatchingProductResponse;
import com.freightcom.clickship.model.marketplace.amazon.ReportListOrdersDTO;
import com.freightcom.clickship.model.marketplace.amazon.orderitems.OrderItem;
import com.freightcom.clickship.model.marketplace.amazon.orders.OrderTotal;
import com.freightcom.clickship.model.marketplace.amazon.orders.ShippingAddress;
import com.freightcom.clickship.model.marketplace.amazon.products.AttributeSets;
import com.freightcom.clickship.model.marketplace.amazon.products.Identifiers;
import com.freightcom.clickship.model.marketplace.amazon.products.ItemAttributes;
import com.freightcom.clickship.model.marketplace.amazon.products.ItemDimensions;
import com.freightcom.clickship.model.marketplace.amazon.products.PackageDimensions;
import com.freightcom.clickship.model.marketplace.amazon.products.Product;
import com.freightcom.clickship.model.util.ClickshipStringUtil;
import com.freightcom.clickship.model.util.NumberUtility;
import com.freightcom.clickship.service.service.CodeService;

@Component
public class AmazonTransformer {

	private static Logger logger = LogManager.getLogger(AmazonTransformer.class);

	@Autowired
	private CodeService codeService;
	
	@Autowired
	private TaxRepository taxRepository;
	
	@Autowired
	private OrderlineRepository orderlineRepository;

	public MarketplaceProduct createBaseProduct(Marketplace marketplace) {
		return new MarketplaceProduct().setMarketplace(marketplace).setCustomer(marketplace.getCustomer());
	}
	
	public void setProductDimensions(MarketplaceProduct csProduct, MatchingProductResponse productResponse) {
		double length = 0.0, width = 0.0, height = 0.0, weight = 0.0;
		String lengthUnits = ClickShipConstants.INCHES;
		String weightUnits = ClickShipConstants.POUNDS;

		if(productResponse.getMatchingProductResult() != null 
				&& productResponse.getMatchingProductResult().getProduct() != null) {
			Product product = productResponse.getMatchingProductResult().getProduct();
			
			if(product.getAttributeSets() != null && product.getAttributeSets().getItemAttributes() != null) {
				ItemAttributes attributes = product.getAttributeSets().getItemAttributes();		

				// DIMENTSIONS
				if (attributes.getItemDimensions() != null) {
					ItemDimensions dimensions = attributes.getItemDimensions();
					
					if (dimensions.getLength() != null) {
						length = NumberUtility.getSafeCheckDoubleValue(dimensions.getLength().getValue());
						lengthUnits = dimensions.getLength().getUnits();
					}
			
					if (dimensions.getWidth() != null) {
						width = NumberUtility.getSafeCheckDoubleValue(dimensions.getWidth().getValue());
			
					}
			
					if (dimensions.getHeight() != null) {
						height = NumberUtility.getSafeCheckDoubleValue(dimensions.getHeight().getValue());
					}
				}
				
				//WEIGHTS
				if(attributes.getPackageDimensions() != null) {
					PackageDimensions packageDimensions = attributes.getPackageDimensions();
					
					if(packageDimensions.getWeight() != null) {
						weightUnits = packageDimensions.getWeight().getUnits();
						weight = NumberUtility.getSafeCheckDoubleValue(packageDimensions.getWeight().getValue());
					}
				}
			}
		}
		
		csProduct.setLength(getImperialDimesionByUOM(length, lengthUnits), getMetricDimesionByUOM(length, lengthUnits));
		csProduct.setWidth(getImperialDimesionByUOM(width, lengthUnits), getMetricDimesionByUOM(width, lengthUnits));
		csProduct.setHeight(getImperialDimesionByUOM(height, lengthUnits), getMetricDimesionByUOM(height, lengthUnits));
		csProduct.setWeight(getImperialWeigthByUOM(weight, weightUnits), getMetricWeigthByUOM(weight, weightUnits));
	}

	public void setProductImage(MarketplaceProduct csProduct, MatchingProductResponse response) {
		if(response.getMatchingProductResult() != null 
				&& response.getMatchingProductResult().getProduct() != null) {
			Product product = response.getMatchingProductResult().getProduct();
			
			if(product.getAttributeSets() != null && product.getAttributeSets().getItemAttributes() != null) {
				ItemAttributes attributes = product.getAttributeSets().getItemAttributes();
				csProduct.setImageUrl(attributes.getSmallImage().getUrl());
			}
		}
	}

	public void setProductGeneralInfo(MarketplaceProduct product, OrderItem orderItem, MatchingProductResponse response) {
		if(response.getMatchingProductResult() != null && response.getMatchingProductResult().getProduct() != null) {
			Identifiers identifiers = response.getMatchingProductResult().getProduct().getIdentifiers();
			product.setUpc(identifiers.getMarketplaceASIN() != null ? identifiers.getMarketplaceASIN().getAsin() : "");
			
			AttributeSets attributeSets = response.getMatchingProductResult().getProduct().getAttributeSets();
			product.setTitle(attributeSets.getItemAttributes() != null ? ClickshipStringUtil.truncateString(attributeSets.getItemAttributes().getTitle(), 255) : "");
		}

		// SKU in Amazon is stored in Orderline response
		product.setSku(orderItem != null ? orderItem.getSellerSKU() : "");
		product.setPrice(orderItem != null ? getOrderItemUnitPrice(orderItem) : 0.0);
	}
	
	public Order createBaseOrder(Marketplace marketplace, AmazonOrder amazonOrder) {
		Order order = new Order();
		CustomerAddress defaultAddress = marketplace.getDefaultAddress();
		
		order.setMarketplace(marketplace).setCustomer(marketplace.getCustomer())
				.setShipfromContact(defaultAddress.getContactName())
				.setShipfromCompany(defaultAddress.getBusinessName())
				.setShipfromEmail(defaultAddress.getCustomer().getEmail())
				.setShipfromPhone(removeSpecialCharsAndAreaCode(defaultAddress.getPhone()));
		
		setOrderGeneralInfo(order, amazonOrder);

		return order;
	}

	public Order setOrderInfo(Order order, AmazonOrder amazonOrder, ReportListOrdersDTO dto) {
		setOrderCostInfo(order, amazonOrder);
		setOrderStatusInfo(order, amazonOrder);
		setOrderShiptoInfo(order, amazonOrder, dto);

		return order;
	}
	
	public void setOrderline(Marketplace marketplace, Order order,	OrderItem orderItem, MarketplaceProduct csProduct, int lineNumber) {
		Orderline orderLine = orderlineRepository.findByExternalLineIdAndOrder(orderItem.getOrderItemId(), order);

		if (orderLine == null) {
			orderLine = new Orderline().setOrder(order).setExternalLineId(orderItem.getOrderItemId())
					.setLineNumber(lineNumber++).setMarketplaceProduct(csProduct);
			
			order.addOrderline(orderLine);
		}

		orderLine.setTitle(orderItem.getTitle()).setQuantity(Integer.parseInt(orderItem.getQuantityOrdered()))
				 .setUnitPrice(getOrderItemUnitPrice(orderItem)).setLineSubtotal(getOrderItemPrice(orderItem))
				.setSku(orderItem.getSellerSKU());
		
		setOrderlineDiscounts(order, orderLine, orderItem);
	}
	
	@Transactional
	public void setTaxes(Marketplace marketplace, Order order, OrderItem orderItem) {
		
		if (orderItem.getItemTax() != null) {
			setTax(order, orderItem.getItemTax().getClass().getSimpleName(), orderItem.getItemTax().getAmount());
		} 
		
		if (orderItem.getPromotionDiscountTax() != null) {
			setTax(order, orderItem.getPromotionDiscountTax().getClass().getSimpleName(), orderItem.getPromotionDiscountTax().getAmount());
		}
		
		if (orderItem.getGiftWrapTax() != null) {
			setTax(order, orderItem.getGiftWrapTax().getClass().getSimpleName(), orderItem.getGiftWrapTax().getAmount());
		}
		
		if (orderItem.getShippingDiscountTax() != null) {
			setTax(order, orderItem.getShippingDiscountTax().getClass().getSimpleName(), orderItem.getShippingDiscountTax().getAmount());
		}
		
		if (orderItem.getShippingTax() != null) {
			setTax(order, orderItem.getShippingTax().getClass().getSimpleName(), orderItem.getShippingTax().getAmount());
		}
		
		if (orderItem.getCodFee() != null) {
			setTax(order, orderItem.getCodFee().getClass().getSimpleName(), orderItem.getCodFee().getAmount());
		} 
		
		if (orderItem.getGiftWrapPrice() != null) {
			setTax(order, orderItem.getGiftWrapPrice().getClass().getSimpleName(), orderItem.getGiftWrapPrice().getAmount());
		}
	}

	private void setOrderGeneralInfo(Order order, AmazonOrder amazonOrder) {
		order.setOrderNumber("" + amazonOrder.getAmazonOrderId()).setOrderDate(getDate(amazonOrder.getAmazonOrderId(), amazonOrder.getPurchaseDate()));
	}

	private void setOrderCostInfo(Order order, AmazonOrder amazonOrder) {
		OrderTotal orderTotal = amazonOrder.getOrderTotal();

		order.setOriginalShippingCost(0.0)
			.setOriginalTotal(orderTotal != null ? NumberUtility.getSafeCheckDoubleValue(orderTotal.getAmount()) : 0.0)
			.setTotal(orderTotal != null ? NumberUtility.getSafeCheckDoubleValue(orderTotal.getAmount()) : 0.0)
			.setCostCurrency(orderTotal != null ? orderTotal.getCurrencyCode() : order.getMarketplace().getCurrency());
	}

	private void setOrderStatusInfo(Order order, AmazonOrder amazonOrder) {
		String amazonOrderStatus = amazonOrder.getOrderStatus();

		if (StringUtils.equalsAnyIgnoreCase(amazonOrderStatus, AmazonOrderStatuses.UNSHIPPED.getValue())) {
			order.setStatus(ClickShipOrderStatus.UnFulfilled);
		} else if (StringUtils.equalsAnyIgnoreCase(amazonOrderStatus, 
				AmazonOrderStatuses.SHIPPED.getValue(), AmazonOrderStatuses.PARTIALLY_SHIPPED.getValue())) {
			order.setStatus(ClickShipOrderStatus.ExternallyFulfilled);
		} else if (StringUtils.equalsAnyIgnoreCase(amazonOrderStatus, AmazonOrderStatuses.CANCELED.getValue())) {
			order.setStatus(ClickShipOrderStatus.Cancelled);
		} else {
			order.setStatus(ClickShipOrderStatus.Pending);
		}
	}

	private void setOrderShiptoInfo(Order order, AmazonOrder amazonOrder, ReportListOrdersDTO dto) {
		ShippingAddress shippingAddress = amazonOrder.getShippingAddress();

		if (shippingAddress != null) {
			if(shippingAddress.getStateOrRegion() != null) {
				Code code = codeService.getSingleCodeByGroupNameAndNameOrValue(
						"PROVINCE", shippingAddress.getStateOrRegion(), shippingAddress.getStateOrRegion());
					
				if (code != null) {
					order.setShiptoProvinceState(code.getValue()).setBilltoProvinceState(code.getValue());
				}				
			}
				
			if(dto != null) {
				order.setShiptoCompany(dto.getBuyerName()).setShiptoContact(dto.getRecipientName())
				.setShiptoPhone(ClickshipStringUtil.getTenDigitPhoneNumber(dto.getBuyerPhoneNumber()))
				.setShiptoAddress1(dto.getShipAddress1() + " "	+ dto.getShipAddress2() + " " + dto.getShipAddress3())
				.setBilltoAddress1(dto.getShipAddress1() + " "	+ dto.getShipAddress2() + " " + dto.getShipAddress3());
			}

			String postalCode = ClickshipStringUtil.removeSplCharsFromPostalCode(shippingAddress.getPostalCode());
			
			order.setShiptoEmail(amazonOrder.getBuyerEmail()).setShiptoZip(postalCode).setBilltoPostalcode(postalCode)
				.setShiptoCity(shippingAddress.getCity()).setBilltoCity(shippingAddress.getCity())
				.setShiptoCountry(shippingAddress.getCountryCode()).setBilltoCountry(shippingAddress.getCountryCode());
		}
	}

	private void setOrderlineDiscounts(Order order, Orderline orderline, OrderItem orderItem) {
		double value = 0.0;
		
		if (orderItem.getPromotionDiscount() != null) {			
			value += NumberUtility.getSafeCheckDoubleValue(orderItem.getPromotionDiscount().getAmount());
		}
		
		if (orderItem.getShippingDiscount() != null) {
			value += NumberUtility.getSafeCheckDoubleValue(orderItem.getShippingDiscount().getAmount());
		} 
		
		if (orderItem.getCodFeeDiscount() != null) {
			value += NumberUtility.getSafeCheckDoubleValue(orderItem.getCodFeeDiscount().getAmount());
		}
		
		if(value > 0.0) {
			Discount discount = getDiscountByOrder(order);
			
			//OrderLines Discount
			OrderlineDiscount orderlineDiscount = orderline.getOrderlineDiscount();
			
			if(orderlineDiscount == null) {
				orderlineDiscount= new OrderlineDiscount();
				orderline.setOrderlineDiscount(orderlineDiscount);
			}
			
			orderline.setDiscount(value);
			
			orderlineDiscount.setAmount(value);
			orderlineDiscount.setDiscount(discount);
			orderlineDiscount.setOrderline(orderline);		
			
			double totalDiscount = discount.getValue() + value;
			discount.setValue(totalDiscount);
		}
	}
	
	@Transactional
	private Discount getDiscountByOrder(Order order) {
		// Order level discount should be always one.
		if(CollectionUtils.isEmpty(order.getDiscounts())) {
			Discount discount = new Discount();
			discount.setValue(0.0);
			discount.setOrder(order);
			discount.setAllocationMethod("each");
			discount.setValueType("fixed_amount");
		
			order.addDiscount(discount);
		}
		
		return order.getDiscounts().get(0);
	}

	@Transactional
	private void setTax(Order order, String title, String amount) {
		double taxValue = NumberUtility.getSafeCheckDoubleValue(amount);
		
		if(taxValue > 0.0) {
			Tax tax = taxRepository.findByTitleAndOrder(title, order);
			
			if(tax == null) {
				tax = new Tax(order);
				tax.setTitle(title);
				tax.setRate(0.0);
				
				order.addTax(tax);
			}

			tax.setPrice(taxValue);			
		}
	}

	/**
	 * From amazon we always get UTC time zone.
	 * So we no need convert again. Same value we can store on DB.
	 * 
	 */
	private Date getDate(String orderNumber, String amazonDate) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
			
	        Date date = formatter.parse(amazonDate);
	        logger.info("Order#{} Amazon date:{}, Converted date:{}", orderNumber, amazonDate, date);
	        
			return date;
		} catch (ParseException e) {			
			logger.error("Error in final date transformation:"+e.getLocalizedMessage());
		}
		return null;
	}
	
	private double getOrderItemPrice(OrderItem orderItem) {
		return orderItem != null && orderItem.getItemPrice() != null ? NumberUtility.getSafeCheckDoubleValue(orderItem.getItemPrice().getAmount()) : 0.0;
	}
	
	private double getOrderItemUnitPrice(OrderItem orderItem) {
		if (orderItem.getItemPrice() != null &&  orderItem.getQuantityOrdered() != null) {
			double quantity = NumberUtility.getSafeCheckDoubleValue(orderItem.getQuantityOrdered());
			
			if(quantity == 0) {
				return 0.0;
			}
			
			return NumberUtility.getSafeCheckDoubleValue(orderItem.getItemPrice().getAmount()) / quantity;
		}
		
		return 0.0;
	}
	
}
