package com.HibernateSpringProto.server.control;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HibernateSpringProto.server.model.Items;
import com.HibernateSpringProto.server.model.User;
import com.HibernateSpringProto.server.repository.ItemRepository;
import com.HibernateSpringProto.server.repository.UserRepository;
import com.HibernateSpringProto.server.responseModel.ItemReply;

@Controller
public class ItemRegistrationController {	
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private UserRepository UserRepository;
	
	@PostMapping("/register/item/")
	@ResponseBody
	public Object registerItem(
			//@RequestParam(name = "id") long id, 
			@RequestParam(name = "description") String name,
			@RequestParam(name ="value",required = false) Optional <Double> value, 
			@RequestParam(name ="active" ,required = false) Optional <String> active){
		System.out.println(name+"-"+value+"-"+active);				
		System.out.println("Registering student");
		
		Iterable it= UserRepository.findAll();
		User user = (User) it.iterator().next();
		
		Items newItem = new Items();
		//newItem.setId(id);
		newItem.setDescription(name);
		
		double valueDef = value.isPresent() ? value.get() : 0.0;
		
		newItem.setValue(valueDef);
		
		if(active.equals("no")) {
			newItem.setAvailable(0);
		}else {
			newItem.setAvailable(1);
		}
		newItem.setIdCreator(user);
		newItem.setDateCreation(Date.from(Instant.now()));
		
		itemRepository.save(newItem);
		
		return new ItemReply(
				newItem.getId().intValue(), 
				newItem.getDescription(), 
				active.get(), 
				newItem.getValue(), 
				newItem.getDateCreation(), 
				newItem.getIdCreator().getUsername());
	}
}