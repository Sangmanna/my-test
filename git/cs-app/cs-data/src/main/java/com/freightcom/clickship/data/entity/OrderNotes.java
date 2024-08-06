package com.freightcom.clickship.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.freightcom.clickship.data.entity.common.BaseEntity;

@Entity
@Table(name = "order_notes")
public class OrderNotes extends BaseEntity {

	private static final long serialVersionUID = 3427559251003556855L;

	@Id
    @GeneratedValue(generator = "customIdGenerator")
	@GenericGenerator(name = "customIdGenerator", type = com.freightcom.clickship.data.util.CSIdGenerator.class)
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marketplace_id")
    private Marketplace marketplace;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false, updatable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, updatable = false)
    private Customer customer;

    @Column(name = "comments")
    private String commentsInfo;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public BaseEntity setId(String id) {
        return null;
    }

    public Marketplace getMarketplace() {
        return marketplace;
    }

    public OrderNotes setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderNotes setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderNotes setOrder(Order order) {
        this.order = order;
        return this;
    }

    public String getCommentsInfo() {
        return commentsInfo;
    }

    public OrderNotes setCommentsInfo(String commentsInfo) {
        this.commentsInfo = commentsInfo;
        return this;
    }

}
