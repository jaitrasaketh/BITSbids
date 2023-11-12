package com.bitsbids.shoppingapp.Products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    ProductsService productsService;

    @PostMapping("/add")
    public ProductsModel createProduct(@RequestBody ProductsModel product){
        return productsService.createProduct(product);
    }

    @PostMapping("/update")
    public ProductsModel updateProduct(@RequestBody ProductsModel product){
        return productsService.updateProduct(product.getProductId(), product);
    }

    @GetMapping("/list")
    public List<ProductsModel> listProducts(){
        return productsService.getProducts();
    }

    @GetMapping("/listByCategory")
    public List<ProductsModel> listProductsByCategory(@RequestParam String category){
        return productsService.getProductsByCategory(category);
    }

    @DeleteMapping("/delete")
    public Boolean deleteProduct(@RequestParam Long productId){
        try{
            productsService.deleteProduct(productId);
            return true;
        }catch(Exception e){
            System.out.println("Couldn't Delete Product");
            return false;
        }
    }
}