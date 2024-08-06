package com.freightcom.clickship.client.canpar;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.canpar.canparaddons.ws.CancelPickup;
import com.canpar.canparaddons.ws.CancelPickupResponse;
import com.canpar.canparaddons.ws.SchedulePickupV2;
import com.canpar.canparaddons.ws.SchedulePickupV2Response;
import com.canpar.canparaddons.ws.TrackByBarcode;
import com.canpar.canparaddons.ws.TrackByBarcodeResponse;
import com.canpar.canshipws.business.ws.ProcessShipment;
import com.canpar.canshipws.business.ws.ProcessShipmentResponse;
import com.canpar.canshipws.onlinerating.ws.RateShipmentAllServices;
import com.canpar.canshipws.onlinerating.ws.RateShipmentAllServicesResponse;
import com.freightcom.clickship.canpar.addon.CanparAddonsService;
import com.freightcom.clickship.canpar.addon.CanparAddonsServiceStub;
import com.freightcom.clickship.canpar.business.CanshipBusinessService;
import com.freightcom.clickship.canpar.business.CanshipBusinessServiceStub;
import com.freightcom.clickship.canpar.rate.CanparRatingService;
import com.freightcom.clickship.canpar.rate.CanparRatingServiceStub;
import com.freightcom.clickship.model.carrier.canpar.CANPAREndpoint;

@Component
public class CanparCarrierSOAPClient {
	
	@Value("${canpar.soap.service.url:https://sandbox.canpar.com}")
	private String soapServiceUrl;
	
	private CanparRatingService canparRatingServiceStub = null;
	
	private CanparAddonsService canparAddonsServiceStub = null;
	
	private CanshipBusinessService canshipBusinessServiceStub = null;
	
	public RateShipmentAllServicesResponse getRates(RateShipmentAllServices request) {
		try {
			return getCanparRatingServiceStub().rateShipmentAllServices(request);
		} catch (AxisFault e) {
			throw new RuntimeException("Exception while creating stub.", e);
		} catch (RemoteException e) {
			throw new RuntimeException("Exception while getting rates from canpar.", e);
		}
	}
	
	public ProcessShipmentResponse processShipment(ProcessShipment obj) {
		try {
			return getCanparBusinessServiceStub().processShipment(obj);
		} catch (AxisFault e) {
			throw new RuntimeException("Exception while creating stub.", e);
		} catch (RemoteException e) {
			throw new RuntimeException("Exception while getting rates from canpar.", e);
		}
	}
	
	public com.canpar.canshipws.business.ws.GetLabelsResponse getLabel(com.canpar.canshipws.business.ws.GetLabels obj) {
		try {
			return getCanparBusinessServiceStub().getLabels(obj);
		} catch (AxisFault e) {
			throw new RuntimeException("Exception while creating stub.", e);
		} catch (RemoteException e) {
			throw new RuntimeException("Exception while getting rates from canpar.", e);
		}
	}
	
	public TrackByBarcodeResponse getTrackingInfo(TrackByBarcode request) {
		try {
			return getCanparAddonsServiceStub().trackByBarcode(request);
		} catch (AxisFault e) {
			throw new RuntimeException("Exception while creating stub.", e);
		} catch (RemoteException e) {
			throw new RuntimeException("Exception while getting tracking details from canpar.", e);
		}
	}
	
	public SchedulePickupV2Response schedulePickup(SchedulePickupV2 schedulePickupV2) {
		try {
			return getCanparAddonsServiceStub().schedulePickupV2(schedulePickupV2);
		} catch (RemoteException e) {
			throw new RuntimeException("Exception while schedulePickup", e);
		}
	}
	
	public CancelPickupResponse cancelPickup(CancelPickup cancelPickup) {
		try {
			return getCanparAddonsServiceStub().cancelPickup(cancelPickup);
		} catch (RemoteException e) {
			throw new RuntimeException("Exception while cancelPickup", e);
		}
	}
	
	private CanparAddonsService getCanparAddonsServiceStub() {
		if (canparAddonsServiceStub == null) {
			try {
				canparAddonsServiceStub = new CanparAddonsServiceStub(String.format(CANPAREndpoint.ADDON.getValue(), soapServiceUrl));
			} catch (AxisFault e) {
				throw new RuntimeException("Exception while creating webservice stub.", e);
			}
		}

		return canparAddonsServiceStub;
	}
	
	private CanparRatingService getCanparRatingServiceStub() {
		if (canparRatingServiceStub == null) {
			try {
				canparRatingServiceStub = new CanparRatingServiceStub(String.format(CANPAREndpoint.RATING.getValue(), soapServiceUrl));
			} catch (AxisFault e) {
				throw new RuntimeException("Exception while creating webservice stub.", e);
			}
		}

		return canparRatingServiceStub;
	}
	
	private CanshipBusinessService getCanparBusinessServiceStub() {
		if (canshipBusinessServiceStub == null) {
			try {
				canshipBusinessServiceStub = new CanshipBusinessServiceStub(String.format(CANPAREndpoint.BUSINESS.getValue(), soapServiceUrl));
			} catch (AxisFault e) {
				throw new RuntimeException("Exception while creating webservice stub.", e);
			}
		}

		return canshipBusinessServiceStub;
	}

}
