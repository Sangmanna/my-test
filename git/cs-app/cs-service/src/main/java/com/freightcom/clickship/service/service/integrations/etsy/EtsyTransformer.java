package com.freightcom.clickship.service.service.integrations.etsy;


import static com.freightcom.clickship.model.util.ClickshipStringUtil.removeSpecialCharsAndAreaCode;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.Discount;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.entity.MarketplaceSetting;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Orderline;
import com.freightcom.clickship.data.entity.OrderlineDiscount;
import com.freightcom.clickship.data.entity.Tax;
import com.freightcom.clickship.data.entity.common.ClickShipOrderStatus;
import com.freightcom.clickship.data.rep.MarketplaceSettingRepository;
import com.freightcom.clickship.data.rep.TaxRepository;
import com.freightcom.clickship.model.constants.ClickShipConstants;
import com.freightcom.clickship.model.enums.AddressType;
import com.freightcom.clickship.model.marketplace.etsy.EtsyCountryCodes;
import com.freightcom.clickship.model.marketplace.etsy.EtsyOrder;
import com.freightcom.clickship.model.marketplace.etsy.Listing;
import com.freightcom.clickship.model.marketplace.etsy.ListingImage;
import com.freightcom.clickship.model.marketplace.etsy.ListingOffering;
import com.freightcom.clickship.model.marketplace.etsy.ListingProduct;
import com.freightcom.clickship.model.marketplace.etsy.PropertyValue;
import com.freightcom.clickship.model.marketplace.etsy.Receipt;
import com.freightcom.clickship.model.marketplace.etsy.ReceiptShipment;
import com.freightcom.clickship.model.marketplace.etsy.UserAddress;
import com.freightcom.clickship.model.util.ClickshipStringUtil;
import com.freightcom.clickship.model.util.NumberUtility;

@Component
public class EtsyTransformer {

	@Autowired
	private TaxRepository taxRepository;

	@Autowired	
	private MarketplaceSettingRepository marketplaceSettingRepository;

	public CustomerAddress createBaseAddress(Customer customer) {
		return new CustomerAddress().setCustomer(customer).setBusinessName(customer.getBusinessName());
	}

	public void setAddressInfo(CustomerAddress address, UserAddress userAddress) {
		Map<Long, EtsyCountryCodes> etsyCountries = EtsyCountryCodes.getEtsyCountries();

		address.setAddressType(AddressType.SHP.toString()).setExternalId(NumberUtility.getSafeCheckLongValue(userAddress.getId()))
				.setAddressName(userAddress.getName()).setAddress1(userAddress.getFirstLine()).setAddress2(userAddress.getSecondLine())
				.setCity(userAddress.getCity()).setProvinceState(userAddress.getState()).setPostalCode(userAddress.getZip())
				.setCountry(etsyCountries.get(userAddress.getCountryId()).getCountryCode());
	}

	public MarketplaceProduct createBaseProduct(Marketplace marketplace) {
		return new MarketplaceProduct().setMarketplace(marketplace).setCustomer(marketplace.getCustomer());
	}

	public void setProductGeneralInfo(MarketplaceProduct product, Listing etsyProduct, ListingProduct listingProduct) {
    	product.setExternalProductId(etsyProduct.getListing_id()).setPrice(NumberUtility.getSafeCheckDoubleValue(etsyProduct.getPrice()));
    	
        if (CollectionUtils.isNotEmpty(etsyProduct.getSkus())) {
            product.setSku(etsyProduct.getSkus().get(0));
        }
    	
        StringBuilder variantTitle = new StringBuilder();
    	if (listingProduct != null) {
    		product.setVariantId("" + listingProduct.getProductId()).setSku(listingProduct.getSku());
    		
    		if(CollectionUtils.isNotEmpty(listingProduct.getPropertyValues())) {
    			for(PropertyValue property : listingProduct.getPropertyValues()) {
    				if(ArrayUtils.isNotEmpty(property.getValues())) {
    					variantTitle.append(" - ").append(property.getValues()[0]);
    					
    					if(StringUtils.isNotBlank(property.getScaleName())) {
    						variantTitle.append(" ").append(property.getScaleName());
    					}
    				}
    			}
    		}	
    		
    		if(CollectionUtils.isNotEmpty(listingProduct.getOfferings())) {
    			ListingOffering offering = listingProduct.getOfferings().get(0);
    			product.setPrice(offering.getMoney() != null ? NumberUtility.getSafeCheckDoubleValue(offering.getMoney().getFormattedRaw()) : 0.0);
    		}
    	}
    	
    	product.setTitle(getProductTitle(etsyProduct.getTitle(), variantTitle.toString()));
    }

