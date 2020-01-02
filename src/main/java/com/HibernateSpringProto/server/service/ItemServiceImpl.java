package com.HibernateSpringProto.server.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HibernateSpringProto.server.model.Items;
import com.HibernateSpringProto.server.model.User;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private com.HibernateSpringProto.server.repository.ItemRepository ItemRepository;

	public List<String> getAllItems(long teamId) {
		
		List <Items> items = ItemRepository.findByid(teamId);
		for (Items item : items) {
			System.out.println(item.getDescription());
		}
		return null;
	}
	
	public void addItem (long id, String desc, double value, boolean available, User idCreator, Date CreationDate) {
		
		System.out.println("INSERTANDO COUSAS");
		System.out.println(id+"-"+desc+"-"+value+"-"+available+"-"+idCreator+"-"+CreationDate);		
		
		Items newItem = new Items();
		newItem.setId(id);
		newItem.setDescription(desc);
		newItem.setValue(value);
		if(available) {
			newItem.setAvailable(1);
		}else {
			newItem.setAvailable(0);
		}
		//newItem.setUser(idCreator);
		newItem.setDateCreation(CreationDate);
		
		ItemRepository.save(newItem);
		
		System.out.println("INSERTED STUFF");
	}
}
