package com.HibernateSpringProto.server.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.HibernateSpringProto.server.model.User;
import com.HibernateSpringProto.server.repository.UserRepository;

@RestController
public class UserController {

	private UserRepository usuarioRepository;

	@RequestMapping(path="/user", method = RequestMethod.GET)
		public ResponseEntity listUser(){
			//return new ResponseEntit>(getUsers(), HttpStatus.OK);
			return null;	
		}

	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity listUser(@PathVariable(value = "id") String id) {
		//return new ResponseEntity(getUsers().stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null),HttpStatus.OK);
		return null;
	}

	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public ResponseEntity listUser(@RequestBody User user) {
		return new ResponseEntity("18", HttpStatus.OK);
	}

	@RequestMapping(value = "/logmeout", method = RequestMethod.POST)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}
}