    public void setProductImage(MarketplaceProduct marketplaceProduct, ListingImage productImage) {
        if (productImage != null) {
            marketplaceProduct.setImageUrl(productImage.getUrl75x75());
        }
    }

    public void setProductWeight(MarketplaceProduct marketplaceProduct, Listing etsyProduct) {
        String weightUnit = etsyProduct.getItem_weight_unit();
        double weight = NumberUtility.getSafeCheckDoubleValue(etsyProduct.getItem_weight());

        if ("kg".equalsIgnoreCase(weightUnit)) {
            marketplaceProduct.setWeightMetric(weight);
            marketplaceProduct.setWeight(weight * ClickShipConstants.KG_TO_POUND);

        } else if ("lb".equalsIgnoreCase(weightUnit)) {
            marketplaceProduct.setWeightMetric(weight / ClickShipConstants.KG_TO_POUND);
            marketplaceProduct.setWeight(weight);

        } else if ("g".equalsIgnoreCase(weightUnit)) {
            marketplaceProduct.setWeightMetric(weight / 1000);
            marketplaceProduct.setWeight(weight / 1000 * ClickShipConstants.KG_TO_POUND);

        } else if ("oz".equalsIgnoreCase(weightUnit)) {
            marketplaceProduct.setWeightMetric(weight * 0.0283495);
            marketplaceProduct.setWeight(weight * 0.0625);
        }
    }

    public void setProductMeasurements(MarketplaceProduct marketplaceProduct, Listing etsyProduct) {
        String measurementUnit = etsyProduct.getItem_dimensions_unit();

        double height = NumberUtility.getSafeCheckDoubleValue(etsyProduct.getItem_height());
        double length = NumberUtility.getSafeCheckDoubleValue(etsyProduct.getItem_length());
        double width = NumberUtility.getSafeCheckDoubleValue(etsyProduct.getItem_width());

        if ("mm".equalsIgnoreCase(measurementUnit)) {
            marketplaceProduct.setHeightMetric(height / 10);
            marketplaceProduct.setHeight(height / (ClickShipConstants.INCH_TO_CM * 10));

            marketplaceProduct.setLengthMetric(length / 10);
            marketplaceProduct.setLength(length / (ClickShipConstants.INCH_TO_CM * 10));

            marketplaceProduct.setWidthMetric(width / 10);
            marketplaceProduct.setWidth(width / (ClickShipConstants.INCH_TO_CM * 10));

        } else if ("cm".equalsIgnoreCase(measurementUnit)) {
            marketplaceProduct.setHeightMetric(height);
            marketplaceProduct.setHeight(height / (ClickShipConstants.INCH_TO_CM));

            marketplaceProduct.setLengthMetric(length);
            marketplaceProduct.setLength(length / (ClickShipConstants.INCH_TO_CM));

            marketplaceProduct.setWidthMetric(width);
            marketplaceProduct.setWidth(width / (ClickShipConstants.INCH_TO_CM));

        } else if ("m".equalsIgnoreCase(measurementUnit)) {
            marketplaceProduct.setHeightMetric(height * 10);
            marketplaceProduct.setHeight(height / (ClickShipConstants.INCH_TO_CM / 10));

            marketplaceProduct.setLengthMetric(length * 10);
            marketplaceProduct.setLength(length / (ClickShipConstants.INCH_TO_CM / 10));

            marketplaceProduct.setWidthMetric(width * 10);
            marketplaceProduct.setWidth(width / (ClickShipConstants.INCH_TO_CM / 10));

        } else if ("in".equalsIgnoreCase(measurementUnit)) {
            marketplaceProduct.setHeightMetric(height * ClickShipConstants.INCH_TO_CM);
            marketplaceProduct.setHeight(height);

            marketplaceProduct.setLengthMetric(length * ClickShipConstants.INCH_TO_CM);
            marketplaceProduct.setLength(length);

            marketplaceProduct.setWidthMetric(width * ClickShipConstants.INCH_TO_CM);
            marketplaceProduct.setWidth(width);
        } else if ("ft".equalsIgnoreCase(measurementUnit)) {
            marketplaceProduct.setHeightMetric(height * ClickShipConstants.FEET_TO_CM);
            marketplaceProduct.setHeight(height * ClickShipConstants.FEET_TO_INCH);

            marketplaceProduct.setLengthMetric(length * ClickShipConstants.FEET_TO_CM);
            marketplaceProduct.setLength(length * ClickShipConstants.FEET_TO_INCH);

            marketplaceProduct.setWidthMetric(width * ClickShipConstants.FEET_TO_CM);
            marketplaceProduct.setWidth(width * ClickShipConstants.FEET_TO_INCH);
        }
    }
    
