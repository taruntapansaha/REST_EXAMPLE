package com.tarun.rest.webservices.restfulwebservice.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
public class UserJpaResourceController {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepository;

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return repository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public Optional<User> findUserByID(@PathVariable long id) {
		Optional<User> user = repository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id " + id);
		}
		
		return user;
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveUserPosts(@PathVariable long id) {
		Optional<User> user = repository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("id " + id);
		}
		
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User savedUser = repository.save(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(savedUser.getId())
									.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable long id, @RequestBody Post post) {
		
		Optional<User> userOptional = repository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id -" + id);
		}
		User user = userOptional.get();
		
		post.setUser(user);
		postRepository.save(post);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
									.path("/{id}")
									.buildAndExpand(post.getId())
									.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
