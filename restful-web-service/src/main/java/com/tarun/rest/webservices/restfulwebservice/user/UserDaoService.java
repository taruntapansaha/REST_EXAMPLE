package com.tarun.rest.webservices.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> userList = new ArrayList<>();
	private int userCount = 4;
	
	static {
		userList.add(new User(1, "Lindsey Brook", new Date()));
		userList.add(new User(2, "John Cena", new Date()));
		userList.add(new User(3, "Tony Stark", new Date()));
		userList.add(new User(4, "Alexia Texas", new Date()));
	}
	
 	public List<User> findAll(){
 		return userList;
 	}
 	
 	public User findById(int id) {
 		for(User user: userList) {
 			if(user.getId() == id) {
 				return user;
 			}
 		}
 		return null;
 	}
 	
 	public User addUser(User user) {
 		
 		if(user.getId() == null) {
 			user.setId(++userCount);
 		}
 		userList.add(user);
 		return user;
 	}
	
}