    public Order createBaseOrder(Marketplace marketplace) {
        Order order = new Order();

        order.setMarketplace(marketplace)
                .setCustomer(marketplace.getCustomer())
                .setShipfromEmail(marketplace.getCustomer().getEmail())
                .setShipfromContact(marketplace.getCustomer().getContactName())
                .setShipfromCompany(marketplace.getCustomer().getBusinessName())
                .setShipfromPhone(removeSpecialCharsAndAreaCode(marketplace.getCustomer().getPhone()));

        return order;
    }

	public Order getCsOrder(Order order, EtsyOrder etsyOrder) {
		setOrderGerneralInfo(order, etsyOrder);
		setOrderCostInfo(order, etsyOrder);
		setOrderStatusInfo(order, etsyOrder);
		setOrderShiptoInfo(order, etsyOrder);
		setOrderBilltoInfo(order, etsyOrder);
		setOrderShippingInfo(order, etsyOrder);

		return order;
	}
	
	@Transactional
	public void setDiscountsFromEtsyOrder(EtsyOrder etsyOrder, Order order) {
		if (etsyOrder.getDiscountAmt() != null && etsyOrder.getDiscountAmt() > 0) {
			Discount discount = null;
			List<Discount> discounts = order.getDiscounts();
		
			if(CollectionUtils.isNotEmpty(discounts)) {
				discount = discounts.get(0);
			} 
		
			if(discount == null) {
				discount = new Discount();

				discount.setOrder(order);
				order.addDiscount(discount);
			}

			discount.setValue(etsyOrder.getDiscountAmt().doubleValue());
		}
	}
	
    @Transactional
    public void setTaxesFromEtsyOrder(EtsyOrder etsyOrder, Order order) {
        if (etsyOrder.getTotalVatCost() != null && etsyOrder.getTotalVatCost().doubleValue() > 0) {
            Tax tax = taxRepository.findByTitleAndOrder("VAT", order);
            
            if (tax == null) {
                tax = new Tax(order);
                order.addTax(tax);
            }
            
            tax.setTitle("VAT").setPrice(etsyOrder.getTotalVatCost().doubleValue()).setRate(0d);
        }

        if (etsyOrder.getTotalTaxCost() != null && etsyOrder.getTotalTaxCost().doubleValue() > 0) {
            Tax tax = taxRepository.findByTitleAndOrder("SALES TAX", order);
            
            if (tax == null) {
                tax = new Tax(order);
                order.addTax(tax);
            }
            
            tax.setTitle("SALES TAX").setPrice(etsyOrder.getTotalTaxCost().doubleValue()).setRate(0d);
        }
    }

/*	public Map<String, Object> getStoreDetailsForEmail(Marketplace marketplace) {
        Map<String, Object> content = new HashMap<String, Object>();

        content.put("marketplaceId", marketplace.getId());
        content.put("marketplaceUrl", marketplace.getStoreUrl());
        content.put("marketplaceName", marketplace.getAliasName());
        content.put("customerId", marketplace.getCustomer().getId());
        content.put("marketplaceType", marketplace.getMarketplaceType().getName());

        return content;
    }*/

    private void setOrderGerneralInfo(Order order, EtsyOrder etsyOrder) {
        order.setExternalOrderId("" + etsyOrder.getOrderId()).setOrderNumber("" + etsyOrder.getReceiptId())
        	.setOrderDate(new Date(etsyOrder.getCreationTsz().longValue() * 1000));
    }
    
	private void setOrderCostInfo(Order order, EtsyOrder etsyOrder) {
		if (etsyOrder.getTotalTaxCost() != null) {
			order.setTaxes(etsyOrder.getTotalTaxCost().doubleValue());
		}

		if (etsyOrder.getTotalPrice() != null) {
			order.setSubtotal(etsyOrder.getTotalPrice().doubleValue());
		}

		if (etsyOrder.getGrandtotal() != null) {
			order.setCostCurrency(etsyOrder.getCurrencyCode());
			order.setTotal(etsyOrder.getGrandtotal().doubleValue());
			order.setOriginalTotal(etsyOrder.getGrandtotal().doubleValue());
		}

		if (etsyOrder.getDiscountAmt() != null) {
			order.setTotalDiscounts(etsyOrder.getDiscountAmt().doubleValue());
		}
	}
	
