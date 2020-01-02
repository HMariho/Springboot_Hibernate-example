package com.HibernateSpringProto.server.model;

import java.util.Date;

public class PriceReductionReply {
    private double quantity;
    
	private Date startDate;
	
	private Date endDate;

	public PriceReductionReply(double quantity, Date startDate, Date endDate) {
		this.quantity = quantity;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
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
}
