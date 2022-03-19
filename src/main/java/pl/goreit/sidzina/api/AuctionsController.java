package pl.goreit.sidzina.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.goreit.api.generated.auction_api.AuctionView;
import pl.goreit.api.generated.auction_api.CreateAuctionRequest;
import pl.goreit.sidzina.domain.DomainException;
import pl.goreit.sidzina.domain.service.AuctionService;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionsController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping()
    @ApiOperation(value = "pobiera produkty", notes = "pobiera produkty")
    public List<AuctionView> getAuctions() {
        return auctionService.findAll();
    }

    @GetMapping("/{title}")
    @ApiOperation(value = "pobiera produkty", notes = "pobiera produkty")
    public AuctionView getAuction(@PathVariable String title) throws DomainException {
        return auctionService.findByTitle(title);
    }


    @PostMapping("/add")
    @ApiOperation(value = "dodaje produkt", notes = "dodaje produkt")
    public AuctionView addAuction(@RequestBody CreateAuctionRequest request) {
        return auctionService.add(request);
    }

    @PostMapping("/comment")
    @ApiOperation(value = "Dodaje komentarz do produktu", notes = "dodaje komentarz")
    public AuctionView addComment(@RequestParam("userId") String userId,
                                  @RequestParam("title") String productTitle,
                                  @RequestParam("text") String text) throws DomainException {
        return auctionService.addComment(userId, productTitle, text);
    }

}
