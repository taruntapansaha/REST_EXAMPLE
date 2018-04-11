package com.tarun.rest.webservices.restfulwebservice.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	MessageSource messageSource;
	
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

	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name="Accept-language") Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}

}
