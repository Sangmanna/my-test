@XmlSchema(
    namespace = "http://mws.amazonservices.com/schema/Products/2011-10-01",
    elementFormDefault = XmlNsForm.QUALIFIED,
    xmlns= {
    		@XmlNs(prefix="", namespaceURI="http://mws.amazonservices.com/schema/Products/2011-10-01"),
    		@XmlNs(prefix="ns2", namespaceURI="http://mws.amazonservices.com/schema/Products/2011-10-01/default.xsd")
    }
		)
package com.freightcom.clickship.model.marketplace.amazon.products;
import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;