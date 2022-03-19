package pl.goreit.sidzina.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import pl.goreit.api.generated.auction_api.AuctionView;
import pl.goreit.api.generated.auction_api.CreateAuctionRequest;
import pl.goreit.sidzina.domain.DomainException;
import pl.goreit.sidzina.domain.ExceptionCode;
import pl.goreit.sidzina.domain.model.Comment;
import pl.goreit.sidzina.domain.model.Auction;
import pl.goreit.sidzina.infrastructure.mongo.AuctionRepo;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuctionService {

    @Autowired
    private ConversionService sellConversionService;

    @Autowired
    private AuctionRepo auctionRepo;

    public List<AuctionView> findAll() {

        List<Auction> auctions = auctionRepo.findAll();
        return auctions.stream()
                .map(auction -> sellConversionService.convert(auction, AuctionView.class))
                .collect(Collectors.toList());
    }

    public AuctionView findByTitle(String title) throws DomainException {

        Optional<Auction> auctionOptional = auctionRepo.findByTitle(title);
        Auction auction = auctionOptional.orElseThrow(() -> new DomainException(ExceptionCode.AUCTION_NOT_EXIST));

        return sellConversionService.convert(auction, AuctionView.class);
    }

    public AuctionView add(CreateAuctionRequest request) {

//        KeycloakAuthenticationToken authentication = (KeycloakAuthenticationToken)
//                SecurityContextHolder.getContext().getAuthentication();

//        String sellerId = authentication.getName();

        //@FIXME allow add photo album to auction
        int random = ThreadLocalRandom.current().nextInt(0, 1000);

        Auction auction = new Auction(UUID.randomUUID().toString(), request.getTitle() + "_" + random, request.getText(),
                request.getPrice(),request.getSellerId() );
        auctionRepo.save(auction);

        return sellConversionService.convert(auction, AuctionView.class);
    }

    public AuctionView addComment(String userId, String productTitle, String text) throws DomainException {
        Auction product = auctionRepo.findByTitle(productTitle).orElseThrow(() -> new DomainException(ExceptionCode.AUCTION_NOT_EXIST));

        Integer sequenceNo = 0;
        if (product.getComments().size() > 0) {
            sequenceNo = product.getComments()
                    .get(product.getComments().size() - 1)
                    .getSequenceNo();
        }

        product.addComment(new Comment(sequenceNo + 1, userId, text));
        Auction saved = auctionRepo.save(product);
        return sellConversionService.convert(saved, AuctionView.class);
    }

}
