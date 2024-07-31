package com.example.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.domain.User;
import com.example.workshopmongo.dto.AuthorDTO;
import com.example.workshopmongo.dto.CommentDTO;
import com.example.workshopmongo.repository.PostRepository;
import com.example.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria),"teste1");
	    Post post2 = new Post(null, sdf.parse("23/03/2018"),  "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria) ,"teste2");

	    CommentDTO c1 = new CommentDTO("boa viagem Mano", sdf.parse("21/03/2018"), new AuthorDTO(alex));
	    CommentDTO c2 = new CommentDTO("aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
	    CommentDTO c3 = new CommentDTO("Tenha um otimo dia", sdf.parse("23/03/2018"), new AuthorDTO(alex));
	    
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
	    
	        
		postRepository.saveAll(Arrays.asList(post1,post2));
		maria.getPosts().addAll(Arrays.asList(post1,post2));
	

		userRepository.save(maria);

		
	}

}
