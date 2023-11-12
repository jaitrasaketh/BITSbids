package com.bitsbids.shoppingapp.Auction;

//Bid.java

import jakarta.persistence.*;

@Entity
public class Bid {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private double amount;

 @ManyToOne
 private Auction auction;

 // getters and setters
}

