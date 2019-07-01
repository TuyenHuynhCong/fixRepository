package com.vnext.interjava.userproduct.idea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.vnext.interjava.userproduct.idea.entity.Product;
import com.vnext.interjava.userproduct.idea.repository.ProductRepository;
import com.vnext.interjava.userproduct.idea.service.ProductService;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired private ProductRepository productRepository;
    @Autowired private JdbcTemplate jdbcTemplate;

   // @Autowired private HomeController.ProductRowMaapper productRowMaapper;
    @Autowired
    DataSource datasource;
    @Override
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
             productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
            productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findProductById(Long id) {

        return productRepository.findById(id);
    }

    @Override
    public List<Product> search(String q) {
        return productRepository.findByNameContaining(q);
    }



//    @Override
//    public List<Product> search(String keywork) {
//        return productRepository.findByName(keywork);
//    }

//    @Override
//    public Iterable<Product> listProductByNameproduct(String nameproduct) {
//        return productRepository.findByProduct(nameproduct);
//    }

//    @Override
//    public List<Product> search(String keyword) {
//        SessionFactory sessionFactory = null;
//        Session session = sessionFactory.getCurrentSession();
//        FullTextSession fullTextSession = Search.getFullTextSession(session);
//        QueryBuilder qb = fullTextSession.getSearchFactory()
//                .buildQueryBuilder().forEntity(Product.class).get();
//        org.apache.lucene.search.Query query = qb
//                .keyword().onFields("nameproduct", "nhacungcap", "soluong", "gia")
//                .matching(keyword)
//                .createQuery();
//        org.hibernate.Query hibQuery =
//                fullTextSession.createFullTextQuery(query, Product.class);
//        List<Product> results = hibQuery.list();
//        return results;



//    @Override
//    public List<Product> findUserContact(Long id, String search, ModelMap modelMap ) {
////        String sql = "SELECT nameproduct, nhacungcap FROM product WHERE id=? AND (nameproduct LIKE '%"+search+"%' OR nhacungcap LIKE '%"+search+"%')";
////        return getJdbcTemplate().query(sql, new ContactRowMapper(),userId);
////        return jdbcTemplate.query(sql, new Object[] {id,search}, HomeController.ProductRowMaapper());
//        List<Product> products = jdbcTemplate.query("select * from product" +
//                " where id =? and nameproduct like '%"+search+"%' OR nhacungcap like '%"+search+"%' ", new Object[] {id, search},new  HomeController.ProductRowMaapper());
//
//    }

}
