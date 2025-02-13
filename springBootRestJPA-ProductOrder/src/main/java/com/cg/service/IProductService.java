package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Product;

public interface IProductService 
{
   public List<Product> findAllProducts();
   public Optional<Product> findByProductId(int id);
   public List<Product> findProductByName(String name);
   public void deleteByProductId(int id);
 //  public void deleteByProductName(String pname);
   public Product newProduct(Product product);
   public Product updateTheProduct( int id,Product product);
}
