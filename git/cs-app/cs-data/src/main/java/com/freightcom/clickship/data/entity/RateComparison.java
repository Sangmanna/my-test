package com.freightcom.clickship.data.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "rate_comparison")
public class RateComparison extends BaseEntity {

	private static final long serialVersionUID = 2185438236670547202L;

	@Id
	@GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
	@Column(name = "id", nullable = false, updatable = false)
	private String id;

	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "shipment_id")
	@JsonIgnore
	private Shipment shipment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carrier_id")
	@JsonIgnore
	private Carrier carrier;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "next_best_carrier_id")
	@JsonIgnore
	private Carrier nextBestCarrier;
	
	@Column(name = "rate")
	private double rate;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "next_source")
	private String nextSource;
	
	@Column(name ="service")
	private String service;

	@Column(name = "next_best_rate")
	private double nextBestRate;
	
	@Column(name = "next_best_service")
	private String nextBestService;

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public RateComparison setId(String id) {
		this.id = id;
		return this;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public RateComparison setShipment(Shipment shipment) {
		this.shipment = shipment;
		return this;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public RateComparison setCarrier(Carrier carrier) {
		this.carrier = carrier;
		return this;
	}

	public Carrier getNextBestCarrier() {
		return nextBestCarrier;
	}

	public RateComparison setNextBestCarrier(Carrier nextBestCarrier) {
		this.nextBestCarrier = nextBestCarrier;
		return this;
	}

	public double getRate() {
		return rate;
	}

	public RateComparison setRate(double rate) {
		this.rate = rate;
		return this;
	}

	public String getService() {
		return service;
	}

	public RateComparison setService(String service) {
		this.service = service;
		return this;
	}

	public double getNextBestRate() {
		return nextBestRate;
	}

	public RateComparison setNextBestRate(double nextBestRate) {
		this.nextBestRate = nextBestRate;
		return this;
	}

	public String getNextBestService() {
		return nextBestService;
	}

	public RateComparison setNextBestService(String nextBestService) {
		this.nextBestService = nextBestService;
		return this;
	}

	public String getSource() {
		return source;
	}

	public RateComparison setSource(String source) {
		this.source = source;
		return this;
	}

	public String getNextSource() {
		return nextSource;
	}

	public RateComparison setNextSource(String nextSource) {
		this.nextSource = nextSource;
		return this;
	}
}