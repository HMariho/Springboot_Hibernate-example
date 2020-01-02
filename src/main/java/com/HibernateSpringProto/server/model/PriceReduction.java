package com.HibernateSpringProto.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name="pricereduction")
public class PriceReduction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idItem", nullable=false)
    private Items items;
        
    @Column(name="quantity")
    private double quantity;
    
    @Temporal(TemporalType.DATE)
    @Column(name="startDate")
	private Date startDate;
	
    @Temporal(TemporalType.DATE)
    @Column(name="endDate")
	private Date endDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Items getIdItem() {
		return items;
	}

	public void setIdItem(Items idItem) {
		this.items = idItem;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}	
}
