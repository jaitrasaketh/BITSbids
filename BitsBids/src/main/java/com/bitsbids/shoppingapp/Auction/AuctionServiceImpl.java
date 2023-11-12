package com.bitsbids.shoppingapp.Auction;


//AuctionServiceImpl.java

import org.springframework.stereotype.Service;

@Service
public class AuctionServiceImpl implements AuctionService {

 private final AuctionRepository auctionRepository;

 public AuctionServiceImpl(AuctionRepository auctionRepository) {
     this.auctionRepository = auctionRepository;
 }

 @Override
 public Auction createAuction(AuctionRequest auctionRequest) {
     Auction auction = new Auction(auctionRequest.getBasePrice(), auctionRequest.getBidIncrement(), auctionRequest.getTimer());
     return auctionRepository.save(auction);
 }

 @Override
 public Bid placeBid(Long auctionId, BidRequest bidRequest) {
     Auction auction = auctionRepository.findById(auctionId)
             .orElseThrow(() -> new NotFoundException("Auction not found"));

     if (!auction.isActive()) {
         throw new AuctionNotActiveException("Auction is not active");
     }

     if (bidRequest.getAmount() < auction.getCurrentPrice() + auction.getBidIncrement()) {
         throw new InvalidBidAmountException("Bid amount is too low");
     }

     Bid bid = new Bid(bidRequest.getAmount(), auction);
     auction.getBids().add(bid);
     auction.setCurrentPrice(bidRequest.getAmount());
     auctionRepository.save(auction);

     return bid;
 }

 @Override
 public Auction getAuction(Long auctionId) {
     return auctionRepository.findById(auctionId)
             .orElseThrow(() -> new NotFoundException("Auction not found"));
 }
}

