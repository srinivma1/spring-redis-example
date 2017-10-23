/**
 * 
 */
package com.example.springredisexample;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springredisexample.entity.User;



/**
 * @author mahes
 *
 */
@RestController
@RequestMapping("/redis/users")
public class SpringRedisController {
	
	private UserService userService;
	
	public SpringRedisController(UserService userService) {
		super();
		this.userService= userService;
	}

	@GetMapping("/user/{id}/{name}")	
	public User addUser(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		userService.save(new User(id,name));
		return userService.getUserById(id);
	}
	
	
	@GetMapping("/user/{id}")	
	public User getUser(@PathVariable("id") final String id) {
		
		return userService.getUserById(id);
	}
}
