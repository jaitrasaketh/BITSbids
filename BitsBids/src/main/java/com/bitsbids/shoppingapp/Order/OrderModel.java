package com.bitsbids.shoppingapp.Order;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

class OrderedProducts {
   private Long productId;
   private Long quantity;
   private Long priceAtPurchase;
   
   public Long getPriceAtPurchase() {
      return priceAtPurchase;
   }
   
   public void setPriceAtPurchase(Long priceAtPurchase) {
      this.priceAtPurchase = priceAtPurchase;
   }
   
   public Long getProductId() {
      return productId;
   }
   
   public void setProductId(Long productId) {
      this.productId = productId;
   }
   
   public Long getQuantity() {
      return quantity;
   }
   
   public void setQuantity(Long quantity) {
      this.quantity = quantity;
   }
}

class Items {
   //Array of ordered Products
   private OrderedProducts[] orderedProducts;

   public OrderedProducts[] getOrderedProducts() {
      return orderedProducts;
   }

   public void setOrderedProducts(OrderedProducts[] orderedProducts) {
      this.orderedProducts = orderedProducts;
   }
}


@Entity
@Table(name = "orders")
@TypeDef(
    name = "json",
    typeClass = JsonStringType.class
)
public class OrderModel {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "orderId")
   private Long orderId;

   @Type(type = "json")
   @Column(name = "items", columnDefinition = "json")
   private Items items;

   @Column(name = "cost")
   private Long cost;

   @Column(name = "buyerId")
   private Long buyerId;

   @Column(name = "date")
   private Date date;

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   @Column(name = "err")
   private String err;

   @Column(name = "status")
   private Boolean status;

   @Column(name = "noOfDaysForDelivery")
   private Long noOfDaysForDelivery;

   public Long getNoOfDaysForDelivery() {
      return noOfDaysForDelivery;
   }

   public void setNoOfDaysForDelivery(Long noOfDaysForDelivery) {
      this.noOfDaysForDelivery = noOfDaysForDelivery;
   }

   public Boolean getStatus() {
      return status;
   }

   public void setStatus(Boolean status) {
      this.status = status;
   }

   public String getErr() {
      return err;
   }

   public void setErr(String err) {
      this.err = err;
   }

   public Long getOrderId() {
      return orderId;
   }

   public void setOrderId(Long orderId) {
      this.orderId = orderId;
   }

   public Items getItems() {
      return items;
   }

   public void setItems(Items items) {
      this.items = items;
   }

   public Long getCost() {
      return cost;
   }

   public void setCost(Long cost) {
      this.cost = cost;
   }

   public Long getBuyerId() {
      return buyerId;
   }

   public void setBuyerId(Long buyerId) {
      this.buyerId = buyerId;
   }
}
