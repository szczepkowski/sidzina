package pl.goreit.sidzina.domain.converter;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import pl.goreit.api.generated.auction_api.AuctionView;
import pl.goreit.api.generated.auction_api.CommentView;
import pl.goreit.sidzina.domain.model.Auction;

import java.util.stream.Collectors;

@Component
public class AuctionToAuctionViewConverter implements Converter<Auction, AuctionView> {

    private final ConversionService conversionService;

    @Lazy
    public AuctionToAuctionViewConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    public AuctionView convert(Auction auction) {
        return new AuctionView(auction.getTitle(),
                auction.getSellerId(),
                auction.getDescription(),
                auction.getPrice().toString(),
                auction.getComments().stream()
                        .map(comment -> conversionService.convert(comment, CommentView.class))
                        .collect(Collectors.toList()),
                auction.getStatus().name());
    }
}
