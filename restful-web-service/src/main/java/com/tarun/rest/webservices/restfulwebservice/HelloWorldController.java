package com.tarun.rest.webservices.restfulwebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
//	@RequestMapping(method = RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloworld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World From the Bean!! ");
	}
	
	@GetMapping(path="/hello-world/path-variable/{title}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String title) {
		return new HelloWorldBean(String.format("Hello World, %s", title));
	}


}
