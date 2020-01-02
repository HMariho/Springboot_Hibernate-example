package com.HibernateSpringProto.server.DAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.HibernateSpringProto.server.responseModel.ItemReply;
import com.HibernateSpringProto.server.responseModel.ItemDetailReply;
import com.HibernateSpringProto.server.model.Items;
import com.HibernateSpringProto.server.model.Supplier;

public class ItemResponseFactory {
	public List listItems(Iterable<Items> items) {
		List<ItemReply> output = new ArrayList<ItemReply>();
		for (Items item : items) {
			output.add(createResponse(item));
		}
		return output;
	}

	public ItemDetailReply getItemDetail(Iterable<Items> findAll, String id) {

		Items item = null;
		int searchId = Integer.parseInt(id);

		for (Items items : findAll) {
			if (items.getId() == searchId) {
				item = items;
			}
		}
		
		ItemDetailReply output = new ItemDetailReply(
				searchId, 
				item.getDescription(), 
				isAvailable(item),
				item.getValue(), 
				item.getDateCreation(), 
				item.getIdCreator().getUsername(), 
				item.getSuppliers(),
				item.getPriceReduction());

		return output;
	}

	private ItemReply createResponse(Items item) {

		int id = item.getId().intValue();
		String description = item.getDescription();

		String state = isAvailable(item);

		double price = Math.floor(item.getValue() * 100) / 100;

		java.util.Date creationDate = item.getDateCreation();

		String creator = item.getIdCreator().getUsername();

		return new ItemReply(id, description, state, price, creationDate, creator);

	}

	private String isAvailable(Items item) {
		String state = "";
		if (item.getAvailable() == 1) {
			state = "Available now";
		} else {
			state = "Not available";
		}
		return state;
	}
}