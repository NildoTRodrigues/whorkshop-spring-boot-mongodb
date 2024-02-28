package com.example.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.domain.services.UserService;
import com.example.workshopmongo.dto.UserDTO;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    @Autowired
	private UserService service;
    /*Opcional GetMapping*/
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity< List<UserDTO> > buscaTodosUser() {
		List<User> list = service.findAll();
		/*List<UserDTO> listDTO = list.stream().map( x -> new listDTO(x)).collect(Collectors.toList());*/
		List<UserDTO> listDTO = list.stream().map( x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	};
	
	@RequestMapping(value="/{id}" , method = RequestMethod.GET)
	public ResponseEntity< UserDTO > buscaUmUser(@PathVariable String id) {
		User obj = service.findById(id);
		
		return ResponseEntity.ok().body( new UserDTO(obj) );
		
	};
	
}
		