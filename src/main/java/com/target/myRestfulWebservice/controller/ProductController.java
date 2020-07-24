package com.target.myRestfulWebservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.myRestfulWebservice.model.Product;
import com.target.myRestfulWebservice.service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
     @GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable(value="productId") String id) {
    	 Product product= null;
    	 try {
    		 
			Product jsonProduct = getJSONResponse(id);
			product = productService.getProductById(id);
			product.setProductId(jsonProduct.getProductId());
	 		product.setProductName(jsonProduct.getProductName());
	 		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	 
 		return product;
	}
	
	
     
	private static Product getJSONResponse(String id) throws Exception {
		
		Product product = new Product();
		String url = "https://redsky.target.com/v2/pdp/tcin/" + id
			+ "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
		
	
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		
		
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		HttpStatus responseCode = response.getStatusCode();
		try {
			Map<String, Map> map = mapper.readValue(response.getBody(), Map.class); 
			Map<String, Map> productMap = map.get("product");
			Map<String, Map> itemMap = productMap.get("item"); 
			Map<String, String> itemMapString = productMap.get("item"); 
			Map<String, String> productDescriptionMap = itemMap.get("product_description");

			if (responseCode == HttpStatus.OK) {
				product.setProductId(itemMapString.get("tcin"));
				product.setProductName(productDescriptionMap.get("title"));
			}
		  } catch (Exception e) {
			System.out.println(responseCode);
		    }
	    
		return product;
	}

}
