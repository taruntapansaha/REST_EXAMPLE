package com.tarun.rest.webservices.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResourceController {

	@Autowired
	private UserDaoService theService;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return theService.findAll();
	}

	@GetMapping("/users/{id}")
	public User findUserByID(@PathVariable int id) {
		User user = theService.findById(id);
		
		if(user==null) {
			throw new UserNotFoundException("id " + id);
		}
		
		return user;

	}

	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User savedUser = theService.addUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(savedUser.getId())
									.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User deletedUser = theService.deleteById(id);
		
		if(deletedUser==null) {
			throw new UserNotFoundException("Invalid ID");
		}
	}
}
