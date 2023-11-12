package com.bitsbids.shoppingapp.Auction;

//AuctionController.java

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

 private final AuctionService auctionService;

 public AuctionController(AuctionService auctionService) {
     this.auctionService = auctionService;
 }

 @PostMapping
 public Auction createAuction(@RequestBody AuctionRequest auctionRequest) {
     return auctionService.createAuction(auctionRequest);
 }

 @PostMapping("/{auctionId}/bids")
 public Bid placeBid(@PathVariable Long auctionId, @RequestBody BidRequest bidRequest) {
     return auctionService.placeBid(auctionId, bidRequest);
 }

 @GetMapping("/{auctionId}")
 public Auction getAuction(@PathVariable Long auctionId) {
     return auctionService.getAuction(auctionId);
 }
}

