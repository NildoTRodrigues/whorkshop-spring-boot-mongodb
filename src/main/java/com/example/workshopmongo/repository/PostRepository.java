package com.example.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String>{
	
	@Query("{ 'title': {$regex: ?0 , $options:'i' }  }" )
	/* ?0 eh o primeiro parametro abaixo, ou seja o  --> text*/
	/* $options:'i'  parametro para case sensitive */
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text );

}	
