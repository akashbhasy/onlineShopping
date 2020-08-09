package com.akash.myproject.OnlineShopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.myproject.OnlineShopping.entity.Product;
import com.akash.myproject.OnlineShopping.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveproduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products){
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String Name) {
		return repository.findByName(Name);
	}
	public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }
	
	public Product upateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
		
	}

}
