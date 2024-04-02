package com.diegonogueira.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegonogueira.workshopmongo.domain.Post;
import com.diegonogueira.workshopmongo.repository.PostRepository;
import com.diegonogueira.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> optionalUser = repo.findById(id);
		Post post = optionalUser.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		
		return post;
	}
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
}
