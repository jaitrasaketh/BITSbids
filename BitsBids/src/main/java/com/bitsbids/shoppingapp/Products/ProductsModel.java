package com.bitsbids.shoppingapp.Products;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class ProductsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "rating")
    private double rating;

    @Column(name= "image")
    private String image;

    @Column(name= "details")
    private String details;

    @Column(name= "category")
    private String category;

    @Column(name = "noOfDaysForDelivery")
    private Long noOfDaysForDelivery;

    public Long getNoOfDaysForDelivery() {
        return noOfDaysForDelivery;
    }

    public void setNoOfDaysForDelivery(Long noOfDaysForDelivery) {
        this.noOfDaysForDelivery = noOfDaysForDelivery;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
}
