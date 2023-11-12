package com.bitsbids.shoppingapp.Auction;

//Auction.java

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Auction {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private double basePrice;

 private double bidIncrement;

 private long timer;

 private double currentPrice;

 private boolean active;

 @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
 private List<Bid> bids = new ArrayList<>();

 // getters and setters
}
