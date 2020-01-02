package com.HibernateSpringProto.server.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println(model.toString());
		System.out.println("---------------------------------------------------------------------------------------------------------");
        model.put("name", "in28Minutes");
        return "welcome";
    }

}