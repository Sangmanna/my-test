package com.freightcom.clickship.service.service.integrations.reverb;

import static com.freightcom.clickship.model.util.ClickshipStringUtil.removeSpecialCharsAndAreaCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.freightcom.clickship.client.reverb.ReverbClient;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerAddress;
import com.freightcom.clickship.data.entity.Discount;
import com.freightcom.clickship.data.entity.Marketplace;
import com.freightcom.clickship.data.entity.MarketplaceProduct;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Orderline;
import com.freightcom.clickship.data.entity.OrderlineDiscount;
import com.freightcom.clickship.data.entity.common.ClickShipOrderStatus;
import com.freightcom.clickship.data.rep.MarketplaceProductRepository;
import com.freightcom.clickship.data.rep.OrderRepository;
import com.freightcom.clickship.data.rep.OrderlineRepository;
import com.freightcom.clickship.model.marketplace.reverb.ReverbListing;
import com.freightcom.clickship.model.marketplace.reverb.ReverbOrder;
import com.freightcom.clickship.model.marketplace.reverb.ReverbOrderNotes;
import com.freightcom.clickship.model.marketplace.reverb.ReverbProduct;
import com.freightcom.clickship.model.util.ClickshipStringUtil;
import com.freightcom.clickship.model.util.NumberUtility;

@Component
public class ReverbTransformer {

	@Autowired
	private OrderlineRepository orderlineRepository;
	
	@Autowired
	private ReverbClient reverbClient;
	
	@Autowired
	private MarketplaceProductRepository marketplaceProductRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	public CustomerAddress createBaseAddress(Customer customer) {
		return new CustomerAddress().setCustomer(customer).setBusinessName(customer.getBusinessName());
	}

	public MarketplaceProduct createBaseProduct(Marketplace marketplace, ReverbOrder reverbOrder) {
		return new MarketplaceProduct().setMarketplace(marketplace).setCustomer(marketplace.getCustomer()).setQuantity(Integer.parseInt(reverbOrder.getQuantity()));
	}

	public Order createBaseOrder(Marketplace marketplace) {
		Order order = new Order();

		order.setMarketplace(marketplace).setCustomer(marketplace.getCustomer())
				.setShipfromEmail(marketplace.getCustomer().getEmail())
				.setShipfromContact(marketplace.getCustomer().getContactName())
				.setShipfromCompany(marketplace.getCustomer().getBusinessName())
				.setShipfromPhone(removeSpecialCharsAndAreaCode(marketplace.getCustomer().getPhone()));

		return order;
	}

	public Order getCsOrder(Order order, ReverbOrder reverbOrder) throws ParseException {
		setOrderGerneralInfo(order, reverbOrder);
		setOrderCostInfo(order, reverbOrder);
		setOrderStatusInfo(order, reverbOrder);
		setOrderShiptoInfo(order, reverbOrder);
		setOrderBilltoInfo(order, reverbOrder);
		setOrderShippingInfo(order, reverbOrder);
		// Save Orderlines
		setOrderLines(order,reverbOrder);
		return order;
	}
	
	private void setOrderLines(Order order, ReverbOrder reverbOrder) {
		int i = 0;
		Marketplace marketplace = order.getMarketplace();
		order = orderRepository.save(order);
		Orderline csOrderline = orderlineRepository.findByExternalLineIdAndOrder(reverbOrder.getProductId(),order);
		// Orderline csOrderline = orderlineRepository.findByExternalLineId(reverbOrder.getProductId());

		if (csOrderline == null) {
			csOrderline = new Orderline().setOrder(order).setExternalLineId(reverbOrder.getProductId())
					.setLineNumber(++i);
			order.addOrderline(csOrderline);
		}

		csOrderline.setQuantity(Integer.parseInt(reverbOrder.getQuantity()))
				.setUnitPrice(NumberUtility.getSafeCheckDoubleValue(reverbOrder.getAmountProduct().getAmount()))
				.setLineSubtotal(
						NumberUtility.getSafeCheckDoubleValue(reverbOrder.getPresentmentAmountProduct().getAmount()))
				.setSku(reverbOrder.getSku());
		setProductInfo(marketplace, csOrderline, reverbOrder);
	}
	
