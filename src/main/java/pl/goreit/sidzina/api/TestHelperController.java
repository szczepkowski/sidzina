package pl.goreit.sidzina.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.goreit.sidzina.domain.model.Product;
import pl.goreit.sidzina.infrastructure.mongo.ProductRepo;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/test")
@Profile("!prod")
public class TestHelperController {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/addProduct/")
    @ApiOperation(value = "add 100 products")
    public void addProducts(@RequestParam("amount") Integer amount) {

        for (int count = 0; count < amount; count++) {
            Product product = new Product(UUID.randomUUID().toString(), "GoreWorkshop", "korepetycje", "Pomoc w programowaniu", BigDecimal.valueOf(150));
            productRepo.save(product);
        }


    }


}
