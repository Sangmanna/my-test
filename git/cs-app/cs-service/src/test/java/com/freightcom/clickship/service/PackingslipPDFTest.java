package com.freightcom.clickship.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.freightcom.clickship.data.entity.Carrier;
import com.freightcom.clickship.data.entity.Customer;
import com.freightcom.clickship.data.entity.CustomerPreferences;
import com.freightcom.clickship.data.entity.Order;
import com.freightcom.clickship.data.entity.Shipment;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class PackingslipPDFTest {

	boolean hasLogoImage = true;
	boolean isLetterSize = true;

	@Test
	public void testPdfCreation() {
		String filePath = "C:\\doc\\sample packing slip.pdf";

		createPdf(filePath);

		File file = new File(filePath);
		boolean fileExists = file.exists();

		Assertions.assertTrue(fileExists, "PDF file was not created");
	}

	private void createPdf(String filePath) {
		try {
			Document document = new Document();

			PdfWriter.getInstance(document, new FileOutputStream(filePath));

			document.open();

			createPackingslipDocument(document);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	    
	private static final Font headerRegularFont = new Font(FontFamily.UNDEFINED, 9f, Font.NORMAL, BaseColor.BLACK);
	
	private static final Font bodyFont = new Font(FontFamily.UNDEFINED, 10f, Font.NORMAL, BaseColor.BLACK);
	private static final Font bodyFont8 = new Font(FontFamily.UNDEFINED, 8f, Font.NORMAL, BaseColor.BLACK);
	private static final Font bodyBoldFont9 = new Font(FontFamily.UNDEFINED, 9f, Font.BOLD, BaseColor.BLACK);
	private static final Font boldFont = new Font(FontFamily.UNDEFINED, 10f, Font.BOLD, BaseColor.BLACK);
	private static final Font boldFont11 = new Font(FontFamily.UNDEFINED, 11f, Font.BOLD, BaseColor.BLACK);
	

	public void createPackingslipDocument(Document document) throws Exception {
		Customer customer = getTestCustomer();
		CustomerPreferences customerPreference = getTestCustomerPreference();
		Order order = getTestOrder();
		createHeader(document, customer, customerPreference, order);
		setPackingSlipTitle(document);
		createBodyTable(document);
		createBottom(document, customerPreference);
		addPageNumber(document);
	}

	private CustomerPreferences getTestCustomerPreference() {
		CustomerPreferences customerPreference = new CustomerPreferences();
		if (hasLogoImage) {
			customerPreference.setBrandingImageUrl("https://www.freightcom.com/hs-fs/hubfs/Freightcom-April2019%20Theme/images/header-logo.png?width=620&name=header-logo.png");
		}
		customerPreference.setBrokerName("Insert Custom Message\n"
				+ "Lorem ipsum dolor sitt amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore\n"
				+ "magna aliquam erat volutpat.\n"
				+ "Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo\n"
				+ "consequat.");
		return customerPreference;
	}

	private Customer getTestCustomer() {
		Customer customer = new Customer();
		customer.setBusinessName("Test business name");
		return customer;
	}

	private Order getTestOrder() {
		Order order = new Order();
		order.setShiptoContact("John Doe");
		order.setShiptoAddress1("123 Main St");
		order.setShiptoAddress2("Unit 1");
		order.setShiptoCity("Toronto");
		order.setShiptoProvinceState("ON");
		order.setShiptoZip("M1M 1M1");
		order.setShiptoCountry("Canada");
		order.setShiptoPhone("416-123-4567");
		order.setShiptoEmail("john.doe@gmail.com");
		order.setOrderDate(new Date());
		order.setOrderNumber("0000214");
		order.setShipDate(new Date());
		
		List<Shipment> shipmentList = new ArrayList<>();
		Shipment shipment = new Shipment();
		shipment.setActive(true);
		shipment.setCreatedDatetime(new Date());
		shipmentList.add(shipment);
		order.setShipments(shipmentList);

		Carrier carrier = new Carrier();
		carrier.setService("Canpar Ground");
		order.setCarrier(carrier);
		return order;
	}

	private void createHeader(Document document, Customer customer, CustomerPreferences customerPreference, Order order) throws Exception {
		PdfPTable topHeaderTable = new PdfPTable(new float[] { 46, 24, 30 });
		topHeaderTable.setWidthPercentage(100);
        topHeaderTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);

		// add logo or business name on the left
        setDocumentLeftHeader(topHeaderTable, customer, customerPreference);

		// add ship to address in the middle
		setDocumentMiddleHeader(topHeaderTable, customer, order);

		// add order and delivery date on the right
        setDocumentRightHeader(topHeaderTable, customer, order);
        
        document.add(topHeaderTable);
	}
	
	private void setDocumentRightHeader(PdfPTable topHeaderTable, Customer customer, Order order) {
	    PdfPCell rightHeaderCell = new PdfPCell();
	    rightHeaderCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	    rightHeaderCell.setVerticalAlignment(Element.ALIGN_TOP);
	    rightHeaderCell.setBorder(Rectangle.NO_BORDER);

	    // Order Number
	    Paragraph orderNumberParagraph = new Paragraph();
	    orderNumberParagraph.setAlignment(Element.ALIGN_RIGHT);
	    Chunk orderNumberLabel = new Chunk("Order #: \n", boldFont);
	    Chunk orderNumberValue = new Chunk("#" + order.getOrderNumber(), headerRegularFont);
	    orderNumberParagraph.add(orderNumberLabel);
	    orderNumberParagraph.add(orderNumberValue);
	    orderNumberParagraph.setSpacingAfter(5f);
	    rightHeaderCell.addElement(orderNumberParagraph);
	    
	    // Order Date
	    Paragraph orderDateParagraph = new Paragraph();
	    orderDateParagraph.setAlignment(Element.ALIGN_RIGHT);
	    Chunk orderDateLabel = new Chunk("Order Date: \n", boldFont);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
	    Chunk orderDateValue = new Chunk(dateFormat.format(order.getOrderDate()), headerRegularFont);
	    orderDateParagraph.add(orderDateLabel);
	    orderDateParagraph.add(orderDateValue);
	    orderDateParagraph.setSpacingAfter(5f);
	    rightHeaderCell.addElement(orderDateParagraph);

	    // Ship Date
	    Paragraph shipDateParagraph = new Paragraph();
	    shipDateParagraph.setAlignment(Element.ALIGN_RIGHT);
	    Chunk shipDateLabel = new Chunk("Ship Date: \n", boldFont);
	    Chunk shipDateValue = new Chunk(dateFormat.format(order.getShipments().stream().filter(Shipment::isActive).findFirst().get().getCreatedDatetime()), headerRegularFont);
	    shipDateParagraph.add(shipDateLabel);
	    shipDateParagraph.add(shipDateValue);
	    shipDateParagraph.setSpacingAfter(5f);
	    rightHeaderCell.addElement(shipDateParagraph);

	    // Shipping Method
	    Paragraph shippingMethodParagraph = new Paragraph();
	    shippingMethodParagraph.setAlignment(Element.ALIGN_RIGHT);
	    Chunk shippingMethodLabel = new Chunk("Shipping Method: \n", boldFont);
	    Chunk shippingMethodValue = new Chunk(order.getCarrier().getService(), headerRegularFont);
	    shippingMethodParagraph.add(shippingMethodLabel);
	    shippingMethodParagraph.add(shippingMethodValue);
	    rightHeaderCell.addElement(shippingMethodParagraph);

	    topHeaderTable.addCell(rightHeaderCell);
	}
	

	private void setDocumentMiddleHeader(PdfPTable topHeaderTable, Customer customer, Order order) {
	    PdfPCell topMiddleHeaderCell = null;

	    // Create middle top header cell
	    PdfPCell middleTopHeaderCell = new PdfPCell();

	    // Set content for middle top header cell
	    StringBuilder middleTopHeaderContent = new StringBuilder();
	    middleTopHeaderContent.append(order.getShiptoContact()).append("\n");
	    middleTopHeaderContent.append(order.getShiptoAddress1()).append(", ").append(order.getShiptoAddress2()).append("\n");
	    middleTopHeaderContent.append(order.getShiptoCity()).append(" ").append(order.getShiptoProvinceState()).append(" ").append(order.getShiptoZip()).append("\n");
	    middleTopHeaderContent.append(order.getShiptoCountry()).append("\n");
	    middleTopHeaderContent.append(order.getShiptoEmail());

	    // Create paragraph with custom font and size
	    Paragraph paragraph = new Paragraph();
	    Chunk labelChunk = new Chunk("Shipped To:", boldFont);
	    Chunk contentChunk = new Chunk(middleTopHeaderContent.toString(), headerRegularFont);
	    paragraph.add(labelChunk);
	    paragraph.add("\n");
	    paragraph.add(contentChunk);

	    middleTopHeaderCell.addElement(paragraph);

	    // Set properties for middle top header cell
	    middleTopHeaderCell.setBorder(Rectangle.NO_BORDER);

	    // Assign the middle top header cell to the top middle header cell variable
	    topMiddleHeaderCell = middleTopHeaderCell;

	    topHeaderTable.addCell(topMiddleHeaderCell);
	}


	private void setDocumentLeftHeader(PdfPTable topHeaderTable, Customer customer, CustomerPreferences customerPreference) throws Exception {
		PdfPCell topLeftHeaderCell = null;
        		
		if (customer.hasCustomBranding() || StringUtils.isEmpty(customerPreference.getBrandingImageUrl())) {
			topLeftHeaderCell = new PdfPCell(new Phrase(customer.getBusinessName()));

		} else {
			try {
				Image image = Image.getInstance(customerPreference.getBrandingImageUrl());
				image.scaleAbsolute(120f, 40f);
				topLeftHeaderCell = new PdfPCell(image);
			} catch (Exception e) {
				topLeftHeaderCell = new PdfPCell(new Phrase(customer.getBusinessName()));
			}
		}
		
		topLeftHeaderCell.setHorizontalAlignment(Element.ALIGN_LEFT);
        topLeftHeaderCell.setVerticalAlignment(Element.ALIGN_TOP);
        topLeftHeaderCell.setBorder(Rectangle.NO_BORDER);

        topHeaderTable.addCell(topLeftHeaderCell);
	}

	private void addPageNumber(Document document) {
	}

	private void createBottom(Document document, CustomerPreferences customerPreference) throws Exception {
		PdfPTable bottomTable = new PdfPTable(new float[] { 80, 20 });
		bottomTable.setWidthPercentage(100);
		
		PdfPCell noteCell = new PdfPCell(new Phrase("* Discount applied at subtotal", bodyFont8));
		noteCell.setColspan(2);
		noteCell.setBorder(Rectangle.NO_BORDER);
		noteCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		
		bottomTable.addCell(noteCell);
		
		// something new data should be here instead of broker name
		PdfPCell customerNote = new PdfPCell(new Phrase(customerPreference.getBrokerName(), bodyFont));
		customerNote.setColspan(2);
		customerNote.setBorder(Rectangle.NO_BORDER);
		customerNote.setHorizontalAlignment(Element.ALIGN_LEFT);
		
		bottomTable.addCell(customerNote);
		document.add(bottomTable);
	}

	private void createBodyTable(Document document) throws Exception {
	    PdfPTable bodyTable = new PdfPTable(1);
	    bodyTable.setWidthPercentage(100);

	    PdfPTable innerTable = new PdfPTable(5);
		setTableWidth(innerTable, new float[] { 40, 15, 15, 10, 10 });
	    innerTable.setWidthPercentage(100);

	    String[] columnHeaders = {"Item", "SKU", "Quantity", "Unit Price", "Total"};

	    // Add column headers with rectangular borders
		for (int i = 0; i < columnHeaders.length; i++) {
			String columnHeader = columnHeaders[i];
	        PdfPCell headerCell = new PdfPCell(new Phrase(columnHeader, bodyBoldFont9));
			if (i == 0) {
				headerCell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.LEFT);
			} else if (i == columnHeaders.length - 1) {
				headerCell.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT);
			} else {
				headerCell.setBorder(Rectangle.TOP | Rectangle.BOTTOM);
			}
			
			headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			headerCell.setPaddingTop(5);
			headerCell.setPaddingBottom(7);
			
			if (i != 0) {
				headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			} else {
				headerCell.setVerticalAlignment(Element.ALIGN_LEFT);
				headerCell.setPaddingLeft(20);
			}
	        innerTable.addCell(headerCell);
	    }
		PdfPCell headerDell = new PdfPCell(innerTable);
		headerDell.setPaddingTop(13);
		headerDell.setBorder(Rectangle.TOP);
		headerDell.setBorderWidthTop(2f);
		bodyTable.addCell(headerDell);

		PdfPTable dataTable = new PdfPTable(6);
		setTableWidth(dataTable, new float[] { 10, 30, 15, 15, 10, 10 });
		dataTable.setWidthPercentage(100);
	    
	    // Add 6 rows with random data
	    Random random = new Random();
	    
	    int totalQuantity = 0;
	    double totalPrice = 0;
	    for (int i = 1; i <= 6; i++) {
	    	int quantity = random.nextInt(10) + 1;
	    	double price = random.nextDouble() * 10;
	    	double total = price * quantity;
	    	
			dataTable.addCell(getProductImageCell());
			dataTable.addCell(getProductNameCell(i));
	    	dataTable.addCell(createCellWithBottomBorder("SKU " + i));
	    	dataTable.addCell(createCellWithBottomBorder(String.valueOf(quantity)));
	    	dataTable.addCell(createCellWithBottomBorder("$" + String.format("%.2f", price)));
	    	dataTable.addCell(createCellWithBottomBorder("$" + String.format("%.2f", total)));
	    	
	    	totalQuantity += quantity;
	    	totalPrice += total;
	    }
	    
	    dataTableSubtotal(dataTable, random, totalQuantity, totalPrice);

	    // Add the inner table to the body table
	    PdfPCell dataTableCell = new PdfPCell(dataTable);
	    dataTableCell.setBorder(Rectangle.BOTTOM);
	    dataTableCell.setBorderWidthBottom(2f);
	    bodyTable.addCell(dataTableCell);

	    document.add(bodyTable);
	}

	private void dataTableSubtotal(PdfPTable dataTable, Random random, int totalQuantity, double totalPrice) throws BadElementException, MalformedURLException, IOException {
		PdfPCell noteCell = createBodyDataCel(new PdfPCell(new Phrase("Note: This is not an invoice", bodyFont8)));
		noteCell.setColspan(2);
		noteCell.setPaddingLeft(0);
		noteCell.setPaddingTop(15);
		noteCell.setPaddingRight(15);
		noteCell.setPaddingBottom(15);
		noteCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		dataTable.addCell(noteCell);
		
		PdfPCell subtotalCell = new PdfPCell(new Phrase("Subtotal", boldFont));
    	dataTable.addCell(createBodyDataCel(subtotalCell));
    	
    	PdfPCell totalQuantityCell = createCellWithBottomBorder(String.valueOf(totalQuantity));
    	dataTable.addCell(totalQuantityCell);
    	dataTable.addCell(createBodyDataCel(new PdfPCell()));
    	
    	PdfPCell cell = new PdfPCell(new Phrase("$" + String.format("%.2f", totalPrice), boldFont));
    	dataTable.addCell(createBodyDataCel(cell));
	}

	private PdfPCell getProductNameCell(int i) {
		PdfPCell productNameCell = createCellWithBottomBorder("Product name Product name Product name " + i);
		productNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		return productNameCell;
	}

	private PdfPCell getProductImageCell() throws BadElementException, MalformedURLException, IOException {
		File imgFile = new File("C:\\doc\\test product.png");
		Image image = Image.getInstance(imgFile.getPath());
		image.scaleAbsolute(30f, 30f);
		PdfPCell imageCell = createCellWithBottomBorder(image);
		imageCell.setPaddingTop(8);
		imageCell.setPaddingBottom(8);
		imageCell.setPaddingLeft(12);
		imageCell.setPaddingRight(12);
		imageCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		return imageCell;
	}

	private PdfPCell createCellWithBottomBorder(String content) {
	    PdfPCell cell = new PdfPCell(new Phrase(content, bodyFont));
	    return createBodyDataCel(cell);
	}
	
	private PdfPCell createCellWithBottomBorder(Image image) {
	    PdfPCell cell = new PdfPCell(image);
	    return createBodyDataCel(cell);
	}

	private PdfPCell createBodyDataCel(PdfPCell cell) {
		cell.setBorder(Rectangle.BOTTOM);
		cell.setBorderColor(BaseColor.GRAY);
	    cell.setBorderWidthBottom(0.5f);
	    cell.setBorderWidthTop(0f);
	    cell.setBorderWidthLeft(0f);
	    cell.setBorderWidthRight(0f);
	    cell.setPadding(5);
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	    return cell;
	}


	private void setTableWidth(PdfPTable table, float[] columnWidths) {
		try {
			table.setWidths(columnWidths);
		} catch (DocumentException e) {
		}
	}


	private void setPackingSlipTitle(Document document) throws Exception {
		Paragraph picklistParagraph = new Paragraph();
	    Chunk label = new Chunk("Packing Slip", boldFont11);
	    picklistParagraph.add(label);
	    picklistParagraph.setSpacingAfter(10f);
	    document.add(picklistParagraph);
	}
	
	@Test
	public void testResize() throws Exception {
		String originalPdfFilePath = "C:\\doc\\sample packing slip.pdf";
		String modifiedPdfFilePath = "C:\\doc\\sample packing slip_modified3.pdf";
		
		PdfReader pdfReader = new PdfReader(originalPdfFilePath);
		Document document = new Document(new Rectangle(Utilities.inchesToPoints(4), Utilities.inchesToPoints(6)));

		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(modifiedPdfFilePath));
		pdfWriter.setPdfVersion(PdfWriter.VERSION_1_7);
		pdfWriter.setCompressionLevel(0);

		document.open();
		PdfContentByte contentByte = pdfWriter.getDirectContent();
		PdfImportedPage importedPage = pdfWriter.getImportedPage(pdfReader, 1);

		float scaleFactor = Math.min(
		    document.getPageSize().getWidth() / importedPage.getWidth(),
		    document.getPageSize().getHeight() / importedPage.getHeight()
		);

		contentByte.addTemplate(importedPage, scaleFactor, 0, 0, scaleFactor, 0, 0);
		document.close();
		pdfWriter.close();
		pdfReader.close();

	}
	
	
}