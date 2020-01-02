package com.HibernateSpringProto.server.control;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HibernateSpringProto.server.model.Deactivation;
import com.HibernateSpringProto.server.model.Items;
import com.HibernateSpringProto.server.model.PriceReduction;
import com.HibernateSpringProto.server.model.Supplier;
import com.HibernateSpringProto.server.model.User;
import com.HibernateSpringProto.server.repository.DeactivationRepository;
import com.HibernateSpringProto.server.repository.ItemRepository;
import com.HibernateSpringProto.server.repository.SupplierRepository;
import com.HibernateSpringProto.server.repository.UserRepository;
import com.HibernateSpringProto.server.responseModel.ItemDetailReply;
import com.HibernateSpringProto.server.responseModel.ItemReply;

@Controller
public class ItemEditionController {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private DeactivationRepository DeactivationRepository;

	@PostMapping("/edit/item/")
	@ResponseBody
	public ItemReply EditItem(@RequestParam(name = "id") long id,
			@RequestParam(name = "description", required = false) Optional<String> name,
			@RequestParam(name = "value", required = false) Optional<Double> value) {

		Iterable it = UserRepository.findAll();
		User user = (User) it.iterator().next();

		Items newItem = itemRepository.findByid(id).get(0);

		String nameDef = name.isPresent() ? name.get() : newItem.getDescription();
		double valueDef = value.isPresent() ? value.get() : 0.0;

		newItem.setDescription(nameDef);
		newItem.setValue(valueDef);

		newItem.setAvailable(1);
		
		/*if (active.equals("no") && active.isPresent()) {
			newItem.setAvailable(0);
		} else {
			newItem.setAvailable(1);
		}*/

		itemRepository.save(newItem);

		return new ItemReply(newItem.getId().intValue(), newItem.getDescription(),"1", newItem.getValue(),
				newItem.getDateCreation(), newItem.getIdCreator().getUsername());
	}

	
	
	@PostMapping("/edit/item/suppliers")
	@ResponseBody
	public Object UpdateSuppliers(
			@RequestParam(name = "idItem") long id,
			@RequestParam(name = "idSupplier") long idSupplier,
			@RequestParam(name = "action") String mode) {

		Optional<Items> item = itemRepository.findById(id);
		Supplier supplier = supplierRepository.findByid(idSupplier).get(0);
		
		boolean supplierFound = false;
		Supplier itemSupplier =  null;
		
		for (Supplier supplierAct : item.get().getSuppliers()) {
			if(supplierAct.getId() == idSupplier) {
				supplierFound = true;
				itemSupplier = supplierAct;
			}
		}
		
		if (mode.equals("add") && item.isPresent() && !supplierFound) {
			item.get().getSuppliers().add(supplier);
			itemRepository.save(item.get());
			
		}else if (
				mode.equals("remove") && 
				item.isPresent() && 
				supplierFound) {
			
			item.get().getSuppliers().remove(itemSupplier);
			itemRepository.save(item.get());
		}else {
			return "Error in parameters:";
		}
		
		
		 return new ItemDetailReply(
				 			item.get().getId().intValue(), 
							item.get().getDescription(), 
							item.get().getAvailable()==1 ? "Available": "not Available", 
							item.get().getValue(), 
							item.get().getDateCreation(), 
							item.get().getIdCreator().getUsername(), 
							item.get().getSuppliers(), 
							item.get().getPriceReduction());
	}
	
	@PostMapping("/edit/item/newDiscount")
	@ResponseBody
	public Object UpdateDiscounts (
			@RequestParam(name = "idItem") long id,
			@RequestParam(name = "value") double value,
			@RequestParam(name = "startDate") String startDate,
			@RequestParam(name = "endDate") String endDate) throws ParseException {
		
		Optional<Items> item = itemRepository.findById(id);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date date = sdf1.parse(startDate);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
		date = sdf1.parse(endDate);
		java.sql.Date sqlEndDate = new java.sql.Date(date.getTime()); 
		
		PriceReduction discount = new PriceReduction();
		discount.setIdItem(item.get());
		discount.setStartDate(sqlStartDate);
		discount.setEndDate(sqlEndDate);
		
		
		item.get().getPriceReduction().add(discount);
		
		itemRepository.save(item.get());				
		
		return new ItemDetailReply(
	 			item.get().getId().intValue(), 
				item.get().getDescription(), 
				item.get().getAvailable()==1 ? "Available": "not Available", 
				item.get().getValue(), 
				item.get().getDateCreation(), 
				item.get().getIdCreator().getUsername(), 
				item.get().getSuppliers(), 
				item.get().getPriceReduction());
	}
	
	@PostMapping("/edit/item/deactivate")
	@ResponseBody
	public Object Deactivate(
			@RequestParam(name = "idItem") long id,
			@RequestParam(name = "reason") String reason){
		
		Optional <Items> item = itemRepository.findById(id);
		
		Deactivation nwDeactivation = new Deactivation();
		
		Iterable it= UserRepository.findAll();
		User user = (User) it.iterator().next();
		
		if(item.isPresent()) {
			nwDeactivation.setItemId(item.get());
			nwDeactivation.setReason(reason);
			nwDeactivation.setDate((Date.from(Instant.now())));
			nwDeactivation.setUserId(user);
		}
		
		
		item.get().setAvailable(0);
		DeactivationRepository.save(nwDeactivation);
				
		return nwDeactivation;
		
	}
}