package com.vnext.interjava.userproduct.idea.repository;

import com.vnext.interjava.userproduct.idea.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

            List<Product> findByNameContaining(String q);


}