	private void setProductInfo(Marketplace marketplace, Orderline orderLine, ReverbOrder reverbOrder) {
		MarketplaceProduct csProduct = marketplaceProductRepository.findByMarketplaceAndVariantId(marketplace, reverbOrder.getProductId());

		if (csProduct == null) {
			ReverbListing reverbListing = reverbClient.getProductByListingId(marketplace.getToken(),
					reverbOrder.getProductId());
			csProduct = saveProduct(marketplace, reverbListing, reverbOrder);
		}

		orderLine.setMarketplaceProduct(csProduct).setTitle(csProduct.getTitle()).setHsCode(csProduct.getHsCode()).setQuantity(Integer.parseInt(reverbOrder.getQuantity()));	
	}
	
	private MarketplaceProduct saveProduct(Marketplace marketplace, ReverbListing reverbListing,
			ReverbOrder reverbOrder) {
		MarketplaceProduct csProduct = createBaseProduct(marketplace, reverbOrder);
		setProductGeneralInfo(csProduct, null, reverbListing);
		setProductImage(csProduct, null, reverbListing);
		saveProduct(csProduct);
		return csProduct;
	}

//	
//	private MarketplaceProduct saveProduct(Marketplace marketplace, ReverbProduct product,ReverbOrder reverbOrder) {
//		MarketplaceProduct csProduct = createBaseProduct(marketplace,reverbOrder);
//		for (ReverbListing listing : product.getReverbListings()) {
//			setProductGeneralInfo(csProduct, product, listing);
//			setProductImage(csProduct, product, listing);
//			saveProduct(csProduct);
//		}
//		return csProduct;
//	}
	
	private void saveProduct(MarketplaceProduct csProduct) {
		marketplaceProductRepository.save(csProduct);
	}
	
	private void setProductImage(MarketplaceProduct product, ReverbProduct rbProduct, ReverbListing listing) {
		if (listing.getPhotos().size() >0) {
			if(StringUtils.isNotEmpty(listing.getPhotos().get(0).getLinks().getSmallCrop().getHref())){
				product.setImageUrl(listing.getPhotos().get(0).getLinks().getSmallCrop().getHref());
			} else if(StringUtils.isNotEmpty(listing.getPhotos().get(0).getLinks().getSmallCrop().getHref())){
				product.setImageUrl(listing.getPhotos().get(0).getLinks().getSmallCrop().getHref());
			}
//			product.setImageUrl(StringUtils.isNotEmpty(listing.getPhotos().get(0).getLinks().getSmallCrop().getHref())? "" 
//					:listing.getPhotos().get(0).getLinks().getSmallCrop().getHref());
			
		}
	}
	
	private void setProductGeneralInfo(MarketplaceProduct product, ReverbProduct bcProduct, ReverbListing listing) {
		product.setExternalProductId(Long.valueOf(listing.getId())).setVariantId(listing.getId())
				.setSku(listing.getSku())
				.setTitle(listing.getTitle()).setPrice(StringUtils.isEmpty(listing.getPrice().getAmount())? 0d :
						Double.valueOf(listing.getPrice().getAmount()));
	}

