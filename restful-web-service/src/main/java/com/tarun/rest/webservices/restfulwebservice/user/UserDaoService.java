package com.tarun.rest.webservices.restfulwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> userList = new ArrayList<>();
	private long userCount = 4;
	
	static {
		userList.add(new User(1L, "Lindsey Brook", new Date()));
		userList.add(new User(2L, "John Cena", new Date()));
		userList.add(new User(3L, "Tony Stark", new Date()));
		userList.add(new User(4L, "Alexia Texas", new Date()));
	}
	
 	public List<User> findAll(){
 		return userList;
 	}
 	
 	public User findById(Long id) {
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
	
 	public User deleteById(int id) {
 		Iterator<User> iterator = userList.iterator();
 		
 		while(iterator.hasNext()) {
 			User user = iterator.next();
 			if(user.getId() == id) {
 				iterator.remove();
 	 			return user;
 			}	
 		}
 		return null;
 	}
}
