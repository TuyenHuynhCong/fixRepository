package com.vnext.interjava.userproduct.idea.controller;

import com.vnext.interjava.userproduct.idea.entity.Product;
import com.vnext.interjava.userproduct.idea.service.ProductService;
import com.vnext.interjava.userproduct.idea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.vnext.interjava.userproduct.idea.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    //private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;


//    @RequestMapping(value={"/"}, method = RequestMethod.GET)
//    public String init(){
//        return "login" ;
//    }

    // log out
    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logout() {
        return "login";
    }

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String admin(Model model) {

        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "admin";
    }

    // show all product
    @RequestMapping("/index")
    public String index(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "index";
    }


    // add product
    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    //save product
    @RequestMapping(value = "saveProduct", method = RequestMethod.POST)
    public String saveProduct(Product product) {

        productService.saveProduct(product);
        return "redirect:/index";
    }


    // edit product
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editProduct(@RequestParam("id") Long productId, Model model) {
        Optional<Product> productEdit = productService.findProductById(productId);

        productEdit.ifPresent(product -> model.addAttribute("product", product));
        return "editProduct";
    }


    // delete product
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteProduct(@RequestParam("id") Long productId, Model model) {

        productService.deleteProduct(productId);
        return "redirect:/index";
    }

    // delete product from Admin
    @RequestMapping(value = "/deleteFromAdmin", method = RequestMethod.GET)
    public String deleteProductFromAdmin(@RequestParam("id") Long productId, Model model) {

        productService.deleteProduct(productId);
        return "redirect:/admin";
    }

    // tim kiem
//    @RequestMapping("/searchproduct")
//    public String searchproduct(@RequestParam String nameproduct,Model model)
//    {
//        Iterable<Product> products = productRepository.findByName(nameproduct);
//        model.addAttribute("products", products);
//        return "index";
//    }
    // tim kiem
//       @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public String showProductbyName(@RequestParam (value = "nameproduct", required = false) String nameproduct, Model model) {
//        model.addAttribute("search", productRepository.findByProduct(nameproduct));
//
//        return "index";
//    }
//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public String search(@RequestParam("keyword") String keyword, Model model) {
//        if (keyword.equals("")) {
//            return "redirect:/admin"; //demo
//        }
//
//        model.addAttribute("product", productService.search(keyword));
//        return "index";
//    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("q") String s, Model model) {
        List<Product> productList= productService.search(s);
        model.addAttribute("products",productList);

        return "index";
    }


//    public class ProductRowMaapper implements RowMapper<Product> {
//        @Override
//        public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//
//
//            Product product = new Product();
//           // product.id = resultSet.getLong("id");
//            product.nameproduct = resultSet.getString("nameproduct");
//            product.nhacungcap = resultSet.getString("nhacungcap");
//
//           // product.nhacungcap = resultSet.getString("nhacungcap");
//            //user.role = resultSet.getInt("role");
//            return product;
//        }
//    }


}
