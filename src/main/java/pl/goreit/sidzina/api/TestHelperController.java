package pl.goreit.sidzina.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import pl.goreit.api.generated.auction_api.CreateAuctionRequest;
import pl.goreit.api.generated.offers.OfferView;
import pl.goreit.sidzina.domain.model.Offer;
import pl.goreit.sidzina.domain.model.Auction;
import pl.goreit.sidzina.domain.service.AuctionService;
import pl.goreit.sidzina.domain.service.OfferService;
import pl.goreit.sidzina.infrastructure.mongo.OfferRepo;
import pl.goreit.sidzina.infrastructure.mongo.AuctionRepo;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/test")
@Profile("!prod")
public class TestHelperController {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private OfferService offerService;

    @GetMapping("/addAcutions/")
    @ApiOperation(value = "add 100 products")
    public void addAuctions(@RequestParam("amount") Integer amount) {

        for (int count = 0; count < amount; count++) {
            CreateAuctionRequest createAuctionRequest = new CreateAuctionRequest("Macbook PRO 13' 8GB ", "Nowa Macbook PRO", BigDecimal.valueOf(4799), "admin");
            auctionService.add(createAuctionRequest);
        }
    }

    @PostMapping("/addOffers/")
    @ApiOperation(value = "add some offers")
    public void addOffers(@RequestParam("amount") Integer amount) {

        for (int i = 0; i < amount; i++) {
            OfferView offerView = new OfferView("testTitle" + i, "testDesc" + i, BigDecimal.valueOf(i), "admin");
            offerService.add(offerView);
        }
    }

}
