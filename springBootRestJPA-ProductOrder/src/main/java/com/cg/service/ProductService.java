package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.entity.Product;
import com.cg.repository.ProductRepository;


@Service   //Indicates that this class is a service component in the Spring framework. It is a specialized form of the @Component annotation, used to define service layer beans
public class ProductService implements IProductService
{
	
	@Autowired
	ProductRepository productRepository;
	
    List<Product> productList= new ArrayList();
	@Override
	
	
	public List<Product> findAllProducts() 
	{
	    return productRepository.findAll();
	}
	@Override
	public Optional<Product> findByProductId(int id) {
		return productRepository.findById(id);
	}
	
	@Override
	public List<Product> findProductByName(String pname) {
		return productRepository.findByPname(pname);
	
	}
	@Override
	public void deleteByProductId(int id) 
	{
		productRepository.deleteById(id);
	}
//	@Override
//	public void deleteByProductName(String pname) 
//	{
//		productRepository.deleteByPname(pname);
//	}
	
	public Product newProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateTheProduct(int id,Product product)
	{
		Product p=productRepository.findById(id).get();
		p.setPname(product.getPname());
		p.setPrice(product.getPrice());
		return productRepository.save(p);
		 
		
		
		
	}
	
}
