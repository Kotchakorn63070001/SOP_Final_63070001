package com.example.sop_final_63070001.repository;

import com.example.sop_final_63070001.pojo.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
