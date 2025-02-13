package com.cg.controller;
import com.cg.entity.*;
import com.cg.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.IProductService;
import com.cg.service.ProductService;

@RestController            //Indicates that this class is a REST controller, meaning it will handle HTTP requests and return responses.
@RequestMapping("/papi")   //mapping at the controller level(If more than 1 controller have same endpoint name). Maps the base URL /papi to this controller. All endpoints in this controller will be prefixed with /papi
public class ProductController 
{
	@Autowired             // Injects an instance of IProductService into the controller. This allows the controller to use the service’s methods.
	IProductService productService ;
	
	@GetMapping("/hello")  //Maps the /hello endpoint to the show method
    public String show()
    {
	   return "hello SpringRest";
    }
	
	//Maps the /products endpoint to the getAllProducts method, which returns a list of Product objects in XML format.
	@GetMapping(path = "/product", produces = {MediaType.APPLICATION_JSON_VALUE})
	
	//@GetMapping(path="/product")       //Maps the /hello endpoint to the getAllProducts method
	public List<Product> getAllProducts()
	{
		return productService.findAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id) throws ResourceNotFoundException
	{
		return productService.findByProductId(id)
		                     .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
	}
	
	@GetMapping("/products/name/{pname}")
	public List<Product> getProductByName(@PathVariable String pname)
	{
		return productService.findProductByName(pname);
	}
	
	@GetMapping("/products")
	//http://localhost:9090/papi/products?pname=Mango
	public List<Product> getProductByName1(@RequestParam String pname)
	{
		return productService.findProductByName(pname);
	}
	
	@GetMapping("/getproducts")
	//http://localhost:9090/papi/products?pid=1
	public Optional<Product> getProductById1(@RequestParam int id)
	{
		return productService.findByProductId(id);
	}
	
	//-------------------Delete products by id---------@DeleteMapping-------------
	
	@DeleteMapping("/products/{id}")
	public void deleteProductById(@PathVariable int id)
	{
	 productService.deleteByProductId(id);
	}
	
//	@DeleteMapping("/products/name/{pname}")
//	public void deleteProductByName(@PathVariable String pname)
//	{
//		productService.deleteByProductName(pname);
//	}
	
	@PostMapping("/postproducts")
	public Product createProduct(@RequestBody Product product)
	{
		Product pr=productService.newProduct(product);
		return pr;
	}
	
	@PutMapping("/putproducts/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product)
	{
		Product pr =productService.findByProductId(id).get();
		return productService.updateTheProduct(id,product);
		
	}
}
