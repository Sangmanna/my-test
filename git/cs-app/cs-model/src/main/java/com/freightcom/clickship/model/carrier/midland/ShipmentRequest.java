package com.freightcom.clickship.model.carrier.midland;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value= JsonInclude.Include.NON_EMPTY, content= JsonInclude.Include.NON_NULL)
public class ShipmentRequest {
  
	private List<PieceDetail> pieceDetail;
	
	private List<RateQuoteReqAcc> extraService;
	
	private List<ShipmentDetails> shipmentDetails;

    public List<ShipmentDetails> getShipmentDetails() {
        return shipmentDetails;
    }

    public void setShipmentDetails(List<ShipmentDetails> shipmentDetails) {
        this.shipmentDetails = shipmentDetails;
    }

    public List<RateQuoteReqAcc> getExtraService() {
        return extraService;
    }

    public void setExtraService(List<RateQuoteReqAcc> extraService) {
        this.extraService = extraService;
    }

    public List<PieceDetail> getPieceDetail() {
        return pieceDetail;
    }

    public void setPieceDetail(List<PieceDetail> pieceDetail) {
        this.pieceDetail = pieceDetail;
    }
}
