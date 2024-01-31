package com.example.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    /*Opcional GetMapping*/
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<User>> buscaTodosUser() {
	
		User usr1 = new User("1", "Maria Silva", "maria@gmail.com");
		User usr2 = new User("2", "Alex Silva", "alex@gmail.com");
		List<User> list = new ArrayList<>(); 
		list.addAll(Arrays.asList(usr1,usr2));
		return ResponseEntity.ok().body(list);
		
	};
}
		