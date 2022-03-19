package pl.goreit.sidzina.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.goreit.api.generated.offers.OfferView;
import pl.goreit.sidzina.domain.DomainException;
import pl.goreit.sidzina.domain.service.OfferService;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    @ApiOperation(value = "pobiera oferty uzytkownika ")
    public List<OfferView> getAvailableOffers() {
        return offerService.findAll();
    }

    @GetMapping("/{title}")
    @ApiOperation(value = "pobiera 1 oferte po title ")
    public OfferView findOneByTitle(@PathVariable String title) throws DomainException {
        return offerService.findByTitle(title);
    }

    @PostMapping
    @ApiOperation(value = "dodaje oferte uzytkownika ")
    public OfferView addOffer(@RequestBody OfferView offerView) {
        OfferView add = offerService.add(offerView);
        return add;
    }
}
