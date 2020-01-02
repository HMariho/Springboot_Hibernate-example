package com.HibernateSpringProto.server.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name="items")
public class Items {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="description")
    private String description;
    
    @Column(name="value")
    private Double value;
    
    @Column(name="available")
    private int available;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "IdCreator")
    private User idCreator;
    
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
        name = "itemsupplier", 
        joinColumns = { @JoinColumn(name = "id_item") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_supplier") }
    )
	@JsonBackReference
    private List<Supplier> suppliers = new ArrayList<>();
    
    
	@OneToMany(fetch = FetchType.EAGER, mappedBy="items")
    private Set<PriceReduction> PriceReduction;
    
	@Temporal(TemporalType.DATE)
    @Column(name="DateCreation")
    private Date DateCreation;
	
	
    
	public Items() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Double getValue() {
		return value;
	}



	public void setValue(Double value) {
		this.value = value;
	}



	public int getAvailable() {
		return available;
	}



	public void setAvailable(int available) {
		this.available = available;
	}
	
	public Date getDateCreation() {
		return DateCreation;
	}



	public void setDateCreation(Date dateCreation) {
		DateCreation = dateCreation;
	}



	public User getIdCreator() {
		return idCreator;
	}



	public void setIdCreator(User idCreator) {
		this.idCreator = idCreator;
	}



	public List<Supplier> getSuppliers() {
		return suppliers;
	}



	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}



	public List<PriceReduction> getPriceReduction() {
		return new ArrayList<>(this.PriceReduction);
	}



	public void setPriceReduction(List <PriceReduction> priceReduction) {
		PriceReduction = new HashSet<>(priceReduction);
	} 	
}
