package com.example.workshopmongo.repository;

import java.util.Date;
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
	/* busca range de data e text ( and e or )*/
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	

}	
