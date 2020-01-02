package com.HibernateSpringProto.server.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.HibernateSpringProto.server.model.User;
import com.HibernateSpringProto.server.repository.UserRepository;

@Component(value = "userDetailService")
public class UserDetailServiceImpl implements UserDetailsService, UserService{
	
	@Autowired
	private UserRepository userDao;

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Iterable<User>users = userDao.findAll();
		User userSel = null;
		
		System.out.println("users");		
		for (User user : users) {
			System.out.println(user.getUsername()+"---"+email);
			if(user.getUsername().equals(email)) {
				userSel = user;
			}
		}
		if(userSel == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(String.valueOf(userSel.getId()), userSel.getPassword(), getAuthority());
	}

	private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	public List getUsers() {
		
		List <User> allUsers = new ArrayList<User>();
		Iterable <User> iterableUsers = userDao.findAll();
		
		for (User user : iterableUsers) {
			allUsers.add(user);
		}
		
		return allUsers;
	}

}