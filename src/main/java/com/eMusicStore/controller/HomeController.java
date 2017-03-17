package com.eMusicStore.controller;

import com.eMusicStore.dao.ProductDao;
import com.eMusicStore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

import java.util.List;

/**
 * Created by khyajubikram on 3/8/2017.
 */

@Controller
public class HomeController {

    //public Path path;

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model){
        System.out.println("here produc tlist!!!!!!!!!!!!!!");
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products",products);
        return "productList";
    }

    @RequestMapping("productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException {
        Product product = productDao.getProductById(productId);
        model.addAttribute(product);
        return "viewProduct";
    }

    @RequestMapping("admin")
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("admin/productInventory")
    public String productInventory(Model model){
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products",products);
        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        product.setProductCategory("instrument");
        product.setProductCondition("new");
        product.setProductStatus("active");
        model.addAttribute("product", product);
        System.out.println("inside add prodocut");
        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product){
        productDao.addProduct(product);
            /*System.out.println("Product id is : "+product.getProductId());
            MultipartFile productImage = product.getProductImage();
            String rootDirectory = request.getSession().getServletContext().getRealPath("/");
           */// path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images"+product.getProductId()+".png");

        /*if(productImage != null && !productImage.isEmpty()){
            try{
                productImage.transferTo(new File(path.toString()));
            }
            catch (Exception e){
                e.printStackTrace();
                throw  new RuntimeException("Product image loading failed!!!");
            }
        }*/
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id, Model model){
        productDao.deleteProduct(id);
        return ("redirect:/admin/productInventory");
    }

}
