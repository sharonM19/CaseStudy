package com.target.myRestfulWebservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.target.myRestfulWebservice.model.Product;
import com.target.myRestfulWebservice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product getProductById(String id) {
		return productRepository.findById(id);
	}

}
