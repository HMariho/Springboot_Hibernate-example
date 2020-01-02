package com.HibernateSpringProto.server.responseModel;

import java.util.Calendar;
import java.util.Date;

public class ItemReply {

		private int id;
		
		private String description;
		
		private String state;
		
		private double price;
		
		private Date creationDate;
		
		private String Creator;

		public ItemReply(int id, String description, String state, double price, Date creationDate, String creator) {
			super();
			this.id = id;
			this.description = description;
			this.state = state;
			this.price = price;
			this.creationDate = creationDate;
			Creator = creator;
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
	
}
