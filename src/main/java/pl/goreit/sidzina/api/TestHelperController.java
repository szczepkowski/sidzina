package pl.goreit.sidzina.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import pl.goreit.sidzina.domain.model.Offer;
import pl.goreit.sidzina.domain.model.Product;
import pl.goreit.sidzina.infrastructure.mongo.OfferRepo;
import pl.goreit.sidzina.infrastructure.mongo.ProductRepo;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/test")
@Profile("!prod")
public class TestHelperController {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OfferRepo offerRepo;

    @GetMapping("/addProduct/")
    @ApiOperation(value = "add 100 products")
    public void addProducts(@RequestParam("amount") Integer amount) {

        for (int count = 0; count < amount; count++) {
            Product product = new Product(UUID.randomUUID().toString(), "GoreWorkshop", "korepetycje", "Pomoc w programowaniu", BigDecimal.valueOf(150));
            productRepo.save(product);
        }
    }

    @PostMapping("/addOffers/")
    @ApiOperation(value = "add some offers")
    public void addOffers(@RequestParam("amount") Integer amount) {

        for (int i = 0; i < amount; i++) {
            Offer offer = new Offer(UUID.randomUUID().toString(), "testTitle" + i, "testDesc" + i, BigDecimal.valueOf(i));
            offerRepo.save(offer);
        }
    }

}
