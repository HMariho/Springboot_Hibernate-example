package com.HibernateSpringProto.server.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HibernateSpringProto.server.DAO.ItemResponseFactory;
import com.HibernateSpringProto.server.model.Items;
import com.HibernateSpringProto.server.repository.ItemRepository;


@RestController
@RequestMapping(path = "/item")

//@Controller
public class ItemRetrieveController {
	
  @Autowired
  private ItemRepository itemRepository;
 
  @GetMapping(path="/allItems", produces = "application/json")
  public List<Items> getAllitems(){
	  ItemResponseFactory itemFactory = new ItemResponseFactory();
	  return itemFactory.listItems(itemRepository.findAll());
	  
  }  
}
