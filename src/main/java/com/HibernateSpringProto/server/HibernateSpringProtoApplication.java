package com.HibernateSpringProto.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.HibernateSpringProto.server.service.ItemService;


@SpringBootApplication
public class HibernateSpringProtoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HibernateSpringProtoApplication.class, args);
	}
		
	@Autowired
	ItemService itemService;
	
    public void run(String... arg0) throws Exception {
    	System.out.println("VAMO ALLA");
        /*itemService.addItem(1, "El libro rojo de Darth Maul", 0.60 , true);
        itemService.getAllItems(1);*/
    }
}
