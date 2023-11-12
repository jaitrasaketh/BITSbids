package com.bitsbids.shoppingapp.Auction;

//AuctionService.java

import java.util.List;

public interface AuctionService {
 Auction createAuction(AuctionRequest auctionRequest);

 Bid placeBid(Long auctionId, BidRequest bidRequest);

 Auction getAuction(Long auctionId);
}
