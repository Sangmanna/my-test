/*
Ebay soap client to be used , to fetch images for the products. As per discussion, a separate call to fetch images is not required.
In case needed for future, please keep this soap client.
 */



package com.freightcom.clickship.client.ebay;

/*
import com.freightcom.clickship.ebay.*;
import org.springframework.stereotype.Component;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

@Component
public class EbaySoapClient {

    static {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dumpThreshold", "999999");
    }

    public GetItemResponseType getEbayItemDetails(String legacyItemId, String accessToken) {
        EBayAPIInterfaceService service = new EBayAPIInterfaceService();
        EBayAPIInterface api = service.getEBayAPI();

        ((BindingProvider) api).getRequestContext().
                put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://api.ebay.com/wsapi?callname=GetItem");
        GetItemRequestType itemRequestType = new GetItemRequestType();
        itemRequestType.setItemID(legacyItemId);
        itemRequestType.setVersion("1081");

        CustomSecurityHeaderType customSecurityHeaderType = new CustomSecurityHeaderType();
        customSecurityHeaderType.setEBayAuthToken(accessToken);

        Holder<CustomSecurityHeaderType> requesterCredentials = new Holder<>(customSecurityHeaderType);
        return api.getItem(itemRequestType, requesterCredentials);
    }


}


 */