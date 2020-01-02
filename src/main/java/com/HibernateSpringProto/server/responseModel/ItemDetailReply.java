package com.HibernateSpringProto.server.responseModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.HibernateSpringProto.server.model.PriceReduction;
import com.HibernateSpringProto.server.model.PriceReductionReply;
import com.HibernateSpringProto.server.model.Supplier;

public class ItemDetailReply {
	
	private int id;
	
	private String description;
	
	private String state;
	
	private double price;
	
	private Date creationDate;
	
	private String Creator;
	
	public List<String> suppliers;
	
	public List<PriceReductionReply> discounts;
	
	public ItemDetailReply(int id, String description, String state, double price, Date creationDate, String creator,
			List<Supplier> suppliers, List<PriceReduction>priceReductions) {
		super();
		this.id = id;
		this.description = description;
		this.state = state;
		this.price = price;
		this.creationDate = creationDate;
		Creator = creator;
		
		this.suppliers = new ArrayList<String>();
		for (Supplier supplier : suppliers) {
			this.suppliers.add(supplier.getName());
		}
		
		this.discounts = new ArrayList<PriceReductionReply>();
		for (PriceReduction priceReduction : priceReductions) {
			discounts.add(new PriceReductionReply(
					priceReduction.getQuantity(), 
					priceReduction.getStartDate(), 
					priceReduction.getEndDate()
					)
				);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreator() {
		return Creator;
	}

	public void setCreator(String creator) {
		Creator = creator;
	}

	public List<String> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = new ArrayList<String>();
		for (Supplier supplier : suppliers) {
			this.suppliers.add(supplier.getName());
		}
	}
	
	public List<PriceReductionReply> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<PriceReductionReply> discounts) {
		this.discounts = discounts;
	}

}
