package com.HibernateSpringProto.server.control;

import java.util.ArrayList;
import java.util.List;

import com.HibernateSpringProto.server.model.Items;


public class ItemRegistration {

	private List <Items> itemRecords;
	
	private static ItemRegistration itReg = null;
	
	private ItemRegistration() {
		itemRecords = new ArrayList<Items>();
	}
	
	public static ItemRegistration getInstance() {
		if(itReg == null) {
			itReg = new ItemRegistration();
			return itReg;
		}else {
			return itReg;
		}
	}
	
	public void add (Items itm) {
		itemRecords.add(itm);
	}
	
	
	public String updateItem (Items itm) {
		for (int i = 0; i < itemRecords.size(); i++) {
			Items crrntItm = itemRecords.get(i);
			if(crrntItm.getId().equals(itm.getId())){
				itemRecords.set(i,itm);
				return "Successful!";
			}
		}
		return "error: item doesnt exist";
	}
	
	public String deleteItem (String regNum) {
		for (int i = 0; i < itemRecords.size(); i++) {
			Items crrntItm = itemRecords.get(i);
			if(crrntItm.getId().equals(regNum)){
				itemRecords.remove(i);
				return "Removed Successfully!";
			}
		}
		return "error: item doesnt exist";
	}
	
    public List<Items> getItemRecords() {	
    	return itemRecords;
    }
}