	private void setOrderStatusInfo(Order order, EtsyOrder etsyOrder) {
		String prevOrderStatus = order.getStatus();
		if (prevOrderStatus != null && prevOrderStatus.equalsIgnoreCase(ClickShipOrderStatus.Fulfilled.getValue())) {
			return;
		}

		if (etsyOrder.getWasShipped()) {
			order.setStatus(ClickShipOrderStatus.ExternallyFulfilled);
			order.setExternallyFulfilledDate(new Date());
		} else if (etsyOrder.getWasPaid()) {
			order.setStatus(ClickShipOrderStatus.UnFulfilled);
		} else {
			order.setStatus(ClickShipOrderStatus.Pending);
		}
	}
	
	private void setOrderShiptoInfo(Order order, Receipt receipt) {
		Marketplace marketplace = order.getMarketplace();
		Map<Long, EtsyCountryCodes> etsyCountries = EtsyCountryCodes.getEtsyCountries();
		MarketplaceSetting marketplaceSetting = marketplaceSettingRepository.findByMarketplace(marketplace);

		order.setShiptoAddress1(receipt.getFirstLine()).setShiptoAddress2(receipt.getSecondLine())
				.setShiptoCompany(receipt.getName().trim()).setShiptoCity(receipt.getCity())
				.setShiptoContact(receipt.getName().trim()).setShiptoEmail(receipt.getBuyerEmail())
				.setShiptoProvinceState(receipt.getState()).setShiptoZip(receipt.getZip())
				.setShiptoCountry(etsyCountries.get(receipt.getCountryId()).getCountryCode())
				.setShiptoPhone(ClickshipStringUtil.getTenDigitPhoneNumber(marketplaceSetting.getDefaultPhone()));

		if (StringUtils.isEmpty(order.getShiptoCompany())) {
			order.setShiptoCompany(order.getShiptoContact());
		}

		if (StringUtils.isEmpty(order.getShiptoContact())) {
			order.setShiptoContact(order.getShiptoCompany());
		}
	}
	
    private void setOrderBilltoInfo(Order order, Receipt receipt) {
        order.setBilltoAddress1(receipt.getFirstLine()).setBilltoAddress2(receipt.getSecondLine())
           .setBilltoContact(receipt.getName()).setBilltoCity(receipt.getCity()).setBilltoPostalcode(receipt.getZip())
           .setBilltoEmail(receipt.getBuyerEmail()).setBilltoProvinceState(receipt.getState());
    }
    
    private void setOrderShippingInfo(Order order, EtsyOrder receipt) {
        List<ReceiptShipment> shipping = receipt.getShipments();

        order.setOriginalShippingCost(Double.valueOf(receipt.getTotalShippingCost()))
                .setShippingCost(Double.valueOf(receipt.getTotalShippingCost()))
                .setOriginalShippingCurrency(receipt.getCurrencyCode())
                .setShippingCurrency(receipt.getCurrencyCode());

        if (receipt.getWasShipped()) {
            long createdTime = receipt.getShippedDate().longValue();
            Date createdDate = new Date(createdTime * 1000);
            order.setShipDate(createdDate);

            if (shipping != null && shipping.size() > 0) {
                Optional<ReceiptShipment> receiptShipmentOptional = shipping.stream()
                        .filter(receiptShipment1 -> receiptShipment1.getReceiptShippingId() != null)
                        .findFirst();
                if (receiptShipmentOptional.isPresent()) {
                    order.setServiceType(receiptShipmentOptional.get().getCarrierName());
                    order.setExternalFulfillmentId(receiptShipmentOptional.get().getReceiptShippingId().toString());
                }
            }
        }
    }

    public void setDiscountToOrderLine(Orderline orderline, List<Discount> discountList) {
        if (CollectionUtils.isNotEmpty(discountList)) {
            for (Discount d : discountList) {
                OrderlineDiscount od = orderline.getOrderlineDiscount();

                if (od == null) {
                    od = new OrderlineDiscount(orderline, d);
                    orderline.setOrderlineDiscount(od);
                }
                od.setAmount(orderline.getDiscount() * orderline.getUnitPrice() * orderline.getQuantity());
            }
        }
    }
    
    private String getProductTitle(String productTitle, String variantTitle) {
    	String product = escapeSpecialCharcters(productTitle);
    	String variant = escapeSpecialCharcters(variantTitle.toString());
    	
    	if(product.length() + variant.length() > 255) {
    		return product.substring(0, (product.length() - variant.length() + 10)) + "..." + variantTitle;
    	} else {
    		return product + variant;
    	}   	
    }
    
    private String escapeSpecialCharcters(String original) {
    	String escapeEcmaScript = StringEscapeUtils.escapeEcmaScript(original);
    	return StringEscapeUtils.escapeHtml4(escapeEcmaScript);
    }

}