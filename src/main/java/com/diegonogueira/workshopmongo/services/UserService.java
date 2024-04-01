package com.diegonogueira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegonogueira.workshopmongo.domain.User;
import com.diegonogueira.workshopmongo.repository.UserRepository;
import com.diegonogueira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> optionalUser = repo.findById(id);
		User user = optionalUser.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		return user;
	}
}
