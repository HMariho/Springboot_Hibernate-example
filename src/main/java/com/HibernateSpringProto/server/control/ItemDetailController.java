package com.HibernateSpringProto.server.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HibernateSpringProto.server.DAO.ItemResponseFactory;
import com.HibernateSpringProto.server.repository.ItemRepository;
import com.HibernateSpringProto.server.responseModel.ItemDetailReply;

@RestController
@RequestMapping(path = "/item")

//@Controller
public class ItemDetailController {
	
  @Autowired
  private ItemRepository itemRepository;
  
  @GetMapping("/detail")
	public ItemDetailReply detail(@RequestParam("id") String id)
	{
	  ItemResponseFactory itemResponseFactory = new ItemResponseFactory();	  
	  return itemResponseFactory.getItemDetail(itemRepository.findAll(), id);
	}
}
