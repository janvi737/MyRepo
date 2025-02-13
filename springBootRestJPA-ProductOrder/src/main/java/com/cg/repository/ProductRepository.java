package com.cg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
    public List<Product> findByPname(String pname);
    public void deleteByPname(String pname);
    
    @Query("SELECT COUNT(p) FROM Product p WHERE p.pname = :pname")
    		Long countByProductName(String pname);
}
