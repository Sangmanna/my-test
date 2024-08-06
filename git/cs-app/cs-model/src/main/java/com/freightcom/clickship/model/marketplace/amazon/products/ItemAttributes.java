package com.freightcom.clickship.model.marketplace.amazon.products;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ItemAttributes",namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemAttributes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlAttribute(name="Units")
	private String units;
	
	@XmlElement(name="Binding", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String binding;
	@XmlElement(name="Brand", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String brand;
	@XmlElement(name="Color", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String color;
	@XmlElement(name="ItemDimensions", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private ItemDimensions itemDimensions;
	@XmlElement(name="Label", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String label;
	@XmlElement(name="Manufacturer", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String manufacturer;
	@XmlElement(name="ManufacturerMinimumAge", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String manufacturerMinimumAge;
	@XmlElement(name="MaterialType", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String materialType;
	@XmlElement(name="Model", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String model;
	@XmlElement(name="PackageDimensions", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private PackageDimensions packageDimensions;
	@XmlElement(name="PackageQuantity", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String packageQuantity;
	@XmlElement(name="PartNumber", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String partNumber;
	@XmlElement(name="ProductGroup", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String productGroup;
	@XmlElement(name="ProductTypeName", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String productTypeName;
	@XmlElement(name="Publisher", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String publisher;
	@XmlElement(name="SmallImage", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private SmallImage smallImage;
	@XmlElement(name="Studio", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String studio;
	@XmlElement(name="Title", namespace="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
	private String title;
	
	public ItemAttributes() {
		super();
	}
	
	public ItemAttributes(String binding, String brand,String color, ItemDimensions itemDimensions,
			String label, String manufacturer,String manufacturerMinimumAge, String materialType,
			String model, PackageDimensions packageDimensions, String packageQuantity,
			String partNumber, String productGroup,String productTypeName,String publisher,
			SmallImage smallImage,String studio,String title) {
		super();
		this.binding = binding;
		this.color = color;
		this.itemDimensions = itemDimensions;
		this.label = label;
		this.manufacturer = manufacturer;
		this.manufacturerMinimumAge = manufacturerMinimumAge;
		this.materialType = materialType;
		this.model = model;
		this.packageDimensions = packageDimensions;
		this.packageQuantity = packageQuantity;
		this.partNumber = partNumber;
		this.productGroup = productGroup;
		this.productTypeName = productTypeName;
		this.publisher = publisher;
		this.smallImage = smallImage;
		this.studio = studio;
		this.title = title;
		
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getBinding() {
		return binding;
	}

	public void setBinding(String binding) {
		this.binding = binding;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ItemDimensions getItemDimensions() {
		return itemDimensions;
	}

	public void setItemDimensions(ItemDimensions itemDimensions) {
		this.itemDimensions = itemDimensions;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturerMinimumAge() {
		return manufacturerMinimumAge;
	}

	public void setManufacturerMinimumAge(String manufacturerMinimumAge) {
		this.manufacturerMinimumAge = manufacturerMinimumAge;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public PackageDimensions getPackageDimensions() {
		return packageDimensions;
	}

	public void setPackageDimensions(PackageDimensions packageDimensions) {
		this.packageDimensions = packageDimensions;
	}

	public String getPackageQuantity() {
		return packageQuantity;
	}

	public void setPackageQuantity(String packageQuantity) {
		this.packageQuantity = packageQuantity;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public SmallImage getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(SmallImage smallImage) {
		this.smallImage = smallImage;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
