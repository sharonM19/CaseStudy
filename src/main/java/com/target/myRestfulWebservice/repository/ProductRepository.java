package com.target.myRestfulWebservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.target.myRestfulWebservice.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	
	Product findByid(@Param("id") String id);
 
}
	