	private void setOrderGerneralInfo(Order order, ReverbOrder reverbOrder) throws ParseException {
		order.setOrderNumber(reverbOrder.getOrderNumber());
		order.setExternalOrderId(reverbOrder.getOrderNumber());
		if (StringUtils.isNotEmpty(reverbOrder.getCreatedAt())) {
			order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse(reverbOrder.getCreatedAt()));
		}
	}

	private void setOrderCostInfo(Order order, ReverbOrder reverbOrder) {
		if (reverbOrder.getAmountTax() != null) {
			order.setTaxes(NumberUtility.getSafeCheckDoubleValue(reverbOrder.getAmountTax().getAmount()));
		}

		if (reverbOrder.getAmountProductSubtotal().getAmount() != null) {
			order.setSubtotal(NumberUtility.getSafeCheckDoubleValue(reverbOrder.getAmountProductSubtotal().getAmount()));
		}

		if (reverbOrder.getTotal() != null) {
			order.setCostCurrency(reverbOrder.getTotal().getCurrency());
			order.setTotal(NumberUtility.getSafeCheckDoubleValue(reverbOrder.getTotal().getAmount()));
		}
		if (reverbOrder.getAmountProduct() != null) {
			order.setOriginalTotal(NumberUtility.getSafeCheckDoubleValue(reverbOrder.getAmountProduct().getAmount()));
		}
	}

	private void setOrderStatusInfo(Order order, ReverbOrder reverbOrder) throws ParseException {
		String prevOrderStatus = order.getStatus();
		if (prevOrderStatus != null && prevOrderStatus.equalsIgnoreCase(ClickShipOrderStatus.Fulfilled.getValue())) {
			return;
		}

		if (reverbOrder.getStatus().equalsIgnoreCase("shipped") 
				|| reverbOrder.getStatus().equalsIgnoreCase("received")) {
			order.setStatus(ClickShipOrderStatus.ExternallyFulfilled);
			if (StringUtils.isNotEmpty(reverbOrder.getShippingDate())) {
				order.setExternallyFulfilledDate(
						new SimpleDateFormat("yyyy-MM-dd").parse(reverbOrder.getShippingDate()));
			}
		} else if (reverbOrder.getStatus().equalsIgnoreCase("paid")) {
			order.setStatus(ClickShipOrderStatus.UnFulfilled);
		} else if (reverbOrder.getStatus().equalsIgnoreCase("payment_pending")) {
			order.setStatus(ClickShipOrderStatus.Pending);
		} else if (reverbOrder.getStatus().equalsIgnoreCase("picked_up")) {
			order.setStatus("Pickup Order");
		} else if (reverbOrder.getStatus().equalsIgnoreCase("refunded")
				|| reverbOrder.getStatus().equalsIgnoreCase("cancelled")) {
			order.setStatus(ClickShipOrderStatus.Cancelled);
		} else {
			order.setStatus(ClickShipOrderStatus.Pending);
		}
	}

	// for LocalPickup we've to hide the ShipIt Button
	private void setOrderShiptoInfo(Order order, ReverbOrder reverbOrder) {
		order.setShiptoCompany(reverbOrder.getBuyerName().trim())
			 .setShiptoContact(reverbOrder.getBuyerName().trim())
			 .setShiptoEmail(reverbOrder.getBuyerEmail());
		if (!reverbOrder.isLocalPickup()) {
			if(reverbOrder.getShippingAddress() != null) {
				order.setShiptoCompany(reverbOrder.getShippingAddress().getName().trim())
						.setShiptoContact(reverbOrder.getShippingAddress().getName().trim())
						.setShiptoAddress1(reverbOrder.getShippingAddress().getStreetAddress())
						.setShiptoAddress2(reverbOrder.getShippingAddress().getExtendedAddress())
						.setShiptoCity(reverbOrder.getShippingAddress().getLocality())
						.setShiptoProvinceState(reverbOrder.getShippingAddress().getRegion())
						.setShiptoZip(reverbOrder.getShippingAddress().getPostalCode())
						.setShiptoCountry(reverbOrder.getShippingAddress().getCountryCode())
						.setShiptoPhone(ClickshipStringUtil
								.getTenDigitPhoneNumber(reverbOrder.getShippingAddress().getPhone()));
			}
		}
	}

	private void setOrderBilltoInfo(Order order, ReverbOrder reverbOrder) {
		if (!reverbOrder.isLocalPickup() && reverbOrder.getShippingAddress() != null) {
			order.setBilltoAddress1(reverbOrder.getShippingAddress().getStreetAddress())
					.setBilltoAddress2(reverbOrder.getShippingAddress().getExtendedAddress())
					.setBilltoContact(reverbOrder.getShippingAddress().getPhone())
					.setBilltoCity(reverbOrder.getShippingAddress().getLocality())
					.setBilltoPostalcode(reverbOrder.getShippingAddress().getPostalCode()).setBilltoEmail("")
					.setBilltoProvinceState(reverbOrder.getShippingAddress().getCountryCode());
		}
		
	}

	private void setOrderShippingInfo(Order order, ReverbOrder reverbOrder) throws ParseException {
		// List<ReceiptShipment> shipping = reverbOrder.;
		if(reverbOrder.getPresentmentAmountShipping() != null) {
		order.setOriginalShippingCost(NumberUtility.getSafeCheckDoubleValue(reverbOrder.getShipping().getAmount()))
				.setShippingCost(
						NumberUtility.getSafeCheckDoubleValue(reverbOrder.getPresentmentAmountShipping().getAmount()))
				.setShippingCurrency(reverbOrder.getPresentmentAmountShipping().getCurrency());
		}
		if(reverbOrder.getShipping() != null) {
			order.setOriginalShippingCurrency(reverbOrder.getShipping().getCurrency());
		}
		if (reverbOrder.getShipmentStatus().equalsIgnoreCase("Shipped")) {
			order.setShipDate(new SimpleDateFormat("yyyy-MM-dd").parse(reverbOrder.getShippingDate()));
		}
		for (ReverbOrderNotes orderNotes : reverbOrder.getOrderNotes()) {
			order.setNote(orderNotes.getBody());
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

}