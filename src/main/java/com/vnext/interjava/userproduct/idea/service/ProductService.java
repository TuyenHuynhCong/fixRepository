package com.vnext.interjava.userproduct.idea.service;
import com.vnext.interjava.userproduct.idea.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService  {

    List<Product> getAllProduct();
    void saveProduct(Product product);
    void deleteProduct(Long id);
    Optional<Product> findProductById(Long id);
   // public List<Product> findUserContact(Long id, String search);
   // public List<Product> search(String keyword);
  // Iterable<Product> listProductByNameproduct(String nameproduct);
//   List<Product> search(@Param("keyword") String keyword);

    List<Product> search(String q);

}
