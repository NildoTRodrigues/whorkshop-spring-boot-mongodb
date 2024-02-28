package com.example.workshopmongo.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.domain.services.exception.ObjectNotFoundException;
import com.example.workshopmongo.dto.UserDTO;
import com.example.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}

	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
    public User insert(User obj) {
    	
        return repo.insert(obj);
    	
    }
    
    
    public void delete(String id) {
    	findById(id);
    	repo.deleteById(id);
    }
    
    
    public User fromDTO(UserDTO objdto) {
    	
    	return new User(objdto.getId(), objdto.getName(), objdto.getEmail());
    	
    }



}
