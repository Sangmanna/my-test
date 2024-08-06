package com.freightcom.clickship.data.entity.common;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -6044109834917371718L;

	@Column(name = "created_datetime")
	@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    public Date createdDatetime;
	
	@Column(name = "update_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	public Date updateDatetime;
	
	@Column(name = "created_by")
	@CreatedBy
	public String createdBy;
	
	@Column(name = "updated_by")
	@LastModifiedBy
	public String updatedBy;

	public abstract String getId();
	
	public abstract BaseEntity setId(String id);
	
	public Date getCreatedDatetime() {
		return createdDatetime;
	}
	
	public BaseEntity setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
		return this;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public BaseEntity setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public BaseEntity setUpdateDatetime(Date updatedAt) {
		this.updateDatetime = updatedAt;
		return this;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public BaseEntity setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}
	
	/**
	 * Deprecated. Please do not use this method except for the cs-admin. This will bypass auditing mechanism.
	 *  
	 * @param createdBy
	 * @param updatedBy
	 */
	public void updateAuditFields(Date createdDateTime, String createdBy) {
		this.createdDatetime = createdDateTime;
		this.createdBy = createdBy;
	}
	
/**	@PrePersist
	private void initializeCustomer() {
		try {
			Method getter = this.getClass().getMethod("getCustomer");
			Customer customer = (Customer) getter.invoke(this);
			if (customer == null) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
				
				if(authentication instanceof AuthenticationToken) {
					User user = (User) ((AuthenticationToken) authentication).get("loginUser");
					
					if(user != null) {
						Method setter = this.getClass().getMethod("setCustomer", Customer.class);
						setter.invoke(this, user.getCustomer());
					}
				}		
			}
		} catch (Exception e) { }
	} */
	
}
