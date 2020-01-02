package com.HibernateSpringProto.server.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table (name="Deactivation")
public class Deactivation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@ManyToOne
	@JoinColumn(name="item_id", nullable=false)
	@JsonBackReference
	private Items item;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	@JsonBackReference
	User userId;
	
	@Temporal(TemporalType.DATE)
    @Column(name="DateCreation")
	Date date;
	
	@Column(name="reason")
	String reason;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Items getItemId() {
		return item;
	}

	public void setItemId(Items itemId) {
		this.item = itemId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
